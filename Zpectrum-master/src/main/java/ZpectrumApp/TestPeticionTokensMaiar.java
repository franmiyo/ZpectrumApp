package ZpectrumApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ZpectrumApp.Modelo.TokensMaiar;

// TODO: Auto-generated Javadoc
/**
 * The Class TestPeticionTokensMaiar.
 */
public class TestPeticionTokensMaiar {

	/** The Constant accountApiElrond. */
	static final String accountApiElrond = "https://api.elrond.com/mex/tokens";

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		StringBuilder resultado = new StringBuilder();
		String proceso = "";
		List<TokensMaiar> cryptos3 = null;
		ObjectMapper mapper = new ObjectMapper();

		try {

			URL url = new URL(accountApiElrond);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			System.out.println(connection.getResponseCode());
			System.out.println(connection.getResponseMessage());
			String linea = "";

			while ((linea = rd.readLine()) != null) {

				resultado.append(linea);

			}

			proceso = resultado.toString();

			try {
				cryptos3 = mapper.readValue(proceso,
						mapper.getTypeFactory().constructCollectionType(List.class, TokensMaiar.class));

			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(cryptos3);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		for (TokensMaiar crypto : cryptos3) {



			if (crypto.toString().contains("E-")) {

				String process1 = "";
				String lastC = String.valueOf(crypto.getPrice())
						.substring(String.valueOf(crypto.getPrice()).length() - 1);
				int lastCN = Integer.parseInt(lastC);
				int length = lastCN;
				length = length - 1;
				int[] ceros = new int[length];
				for (int i = 0; i < ceros.length; i++) {
					ceros[i] = 0;
					process1 += ceros[i];
				}
				String precio = String.valueOf(crypto.getPrice());
				process1 += precio;
				String aux = process1.substring(process1.length() - 3);
				process1 = process1.replace(aux, "");
				process1 = process1.replace(".", "");
				String process2 = "0.";
				process2 += process1;
				System.out.println(process2);

			}


		}

	}

}
