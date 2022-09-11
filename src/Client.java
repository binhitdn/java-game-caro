import javax.swing.JFrame;



public class Client {
    public enum View{
        LOGIN,
        REGISTER,
        HOMEPAGE,
        ROOMLIST,
        FINDROOM,
        WAITINGROOM,
        GAMECLIENT,
        CREATEROOMPASSWORD,
        JOINROOMPASSWORD,
        COMPETITORINFO,
        RANK,
        GAMENOTICE,
        ROOMNAMEFRM
    }
    public static User user;
    public static DangNhap loginFrm;
    public static DangKi registerFrm;
    public static Home homePageFrm;
    public static RoomListFrm roomListFrm;
    public static FindCompetitor findRoomFrm;
    public static RoomWait roomWait;
    public static GameFrame gameFrame;
    public static RoomPassword createRoomPasswordFrm;
    public static joinRoomPasswordFrm joinRoomPasswordFrm;
    public static CompetitorInfoFrm competitorInfoFrm;
    public static Notice notice;
    public static RoomNameFrm roomNameFrm;
    public static ThreadClient threadClient;
    public Client() {
    }

    public static JFrame getVisibleJFrame(){
        if(roomListFrm!=null&&roomListFrm.isVisible())
            return roomListFrm;
        if(createRoomPasswordFrm!=null&&createRoomPasswordFrm.isVisible()){
            return createRoomPasswordFrm;
        }
        if(joinRoomPasswordFrm!=null&&joinRoomPasswordFrm.isVisible()){
            return joinRoomPasswordFrm;
        }
       
        return homePageFrm;
    }
    public void initView(){
        
        loginFrm = new DangNhap();
        loginFrm.setVisible(true);
        threadClient = new ThreadClient();
        threadClient.run();
    }
    
    public static void openView(View viewName){
        if(viewName != null){
            switch(viewName){
                case LOGIN:
                    loginFrm = new DangNhap();
                    loginFrm.setVisible(true);
                    break;
                case REGISTER:
                    registerFrm = new DangKi();
                    registerFrm.setVisible(true);
                    break;
                case HOMEPAGE:
                    homePageFrm = new Home();
                    homePageFrm.setVisible(true);
                    break;
                case ROOMLIST:
                    roomListFrm = new RoomListFrm();
                    roomListFrm.setVisible(true);
                
                case FINDROOM:
                    findRoomFrm = new FindCompetitor();
                    findRoomFrm.setVisible(true);
                    break;
                case WAITINGROOM:
                    roomWait = new RoomWait();
                    roomWait.setVisible(true);
                    break;
                
                case CREATEROOMPASSWORD:
                    createRoomPasswordFrm = new RoomPassword();
                    createRoomPasswordFrm.setVisible(true);
                    break;
               
                
                case ROOMNAMEFRM:
                    roomNameFrm = new RoomNameFrm();
                    roomNameFrm.setVisible(true);
            }
        }
    }
    public static void openView(View viewName, int arg1, String arg2){
        if(viewName != null){
            switch(viewName){
                case JOINROOMPASSWORD:
                    joinRoomPasswordFrm = new joinRoomPasswordFrm(arg1, arg2);
                    joinRoomPasswordFrm.setVisible(true);
                    break;
               
            }
        }
    }
    public static void openView(View viewName, User competitor, int room_ID, int isStart, String competitorIP){
        if(viewName != null){
            switch(viewName){
                case GAMECLIENT:
                    gameFrame = new GameFrame(competitor, room_ID, isStart, competitorIP);
                    gameFrame.setVisible(true);
                    break;
            }
        }
    }
    public static void openView(View viewName, User User){
        if(viewName != null){
            switch(viewName){
                case COMPETITORINFO:
                    competitorInfoFrm = new CompetitorInfoFrm(User);
                    competitorInfoFrm.setVisible(true);
                    break;
            }
        }
    }
    public static void openView(View viewName, String arg1, String arg2){
        if(viewName != null){
            switch(viewName){
                case GAMENOTICE:
                    notice = new Notice(arg1, arg2);
                    notice.setVisible(true);
                    break;
                case LOGIN:
                    loginFrm = new DangNhap(arg1, arg2);
                    loginFrm.setVisible(true);
            }
        }
    }
    public static void closeView(View viewName){
        if(viewName != null){
            switch(viewName){
                case LOGIN:
                    loginFrm.dispose();
                    break;
                case REGISTER:
                    registerFrm.dispose();
                    break;
                case HOMEPAGE:
                    homePageFrm.dispose();
                    break;
                case ROOMLIST:
                    roomListFrm.dispose();
                    break;
                
                    
                case FINDROOM:
                    findRoomFrm.stopAllThread();
                    findRoomFrm.dispose();
                    break;
                case WAITINGROOM:
                    roomWait.dispose();
                    break;
                case GAMECLIENT:
                    gameFrame.stopAllThread();
                    gameFrame.dispose();
                    break;
                case CREATEROOMPASSWORD:
                    createRoomPasswordFrm.dispose();
                    break;
                case JOINROOMPASSWORD:
                    joinRoomPasswordFrm.dispose();
                    break;
                case COMPETITORINFO:
                    competitorInfoFrm.dispose();
                    break;
                
                case GAMENOTICE:
                    notice.dispose();
                    break;
               
               
                case ROOMNAMEFRM:
                    roomNameFrm.dispose();
                    break;
            }
            
        }
    }
    
    public static void closeAllViews(){
        if(loginFrm!=null) loginFrm.dispose();
        if(registerFrm!=null) registerFrm.dispose();
        if(homePageFrm!=null) homePageFrm.dispose();
        if(roomListFrm!=null) roomListFrm.dispose();
       
        if(findRoomFrm!=null){
            findRoomFrm.stopAllThread();
            findRoomFrm.dispose();
        } 
        if(roomWait!=null) roomWait.dispose();
        if(gameFrame!=null){
            gameFrame.stopAllThread();
            gameFrame.dispose();
        } 
        if(createRoomPasswordFrm!=null) createRoomPasswordFrm.dispose();
        if(joinRoomPasswordFrm!=null) joinRoomPasswordFrm.dispose();
        if(competitorInfoFrm!=null) competitorInfoFrm.dispose();

        if(notice!=null) notice.dispose();
       
    
        if(roomNameFrm!=null) roomNameFrm.dispose();
    }
    
  
    public static void main(String[] args) {
        new Client().initView();
    }
}
