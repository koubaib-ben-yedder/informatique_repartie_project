
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StoreManager_1 extends UnicastRemoteObject implements StoreInterface {

	Magasin mag;

	File file;

	List<Float> list = new ArrayList<Float>();

	String line;

	public StoreManager_1() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub

		try {

			file = new File("magasin_file_1.txt");

			if (file.createNewFile()) {

				System.out.println("New File is created " + file.getAbsolutePath() + " ! ");

			} else {

				System.out.println("File already exists " + file.getAbsolutePath() + " . ");

			}
		} catch (IOException e) {

			e.printStackTrace();
		}

		System.out.println(file.getAbsolutePath());

		try {

			BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));

			while ((line = br.readLine()) != null) {

				list.add(Float.valueOf(line));

			}

		} catch (Exception e) {

			// TODO: handle exception

			e.printStackTrace();

		}

		mag = new Magasin(list.get(0), list.get(1), list.get(2),
				list.get(3));

	}

	@Override
	public float getPrice(String Code_Ingredient) throws RemoteException {

		switch (Code_Ingredient) {

			case "1": {

				return mag.cornichons;
			}

			case "2": {

				return mag.safran;

			}

			case "3": {

				return mag.sel;

			}

			case "4": {

				return mag.poivre;

			}

		}
		return 0;

	}

}
