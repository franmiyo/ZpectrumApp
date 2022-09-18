package ZpectrumApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ZpectrumApp.DTO.CryptoDTO;

public class Test2peticionTokens {
	static final String accountApiElrond = "https://api.elrond.com/accounts/erd18alaelkaha93wy88w67j4e8ehq9jkd7ydnqa2g6j3627nzukgsgsj6ap3j/tokens";

	public static void main(String[] args) {

		StringBuilder resultado = new StringBuilder();
		String proceso = "";
		List<CryptoDTO> cryptos3 = null;
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
						mapper.getTypeFactory().constructCollectionType(List.class, CryptoDTO.class));

			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		for (CryptoDTO cryptoDTO : cryptos3) {
			System.out.println(cryptoDTO.getCryptoName());
			System.out.println(cryptoDTO.getBalance());
			String balance = cryptoDTO.getBalance();

			if (balance.length() > cryptoDTO.getDecimals()) {
				String part1 = balance.substring(0, (balance.length() - cryptoDTO.getDecimals()));
				String part2 = balance.substring(balance.length() - cryptoDTO.getDecimals(), balance.length());

				String finalString = part1 + "." + part2;
				cryptoDTO.setBalance(finalString);
				System.out.println(finalString);
			} else {
				// TODO cuando el balance es < 0
				if (cryptoDTO.getDecimals() - balance.length() == 0) {
					String finalString = "0." + cryptoDTO.getBalance();
					cryptoDTO.setBalance(finalString);
					System.out.println(finalString);
				} else {
					String finalString = "0.";
					String process = "";
					int primeraPosicion = cryptoDTO.getDecimals() - balance.length();
					int[] ceros = new int[primeraPosicion];
					for (int i = 0; i < ceros.length; i++) {
						ceros[i] = 0;
						process += ceros[i];
					}
					finalString += process + cryptoDTO.getBalance();
					cryptoDTO.setBalance(finalString);
					System.out.println(finalString);
				}

			}
		}
	}
}
