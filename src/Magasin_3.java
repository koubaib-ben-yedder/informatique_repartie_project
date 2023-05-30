
//import java.rmi.Naming;
import java.rmi.registry.*;
//import java.rmi.server.UnicastRemoteObject;

public class Magasin_3 {

	public static void main(String[] args) throws Exception {

		StoreManager_3 StoreManager_3 = new StoreManager_3();
		// StoreInterface StoreInterface = (StoreInterface) new StoreManager();
		Registry registry = LocateRegistry.createRegistry(3003);
		registry.bind("magasin_3", StoreManager_3);
		System.out.println("-> server of magasin 3 is ready");

	}
}
