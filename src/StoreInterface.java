
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StoreInterface extends Remote {

	public float getPrice(String Code_Ingredient) throws RemoteException;
}
