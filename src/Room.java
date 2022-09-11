
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Room {
    private int ID;
    private ThreadServer user1;
    private ThreadServer user2;
    private String password;
    private UserData userData;

    public int getID() {
        return ID;
    }

    public ThreadServer getUser2() {
        return user2;
    }

    public ThreadServer getUser1() {
        return user1;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public Room(ThreadServer user1) {
        System.out.println("Tạo phòng thành công, ID là: "+Server.ID_room);
        this.password=" ";
        this.ID = Server.ID_room++;
        userData = new UserData();
        this.user1 = user1;
        this.user2 = null;
    }
    
    public int getNumberOfUser(){
        return user2==null?1:2;
    }
    
    public void setUser2(ThreadServer user2){
        this.user2 = user2;
    }
    
    public void boardCast(String message){
        try {
            user1.write(message);
            user2.write(message);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public int getCompetitorID(int ID_ClientNumber){
        if(user1.getClientNumber()==ID_ClientNumber)
            return user2.getUser().getID();
        return user1.getUser().getID();
    }
    public ThreadServer getCompetitor(int ID_ClientNumber){
        if(user1.getClientNumber()==ID_ClientNumber)
            return user2;
        return user1;
    }
    
    public void setUsersToPlaying(){
        userData.updateToPlaying(user1.getUser().getID());
        if(user2!=null){
            userData.updateToPlaying(user2.getUser().getID());
        }
    }
    public void setUsersToNotPlaying(){
        userData.updateToNotPlaying(user1.getUser().getID());
        if(user2!=null){
            userData.updateToNotPlaying(user2.getUser().getID());
        }
    }

    
    public void increaseNumberOfGame(){
        userData.addGame(user1.getUser().getID());
        userData.addGame(user2.getUser().getID());
    }
    
    public void increaseNumberOfDraw(){
        userData.addDrawGame(user1.getUser().getID());
        userData.addDrawGame(user2.getUser().getID());
    }
    
    public void decreaseNumberOfGame(){
        userData.decreaseGame(user1.getUser().getID());
        userData.decreaseGame(user2.getUser().getID());
    }
    
    
}