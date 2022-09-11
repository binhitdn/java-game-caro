
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {

    public static volatile ThreadServers threadServers;
    public static Socket socketOfServer;
    public static int ID_room;
    public static volatile Admin admin;

    public static void main(String[] args) {
        ServerSocket listener = null;
        threadServers = new ThreadServers();
        System.out.println("Server is waiting to accept user...");
        int clientNumber = 0;
        ID_room = 100;
        
        try {
            listener = new ServerSocket(12340);
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(
//                10, // corePoolSize
//                100, // maximumPoolSize
//                10, // thread timeout
//                TimeUnit.SECONDS,
//                new ArrayBlockingQueue<>(8) // queueCapacity
//        );
        admin = new Admin();
        admin.run();
        try {
            while (true) {
                socketOfServer = listener.accept();
                System.out.println(socketOfServer.getInetAddress().getHostAddress());
                ThreadServer serverThread = new ThreadServer(socketOfServer, clientNumber++);
                threadServers.add(serverThread);
                System.out.println("Số thread đang chạy là: "+threadServers.getLength());
//                executor.execute(serverThread);  
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                listener.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
