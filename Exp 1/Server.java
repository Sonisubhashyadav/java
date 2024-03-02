import java.net.*;
import java.io.*;

public class Server {
    public static void main(String args[]) {
        System.out.println("\n*** INTERPROCESS COMMUNICATION ****\n");
        System.out.println("\n*** SERVER PROCESS STARTED ****\n");
        System.out.println("\n*** SERVER IS READY AND WAITING TO RECEIVE DATA FROMCLIENT PROCESS ON PORT ****" + 1200);
        try {
            ServerSocket ss = new ServerSocket(1201); // 1200 is a port number
            Socket clientSocket = ss.accept();
            System.out.println("\n Client is connected with IP Address" + clientSocket.getInetAddress()
                    + "and port number " + clientSocket.getPort());
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            int a = dis.readInt();
            System.out.println("\n Server Received");
            System.out.println("\n Number 1 =====>" + a);
            int b = dis.readInt();
            System.out.println("\n Number 2 =====>" + b);
            int c = a + b;
            dos.writeInt(c);
            System.out
                    .println("\n Server process has executed request process and sent result" + c + " to theclient \n");
            clientSocket.close();
            System.out.println("\n Server Process exiting");
            ss.close();
        } catch (Exception e) {
            System.out.println("exception:" + e);
        }
    }
}