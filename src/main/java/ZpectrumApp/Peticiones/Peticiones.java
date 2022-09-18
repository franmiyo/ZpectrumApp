package ZpectrumApp.Peticiones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ZpectrumApp.DTO.CryptoDTO;
import ZpectrumApp.DTO.NftDTO;
import ZpectrumApp.Modelo.TokensMaiar;

@Service
public class Peticiones {

	private static String accountApiElrond = "https://api.elrond.com/accounts/";
	private static String accountApiElrondMaiarExchange = "https://api.elrond.com/mex/tokens";
	private static String accountApiElrondBalance = "https://api.elrond.com/address/";
	private static ObjectMapper mapper = new ObjectMapper();

	public boolean connectionTest(String erd) {
		requestReset();
		String consulta = accountApiElrond;
		consulta += erd + "/tokens";
		URL url;
		try {
			url = new URL(consulta);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			if (connection.getResponseCode() == 200) {
				return true;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	public List<CryptoDTO> obtainTokensAccount(String erd) {

		requestReset();
		String consulta = accountApiElrond;
		consulta += erd + "/tokens";
		StringBuilder constructor = new StringBuilder();
		List<CryptoDTO> cryptoList = new ArrayList<CryptoDTO>();
		String line = "";
		String process = "";

		try {

			URL url = new URL(consulta);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			while ((line = rd.readLine()) != null) {

				constructor.append(line);

			}

			process = constructor.toString();
			rd.close();

			try {
				cryptoList = mapper.readValue(process,
						mapper.getTypeFactory().constructCollectionType(List.class, CryptoDTO.class));
			}

			catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		for (CryptoDTO cryptoDTO : cryptoList) {

			String balance = cryptoDTO.getBalance();

			if (balance.length() > cryptoDTO.getDecimals()) {

				String part1 = balance.substring(0, (balance.length() - cryptoDTO.getDecimals()));
				String part2 = balance.substring(balance.length() - cryptoDTO.getDecimals(), balance.length());
				String finalString = part1 + "." + part2;
				cryptoDTO.setBalance(finalString);

			} else {
				// TODO cuando el balance es < 0
				if (cryptoDTO.getDecimals() - balance.length() == 0) {

					String finalString = "0." + cryptoDTO.getBalance();
					cryptoDTO.setBalance(finalString);

				} else {
					String finalString = "0.";
					String process2 = "";
					int firstPosition = cryptoDTO.getDecimals() - balance.length();
					int[] ceros = new int[firstPosition];
					for (int i = 0; i < ceros.length; i++) {
						ceros[i] = 0;
						process2 += ceros[i];
					}
					finalString += process2 + cryptoDTO.getBalance();
					cryptoDTO.setBalance(finalString);
				}

			}
		}

		return cryptoList;
	}

	public List<NftDTO> obtainNftAccount(String erd) {

		requestReset();
		int numberOfNft = numberOfNft(erd);
		String consulta = accountApiElrond;
		consulta += erd + "/nfts?size=" + numberOfNft;
		String line = "";
		String process = "";
		List<NftDTO> nfts = null;
		StringBuilder constructor = new StringBuilder();

		try {

			URL url = new URL(consulta);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			while ((line = rd.readLine()) != null) {

				constructor.append(line);

			}

			process = constructor.toString();
			rd.close();

			try {

				nfts = mapper.readValue(process,
						mapper.getTypeFactory().constructCollectionType(List.class, NftDTO.class));

			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return nfts;
	}

	public int obtainNumberOfNft(String erd) {

		requestReset();
		String consulta = accountApiElrond;
		consulta += erd + "/nfts/count";
		String line = "";
		String process = "";
		int result = 0;
		StringBuilder constructor = new StringBuilder();

		try {

			URL url = new URL(consulta);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			while ((line = rd.readLine()) != null) {

				constructor.append(line);

			}

			process = constructor.toString();

			try {

				result = mapper.readValue(process,
						mapper.getTypeFactory().constructCollectionType(List.class, Integer.class));
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return result;

	}

	public List<TokensMaiar> tokensOnMaiar() {

		String line = "";
		String process = "";
		List<TokensMaiar> tokens = null;
		StringBuilder constructor = new StringBuilder();

		try {

			URL url = new URL(accountApiElrondMaiarExchange);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			while ((line = rd.readLine()) != null) {

				constructor.append(line);

			}

			process = constructor.toString();

			try {

				tokens = mapper.readValue(process,
						mapper.getTypeFactory().constructCollectionType(List.class, TokensMaiar.class));

				return tokens;

			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return null;
	}

	public double obtainBalanceAccount(String erd) {

		requestReset();
		String consulta = accountApiElrondBalance;
		consulta += erd + "/balance";
		int contador = 19;
		int contador2 = 0;
		double response = 0.0;
		String process3 = "";
		String decimals = "";
		String numbers = "";
		String line;
		String holder;
		String process1 = "";
		String process2 = "0.";

		try {

			URL url = new URL(consulta);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			System.out.println(connection.getResponseCode());
			System.out.println(connection.getResponseMessage());

			while ((line = rd.readLine()) != null) {

				process3 += line;

			}

			// la variable proceso es un String con formato Json
			JSONObject json = new JSONObject(process3);
			System.out.println(process3);
			// Obtenemos la propiedad dentro de una rama del json
			holder = json.getJSONObject("data").getString("balance");

			if (holder.length() < 18) {
				do {
					process1 += "0";
				} while ((holder.length() + process1.length()) < 18);
				process1 += holder;

				process2 += process1;
				double respuesta = Double.parseDouble(process2);

				return respuesta;
			}

			if (holder.length() >= 18) {
				for (int i = holder.length(); i >= 0; i--) {
					contador2++;

					// substring con la parte decimal
					if (contador == contador2) {
						decimals += holder.substring(i);
					}
					// substring con la parte entera
					if (contador2 >= contador) {
						numbers += holder.substring(0, i);
					}

				}

				String devolucion = numbers + "." + decimals;
				response = Double.parseDouble(devolucion);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return response;

	}

	public int getShard(String erd) {

		requestReset();
		String consulta = accountApiElrond;
		String proceso = "";
		String linea;
		int response = 0;
		consulta += erd;

		try {

			URL url = new URL(consulta);
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
			response = json.getInt("shard");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return response;
	}

	private int numberOfNft(String erd) {
		requestReset();
		String consulta = accountApiElrond;
		String proceso = "";
		String linea;
		int response = 0;
		consulta += erd + "/nfts/count";

		try {

			URL url = new URL(consulta);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			System.out.println(connection.getResponseCode());
			System.out.println(connection.getResponseMessage());

			while ((linea = rd.readLine()) != null) {

				proceso += linea;

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		response = Integer.parseInt(proceso);

		return response;
	}

	private static void requestReset() {
		accountApiElrond = "https://api.elrond.com/accounts/";
		accountApiElrondBalance = "https://api.elrond.com/address/";
	}

}
