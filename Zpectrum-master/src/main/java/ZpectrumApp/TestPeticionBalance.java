package ZpectrumApp;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

// TODO: Auto-generated Javadoc
/**
 * The Class TestPeticionBalance.
 */
public class TestPeticionBalance {

	/** The Constant accountApiElrond. */
	static final String accountApiElrond = "https://api.elrond.com/address/erd18alaelkaha93wy88w67j4e8ehq9jkd7ydnqa2g6j3627nzukgsgsj6ap3j/balance";

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		String proceso = "";
		String linea;
		String devolucion = "";
		String holder;
		String devolucion2 = "";
		String devolucion3 = "0.";

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

			// la variable proceso es un String con formato Json
			JSONObject json = new JSONObject(proceso);
			System.out.println(proceso);
			// Obtenemos la propiedad dentro de una rama del json
			holder = json.getJSONObject("data").getString("balance");
			System.out.println(holder.length());
			if (holder.length() < 18) {
				do {
					devolucion2 += "0";
				} while ((holder.length() + devolucion2.length()) < 18);
				devolucion2 += holder;
			}
			devolucion3 += devolucion2;
			double respuesta = Double.parseDouble(devolucion3);
			System.out.println(respuesta);// valor a devolver

			String decimals = "";
			String numbers = "";
			int contador = 19;
			int contador2 = 0;
			if (holder.length() >= 18) {
				for (int i = holder.length(); i >= 0; i--) {
					contador2++;

					// substring con la parte decimal
					if (contador == contador2) {
						System.out.println(holder.substring(i));
						decimals += holder.substring(i);
					}
					// substring con la parte entera
					if (contador2 >= contador) {
						numbers += holder.substring(0, i);
					}

				}
				System.out.println(numbers);
				devolucion += numbers + "." + decimals;
				System.out.println(devolucion);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
