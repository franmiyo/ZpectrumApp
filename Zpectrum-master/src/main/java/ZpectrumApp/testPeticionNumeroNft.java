package ZpectrumApp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


// TODO: Auto-generated Javadoc
/**
 * The Class testPeticionNumeroNft.
 */
public class testPeticionNumeroNft {
	
	/** The Constant accountApiElrond. */
	static final String accountApiElrond = "https://api.elrond.com/accounts/erd18alaelkaha93wy88w67j4e8ehq9jkd7ydnqa2g6j3627nzukgsgsj6ap3j/nfts/count";
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
	
		String proceso = "";
		String linea;


		try {

			URL url = new URL(accountApiElrond);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			System.out.println(connection.getResponseCode());
			System.out.println(connection.getResponseMessage());
			
			while ((linea = rd.readLine()) != null) {

				proceso += linea;

			}
			
			//la variable proceso es un String de un numero entero con la cantidad de nft que pertenecen a esa cuenta ERD
			System.out.println(proceso);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
