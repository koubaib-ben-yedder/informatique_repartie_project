
//import java.rmi.Naming;
import java.rmi.registry.*;
//import java.rmi.server.UnicastRemoteObject;

public class Magasin_2 {

	public static void main(String[] args) throws Exception {

		StoreManager_2 StoreManager_2 = new StoreManager_2();
		// StoreInterface StoreInterface = (StoreInterface) new StoreManager();
		Registry registry = LocateRegistry.createRegistry(3002);
		registry.bind("magasin_2", StoreManager_2);
		System.out.println("-> server of magasin 2  is ready");

	}
}
