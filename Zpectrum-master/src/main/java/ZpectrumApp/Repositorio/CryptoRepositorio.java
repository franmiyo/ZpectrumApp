package ZpectrumApp.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ZpectrumApp.Modelo.Crypto;

/**
 * The Interface CryptoRepositorio.
 * 
 * @author Francisco González
 * @version 1.0
 */
@Repository
public interface CryptoRepositorio extends JpaRepository<Crypto, Long>{

}
