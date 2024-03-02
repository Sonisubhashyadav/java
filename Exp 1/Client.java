
import java.net.*;
import java.io.*;

public class Client {
    public static void main(String args[]) {
        try {
            Socket s = new Socket("localhost", 1201);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());
            InputStreamReader isr = new InputStreamReader(System.in);
            System.out.println("\n****Client process Started***\n");
            System.out.println("\n****enter 2 values to pass them to the server****\n");
            BufferedReader br = new BufferedReader(isr);
            int a = Integer.parseInt(br.readLine());
            System.out.println("number1 =====>" + a);
            dos.writeInt(+a);
            int b = Integer.parseInt(br.readLine());
            System.out.println("number1 =====>" + b);
            dos.writeInt(+b);
            int result = dis.readInt();
            System.out.println("\n......Client process has received result from server....\n");
            System.out.println("\n The addition of 2 numbers \n a+b= " + result);
            s.close();
        } catch (Exception e) {
            System.out.println("Excepton is " + e);
        }
    }
}