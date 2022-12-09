package ZpectrumApp.Servicio;

import java.util.List;
import ZpectrumApp.DTO.UsuarioDTO;

/**
 * The Interface CryptoServicio.
 * 
 * @author Francisco González
 * @version 1.0
 */
public interface CryptoServicio {
	
	/**
	 * Obtain all users.
	 *
	 * @return the list of users
	 */
	public List<UsuarioDTO> obtainAllUsers();
}
