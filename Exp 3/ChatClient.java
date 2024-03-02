import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serverIP = InetAddress.getByName("localhost");
            byte[] sendData;
            byte[] receiveData = new byte[1024];
            while (true) {
                String message = "Hello from Client";
                sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
                        serverIP, 9876);
                clientSocket.send(sendPacket);
                DatagramPacket receivePacket = new DatagramPacket(receiveData,
                        receiveData.length);
                clientSocket.receive(receivePacket);
                String replyMessage = new String(receivePacket.getData());
                System.out.println("Server: " + replyMessage.trim());
                Thread.sleep(2000); // Wait for 2 seconds before sending the next message
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}