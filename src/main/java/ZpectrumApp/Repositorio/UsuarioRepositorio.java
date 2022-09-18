package ZpectrumApp.Repositorio;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ZpectrumApp.Modelo.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
	
public Usuario findByuserName(String userName);
public List<Usuario> findByerd(String erd);


}
