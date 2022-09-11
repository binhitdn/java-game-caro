
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadServers {
    private List<ThreadServer> listServerThreads;

    public List<ThreadServer> getListServerThreads() {
        return listServerThreads;
    }

    public ThreadServers() {
        listServerThreads = new ArrayList<>();
    }

    public void add(ThreadServer serverThread){
        listServerThreads.add(serverThread);
    }
    
    public void mutilCastSend(String message){ //like sockets.emit in socket.io
        for(ThreadServer serverThread : Server.threadServers.getListServerThreads()){
            try {
                serverThread.write(message);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void boardCast(int id, String message){
        for(ThreadServer serverThread : Server.threadServers.getListServerThreads()){
            if (serverThread.getClientNumber() == id) {
                continue;
            } else {
                try {
                    serverThread.write(message);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    public int getLength(){
        return listServerThreads.size();
    }
    
    public void sendMessageToUserID(int id, String message){
        for(ThreadServer serverThread : Server.threadServers.getListServerThreads()){
            if(serverThread.getUser().getID()==id){
                try {
                    serverThread.write(message);
                    break;
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    public ThreadServer getServerThreadByUserID(int ID){
        for(int i=0; i<Server.threadServers.getLength(); i++){
            if(Server.threadServers.getListServerThreads().get(i).getUser().getID()==ID){
                return Server.threadServers.listServerThreads.get(i);
            }
        }
        return null;
    }
    
    public void remove(int id){
        for(int i=0; i<Server.threadServers.getLength(); i++){
            if(Server.threadServers.getListServerThreads().get(i).getClientNumber()==id){
                Server.threadServers.listServerThreads.remove(i);
            }
        }
    }
}