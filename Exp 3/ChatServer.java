import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(9876);
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
            System.out.println("Server started...");
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData,
                        receiveData.length);
                serverSocket.receive(receivePacket);
                String message = new String(receivePacket.getData());
                System.out.println("Client: " + message.trim());
                InetAddress clientIP = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                String replyMessage = "Hello from Server";
                sendData = replyMessage.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
                        clientIP, clientPort);
                serverSocket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}