package ZpectrumApp.Servicio;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ZpectrumApp.DTO.CryptoDTO;
import ZpectrumApp.DTO.NftDTO;
import ZpectrumApp.DTO.UsuarioDTO;
import ZpectrumApp.Modelo.Crypto;
import ZpectrumApp.Modelo.Nft;
import ZpectrumApp.Modelo.Usuario;
import ZpectrumApp.Peticiones.Peticiones;
import ZpectrumApp.Repositorio.UsuarioRepositorio;

@Service
public class CryptoServicioIMPL implements CryptoServicio{
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	//convierte DTO a entidad
	public Crypto mapearEntidad(CryptoDTO cryptoDTO) {
		
		Crypto crypto = new Crypto();
		
		crypto.setCryptoName(cryptoDTO.getCryptoName());
		crypto.setPrice(cryptoDTO.getPrice());
		crypto.setBalance(cryptoDTO.getBalance());
		crypto.setMarketcap(cryptoDTO.getMarketcap());
		crypto.setValueUSD(cryptoDTO.getValueUSD());
		
		return crypto;
	}
	
	//convierte DTO a entidad
	public Nft mapearNft(NftDTO nftDTO) {
		Nft nft = new Nft();
		
		nft.setNftName(nftDTO.getNftName());
		nft.setColletionName(nftDTO.getColletionName());
		nft.setRoyalties(nftDTO.getRoyalties());
		nft.setNftUrl(nftDTO.getNftUrl());
		
		return nft;
	}

	@Override
	public List<UsuarioDTO> obtainAllUsers() {
		List<Usuario> listaUsuarios = usuarioRepositorio.findAll();
		return null;
	}



}
