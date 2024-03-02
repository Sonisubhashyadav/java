
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class MyRMIClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            MyRemoteInterface obj = (MyRemoteInterface) registry.lookup("MyRemote");
            String message = obj.sayHello();
            System.out.println("Response from server: " + message);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
