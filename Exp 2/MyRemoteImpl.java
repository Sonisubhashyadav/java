import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemoteInterface {
    public MyRemoteImpl() throws RemoteException {
        // Constructor
    }

    @Override
    public String sayHello() throws RemoteException {
        return "Hello, World!";
    }
}
