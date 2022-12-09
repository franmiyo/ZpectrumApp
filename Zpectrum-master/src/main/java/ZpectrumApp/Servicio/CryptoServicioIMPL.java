package ZpectrumApp.Servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ZpectrumApp.DTO.CryptoDTO;
import ZpectrumApp.DTO.NftDTO;
import ZpectrumApp.DTO.UsuarioDTO;
import ZpectrumApp.Modelo.Crypto;
import ZpectrumApp.Modelo.Nft;
import ZpectrumApp.Modelo.Usuario;
import ZpectrumApp.Repositorio.UsuarioRepositorio;

/**
 * The Class CryptoServicioIMPL.
 * 
 * @author Francisco González
 * @version 1.0
 */
@Service
public class CryptoServicioIMPL implements CryptoServicio {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	/**
	 * Map entity. Converts DTO to entity.
	 *
	 * @param cryptoDTO the crypto currency DTO
	 * @return the crypto currency
	 */
	public Crypto mapearEntidad(CryptoDTO cryptoDTO) {

		Crypto crypto = new Crypto();

		crypto.setCryptoName(cryptoDTO.getCryptoName());
		crypto.setPrice(cryptoDTO.getPrice());
		crypto.setBalance(cryptoDTO.getBalance());
		crypto.setMarketcap(cryptoDTO.getMarketcap());
		crypto.setValueUSD(cryptoDTO.getValueUSD());

		return crypto;
	}

	/**
	 * Map NFT. Converts DTO to entity...
	 *
	 * @param nftDTO the NFT DTO
	 * @return the NFT
	 */
	public Nft mapearNft(NftDTO nftDTO) {
		Nft nft = new Nft();

		nft.setNftName(nftDTO.getNftName());
		nft.setColletionName(nftDTO.getColletionName());
		nft.setRoyalties(nftDTO.getRoyalties());
		nft.setNftUrl(nftDTO.getNftUrl());

		return nft;
	}

	/**
	 * Obtain all users.
	 *
	 * @return the list of users
	 */
	@Override
	public List<UsuarioDTO> obtainAllUsers() {
		List<Usuario> listaUsuarios = usuarioRepositorio.findAll();
		return null;
	}

}
