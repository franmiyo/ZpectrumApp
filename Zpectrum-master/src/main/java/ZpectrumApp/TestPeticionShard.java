package ZpectrumApp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

// TODO: Auto-generated Javadoc
/**
 * The Class TestPeticionShard.
 */
public class TestPeticionShard {

	/** The Constant accountApiElrond. */
	static final String accountApiElrond = "https://api.elrond.com/accounts/erd18alaelkaha93wy88w67j4e8ehq9jkd7ydnqa2g6j3627nzukgsgsj6ap3j";
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		
		
		String proceso = "";
		String linea;
		String devolucion = "";
		int holder;

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
			
			//la variable proceso es un String con formato Json
		      JSONObject json = new JSONObject(proceso);
		      System.out.println(proceso);
		    //Obtenemos la propiedad dentro de una rama del json
		      holder = json.getInt("shard");
			//mostramos la propiedad del Json
		      System.out.println(holder);



			

			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
