
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadServer implements Runnable {
    
    private UserAM userAM;
    private Socket socketOfServer;
    private int clientNumber;
    private BufferedReader is;
    private BufferedWriter os;
    private boolean isClosed;
    private Room room;
    private UserData userData;
    private String clientIP;
    
    public BufferedReader getIs() {
        return is;
    }
    
    public BufferedWriter getOs() {
        return os;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
    
    public int getClientNumber() {
        return clientNumber;
    }

    public UserAM getUser() {
        return userAM;
    }


    public Room getRoom() {
        return room;
    }

    public String getClientIP() {
        return clientIP;
    }

    public void setUser(UserAM userAM) {
        this.userAM = userAM;
    }
    
    public ThreadServer(Socket socketOfServer, int clientNumber) {
        this.socketOfServer = socketOfServer;
        this.clientNumber = clientNumber;
        System.out.println("Server thread number " + clientNumber + " Started");
        userData = new UserData();
        isClosed = false;
        room = null;
        //Trường hợp test máy ở server sẽ lỗi do hostaddress là localhost
        if(this.socketOfServer.getInetAddress().getHostAddress().equals("127.0.0.1")){
            clientIP = "127.0.0.1";
        }
        else{
            clientIP = this.socketOfServer.getInetAddress().getHostAddress();
        }
        
    }
    public String getStringFromUser(UserAM user1){
        return ""+user1.getID()+","+user1.getUsername()
                                +","+user1.getPassword()+","+user1.getNickname()+","+
                                user1.getAvatar()+","+user1.getNumberOfGame()+","+
                                user1.getNumberOfwin()+","+user1.getNumberOfDraw()+","+user1.getRank();
    }
    
    public void goToOwnRoom() throws IOException{
        write("go-to-room," + room.getID()+","+room.getCompetitor(this.getClientNumber()).getClientIP()+",1,"+getStringFromUser(room.getCompetitor(this.getClientNumber()).getUser()));
        room.getCompetitor(this.clientNumber).write("go-to-room," + room.getID()+","+this.clientIP+",0,"+getStringFromUser(userAM));
    }
    
    public void goToPartnerRoom() throws IOException{
        write("go-to-room," + room.getID()+","+room.getCompetitor(this.getClientNumber()).getClientIP()+",0,"+getStringFromUser(room.getCompetitor(this.getClientNumber()).getUser()));
         room.getCompetitor(this.clientNumber).write("go-to-room,"+ room.getID()+","+this.clientIP+",1,"+getStringFromUser(userAM));
    }
    
    @Override
    public void run() {
        try {
       
            is = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
            os = new BufferedWriter(new OutputStreamWriter(socketOfServer.getOutputStream()));
            System.out.println("Khời động luông mới thành công, ID là: " + clientNumber);
            write("server-send-id" + "," + this.clientNumber);
            String message;
            while (!isClosed) {
                message = is.readLine();
                if (message == null) {
                    break;
                }
                String[] messageSplit = message.split(",");
                
                if(messageSplit[0].equals("client-verify")){
                    System.out.println(message);
                    UserAM user1 = userData.verifyUser(new UserAM(messageSplit[1], messageSplit[2]));
                    if(user1==null)
                        write("wrong-user,"+messageSplit[1]+","+messageSplit[2]);
                    else if(!user1.getIsOnline()){
                        write("login-success,"+getStringFromUser(user1));
                        this.userAM = user1;
                        userData.updateToOnline(this.userAM.getID());
                        Server.threadServers.boardCast(clientNumber, "chat-server,"+user1.getNickname()+" đang online");
                        Server.admin.addMessage("["+user1.getID()+"] "+user1.getNickname()+ " đang online");
                    } 
                    
                }
                
                
                //Xử lý đăng kí
                if(messageSplit[0].equals("register")){
                   boolean checkdup = userData.checkDuplicated(messageSplit[1]);
                   if(checkdup) write("duplicate-username,");
                   else{
                       UserAM userRegister = new UserAM(messageSplit[1], messageSplit[2], messageSplit[3], messageSplit[4]);
                       userData.addUser(userRegister);
                       UserAM userRegistered = userData.verifyUser(userRegister);
                       this.userAM = userRegistered;
                       userData.updateToOnline(this.userAM.getID());
                       Server.threadServers.boardCast(clientNumber, "chat-server,"+this.userAM.getNickname()+" đang online");
                       write("login-success,"+getStringFromUser(this.userAM));
                   }
                }
                //Xử lý người chơi đăng xuất
                if(messageSplit[0].equals("offline")){
                    userData.updateToOffline(this.userAM.getID());
                    Server.admin.addMessage("["+userAM.getID()+"] "+userAM.getNickname()+" đã offline");
                    Server.threadServers.boardCast(clientNumber, "chat-server,"+this.userAM.getNickname()+" đã offline");
                    this.userAM=null;
                }
                
                //Xử lý chat toàn server
                if(messageSplit[0].equals("chat-server")){
                    Server.threadServers.boardCast(clientNumber,messageSplit[0]+","+ userAM.getNickname()+" : "+ messageSplit[1]);
                    Server.admin.addMessage("["+userAM.getID()+"] "+userAM.getNickname()+" : "+ messageSplit[1]);
                }
                //Xử lý vào phòng trong chức năng tìm kiếm phòng
                if(messageSplit[0].equals("go-to-room")){
                    int roomName = Integer.parseInt(messageSplit[1]);
                    boolean isFinded = false;
                    for (ThreadServer serverThread : Server.threadServers.getListServerThreads()) {
                        if(serverThread.getRoom()!=null&&serverThread.getRoom().getID()==roomName){
                            isFinded = true;
                            if(serverThread.getRoom().getNumberOfUser()==2){
                                write("room-fully,");
                            }
                            else{
                                if(serverThread.getRoom().getPassword()==null||serverThread.getRoom().getPassword().equals(messageSplit[2])){
                                    this.room = serverThread.getRoom();
                                    room.setUser2(this);
                                    room.increaseNumberOfGame();
                                    this.userData.updateToPlaying(this.userAM.getID());
                                    goToPartnerRoom();
                                }
                                else{
                                    write("room-wrong-password,");
                                }
                            }
                            break;
                        }
                    }
                    if(!isFinded){
                        write("room-not-found,");
                    }
                }
                //Xử lý lấy danh sách bảng xếp hạng
                if(messageSplit[0].equals("get-rank-charts")){
                    List<UserAM> ranks = userData.getUserStaticRank();
                    String res = "return-get-rank-charts,";
                    for(UserAM userAM : ranks){
                        res += getStringFromUser(userAM)+",";
                    }
                    System.out.println(res);
                    write(res);
                }
                //Xử lý tạo phòng
                if (messageSplit[0].equals("create-room")) {
                    room = new Room(this);
                    if (messageSplit.length == 2) {
                        room.setPassword(messageSplit[1]);
                        write("your-created-room," + room.getID() + "," + messageSplit[1]);
                        System.out.println("Tạo phòng mới thành công, password là " + messageSplit[1]);
                    } else {
                        write("your-created-room," + room.getID());
                        System.out.println("Tạo phòng mới thành công");
                    } 
                    userData.updateToPlaying(this.userAM.getID());
                }
                //Xử lý xem danh sách phòng trống
                if (messageSplit[0].equals("view-room-list")) {
                    String res = "room-list,";
                    int number = 1;
                    for (ThreadServer serverThread : Server.threadServers.getListServerThreads()) {
                        if(number>8) break;
                        if (serverThread.room != null && serverThread.room.getNumberOfUser() == 1) {
                            res += serverThread.room.getID() + "," + serverThread.room.getPassword() + ",";
                        }
                        number++;
                    }
                    write(res);
                    System.out.println(res);
                }
                
                //Xử lý tìm phòng nhanh
                if (messageSplit[0].equals("quick-room")) {
                    boolean isFinded = false;
                    for (ThreadServer serverThread : Server.threadServers.getListServerThreads()) {
                        if (serverThread.room != null && serverThread.room.getNumberOfUser() == 1 && serverThread.room.getPassword().equals(" ")) {
                            serverThread.room.setUser2(this);
                            this.room = serverThread.room;
                            room.increaseNumberOfGame();
                            System.out.println("Đã vào phòng " + room.getID());
                            goToPartnerRoom();
                            userData.updateToPlaying(this.userAM.getID());
                            isFinded = true;
                            //Xử lý phần mời cả 2 người chơi vào phòng
                            break;
                        }
                    }
                    
                    if (!isFinded) {
                        this.room = new Room(this);
                        userData.updateToPlaying(this.userAM.getID());
                        System.out.println("Không tìm thấy phòng, tạo phòng mới");
                    }
                }
                //Xử lý không tìm được phòng
                if (messageSplit[0].equals("cancel-room")) {
                    userData.updateToNotPlaying(this.userAM.getID());
                    System.out.println("Đã hủy phòng");
                    this.room = null;
                }
                //Xử lý khi có người chơi thứ 2 vào phòng
                if (messageSplit[0].equals("join-room")) {
                    int ID_room = Integer.parseInt(messageSplit[1]);
                    for (ThreadServer serverThread : Server.threadServers.getListServerThreads()) {
                        if (serverThread.room != null && serverThread.room.getID() == ID_room) {
                            serverThread.room.setUser2(this);
                            this.room = serverThread.room;
                            System.out.println("Đã vào phòng " + room.getID());
                            room.increaseNumberOfGame();
                            goToPartnerRoom();
                            userData.updateToPlaying(this.userAM.getID());
                            break;
                        }
                    }
                }
             
                
                //Xử lý khi người chơi đánh 1 nước
                if(messageSplit[0].equals("caro")){
                    room.getCompetitor(clientNumber).write(message);
                }
                if(messageSplit[0].equals("chat")){
                    room.getCompetitor(clientNumber).write(message);
                }
                if(messageSplit[0].equals("win")){
                    userData.addWinGame(this.userAM.getID());
                    room.increaseNumberOfGame();
                    room.getCompetitor(clientNumber).write("caro,"+messageSplit[1]+","+messageSplit[2]);
                    room.boardCast("new-game,");
                }
                if(messageSplit[0].equals("lose")){
                    userData.addWinGame(room.getCompetitor(clientNumber).userAM.getID());
                    room.increaseNumberOfGame();
                    room.getCompetitor(clientNumber).write("competitor-time-out");
                    write("new-game,");
                }
                if(messageSplit[0].equals("draw-request")){
                    room.getCompetitor(clientNumber).write(message);
                }
                if(messageSplit[0].equals("draw-confirm")){
                    room.increaseNumberOfDraw();
                    room.increaseNumberOfGame();
                    room.boardCast("draw-game,");
                }
                if(messageSplit[0].equals("draw-refuse")){
                    room.getCompetitor(clientNumber).write("draw-refuse,");
                }
                if(messageSplit[0].equals("voice-message")){
                    room.getCompetitor(clientNumber).write(message);
                }
                if(messageSplit[0].equals("left-room")){
                    if (room != null) {
                        room.setUsersToNotPlaying();
                        room.decreaseNumberOfGame();
                        room.getCompetitor(clientNumber).write("left-room,");
                        room.getCompetitor(clientNumber).room = null;
                        this.room = null;
                    }
                }
            }
        } catch (IOException e) {
            //Thay đổi giá trị cờ để thoát luồng
            isClosed = true;
            //Cập nhật trạng thái của user
            if(this.userAM!=null){
                userData.updateToOffline(this.userAM.getID());
                userData.updateToNotPlaying(this.userAM.getID());
                Server.threadServers.boardCast(clientNumber, "chat-server,"+this.userAM.getNickname()+" đã offline");
                Server.admin.addMessage("["+userAM.getID()+"] "+userAM.getNickname()+" đã offline");
            }
            
            //remove thread khỏi bus
            Server.threadServers.remove(clientNumber);
            System.out.println(this.clientNumber + " đã thoát");
            if (room != null) {
                try {
                    if (room.getCompetitor(clientNumber) != null) {
                        room.decreaseNumberOfGame();
                        room.getCompetitor(clientNumber).write("left-room,");
                        room.getCompetitor(clientNumber).room = null;
                    }
                    this.room = null;
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }
    }

    public void write(String message) throws IOException {
        os.write(message);
        os.newLine();
        os.flush();
    }
}