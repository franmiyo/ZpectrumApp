package ZpectrumApp.JpaController;

import java.util.List;

import ZpectrumApp.Modelo.Usuario;
import ZpectrumApp.Repositorio.UsuarioRepositorio;

public class UsuariosDAO {

	private UsuarioRepositorio userRepository;

	public boolean login(String name, String erd) {
		boolean valor = false;
		List<Usuario> user = userRepository.findByerd(erd);
		try {
			if (user!=null) {
				valor = true;
				return valor;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return valor;
	}

}
