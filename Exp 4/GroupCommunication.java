import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;
public class GroupCommunication {
public static void main(String[] args) {
// Define the multicast group address and port
String multicastGroup = "230.0.0.1";
int port = 4446;
try {
// Create a multicast socket
InetAddress group = InetAddress.getByName(multicastGroup);
MulticastSocket socket = new MulticastSocket(port);
socket.joinGroup(group);
// Start a thread to listen for incoming messages
Thread listenerThread = new Thread(() -> {
try {
byte[] buf = new byte[1000];
DatagramPacket recv = new DatagramPacket(buf, buf.length);
while (true) {
socket.receive(recv);
String received = new String(recv.getData(), 0, recv.getLength());
System.out.println("Received: " + received);
}
} catch (IOException e) {
e.printStackTrace();
}
});
listenerThread.start();
// Send messages to the multicast group
Scanner scanner = new Scanner(System.in);
while (true) {
System.out.print("Enter message to send: ");
String message = scanner.nextLine();
DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(),
group, port);
socket.send(packet);
}
} catch (IOException e) {
e.printStackTrace();
}
}
}