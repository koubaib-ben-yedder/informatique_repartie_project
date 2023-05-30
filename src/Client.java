
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

		float value_1;

		float value_2;

		float value_3;

		Registry registry_1 = LocateRegistry.getRegistry("127.0.0.1", 3001);
		StoreInterface magasin_1 = (StoreInterface) registry_1.lookup("magasin_1");

		Registry registry_2 = LocateRegistry.getRegistry("127.0.0.2", 3002);
		StoreInterface magasin_2 = (StoreInterface) registry_2.lookup("magasin_2");

		Registry registry_3 = LocateRegistry.getRegistry("127.0.0.3", 3003);
		StoreInterface magasin_3 = (StoreInterface) registry_3.lookup("magasin_3");

		while (true) {

			System.out.println("-> give me your choose");
			Scanner input = new Scanner(System.in);

			String value_0 = input.nextLine();

			value_1 = magasin_1.getPrice(value_0);

			value_2 = magasin_2.getPrice(value_0);

			value_3 = magasin_3.getPrice(value_0);

			if (((value_1 > value_2) && (value_2 > value_3)) || ((value_2 > value_1) &&
					(value_1 > value_3))) {

				System.out.println("Le prix le plus bas de l ingredient " + value_0
						+ " est de " + value_3 + " et se trouve chez magasin 3.");
			} else {

				if (((value_1 > value_3) && (value_3 > value_2)) || ((value_3 > value_1) &&
						(value_1 > value_2))) {

					System.out.println("Le prix le plus bas de l ingredient " + value_0
							+ " est de " + value_2 + " et se trouve chez magasin 2.");
				} else {

					if (((value_2 > value_3) && (value_3 > value_1)) || ((value_3 > value_2) &&
							(value_2 > value_1))) {

						System.out.println("Le prix le plus bas de l ingredient " + value_0
								+ " est de " + value_1 + " et se trouve chez magasin 1.");
					} else {

						if (value_0.equals("exit")) {

							break;
						} else {

							System.out.println("FAQ : Number should be between 1 and 4");
						}
					}
				}
			}

		}

	}

}
