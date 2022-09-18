package ZpectrumApp.Servicio;

import java.util.List;
import ZpectrumApp.DTO.UsuarioDTO;

public interface CryptoServicio {
	
	public List<UsuarioDTO> obtainAllUsers();
}
