
//import java.rmi.Naming;
import java.rmi.registry.*;
//import java.rmi.server.UnicastRemoteObject;

public class Magasin_1 {

	public static void main(String[] args) throws Exception {

		StoreManager_1 StoreManager_1 = new StoreManager_1();
		// StoreInterface StoreInterface = (StoreInterface) new StoreManager();
		Registry registry = LocateRegistry.createRegistry(3001);
		registry.bind("magasin_1", StoreManager_1);
		System.out.println("-> server of magasin 1 is ready");

	}
}
