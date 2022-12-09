package ZpectrumApp.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ZpectrumApp.Modelo.Nft;

/**
 * The Interface NftRepositorio.
 * 
 * @author Francisco González
 * @version 1.0
 */
@Repository
public interface NftRepositorio extends JpaRepository<Nft, Long>{
	
	/**
	 * Find by NFT name.
	 *
	 * @param nftName the NFT name
	 * @return the NFT
	 */
	public Nft findBynftName(String nftName);

}
