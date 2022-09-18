package ZpectrumApp.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ZpectrumApp.Modelo.Crypto;

@Repository
public interface CryptoRepositorio extends JpaRepository<Crypto, Long>{

}
