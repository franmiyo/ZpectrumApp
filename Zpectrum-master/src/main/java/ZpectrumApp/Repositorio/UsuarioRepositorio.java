package ZpectrumApp.Repositorio;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ZpectrumApp.Modelo.Usuario;

/**
 * The Interface UsuarioRepositorio.
 * 
 * @author Francisco González
 * @version 1.0
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
	
/**
 * Find by user name.
 *
 * @param userName the user name
 * @return the user
 */
public Usuario findByuserName(String userName);

/**
 * Find by ERD.
 *
 * @param erd the erd
 * @return the list of user
 */
public List<Usuario> findByerd(String erd);

/**
 * Exists by ERD.
 *
 * @param erd the ERD
 * @return true, if successful
 */
public boolean existsByerd(String erd);


}
