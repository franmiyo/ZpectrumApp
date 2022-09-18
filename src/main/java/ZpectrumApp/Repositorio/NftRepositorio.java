package ZpectrumApp.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ZpectrumApp.Modelo.Nft;

@Repository
public interface NftRepositorio extends JpaRepository<Nft, Long>{
	
	public Nft findBynftName(String nftName);

}
