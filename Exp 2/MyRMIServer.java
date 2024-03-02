import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class MyRMIServer {
    public static void main(String[] args) {
        try {
            MyRemoteImpl obj = new MyRemoteImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("MyRemote", obj);
            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
