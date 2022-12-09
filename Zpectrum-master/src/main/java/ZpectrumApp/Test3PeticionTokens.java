package ZpectrumApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;

import ZpectrumApp.DTO.CryptoDTO;

// TODO: Auto-generated Javadoc
/**
 * The Class Test3PeticionTokens.
 */
public class Test3PeticionTokens {

	/** The Constant accountApiElrond. */
	static final String accountApiElrond = "https://api.elrond.com/accounts/erd18alaelkaha93wy88w67j4e8ehq9jkd7ydnqa2g6j3627nzukgsgsj6ap3j/tokens";

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		try {

			URL url = new URL(accountApiElrond);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String proceso = "";
			StringBuilder resultado = new StringBuilder();

			while ((proceso = rd.readLine()) != null) {

				resultado.append(proceso);

			}
			rd.close();
			
			
			
			
			
			
			System.out.println(resultado.toString());

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
