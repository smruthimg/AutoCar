/**
 * Created by smrut on 10/29/2017.
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {
    String sayHello(String msg) throws RemoteException;

}
