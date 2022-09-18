package ZpectrumApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ZpectrumApp.DTO.NftDTO;

public class TestPeticionNft {

	static final String accountApiElrond = "https://api.elrond.com/accounts/erd18alaelkaha93wy88w67j4e8ehq9jkd7ydnqa2g6j3627nzukgsgsj6ap3j/nfts";

	public static void main(String[] args) {

		StringBuilder resultado = new StringBuilder();
		String proceso = "";
		List<NftDTO> nfts = null;
		ObjectMapper mapper = new ObjectMapper();

		try {

			URL url = new URL(accountApiElrond);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String linea = "";

			while ((linea = rd.readLine()) != null) {

				resultado.append(linea);

			}

			proceso = resultado.toString();

			try {
				nfts = mapper.readValue(proceso,
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
		for (NftDTO nft : nfts) {
			System.out.println(nft);
		}

	}

}
