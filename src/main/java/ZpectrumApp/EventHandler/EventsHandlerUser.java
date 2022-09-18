package ZpectrumApp.EventHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.Desktop;
import java.awt.Font;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;
import ZpectrumApp.DTO.CryptoDTO;
import ZpectrumApp.DTO.NftDTO;
import ZpectrumApp.Modelo.Crypto;
import ZpectrumApp.Modelo.Nft;
import ZpectrumApp.Modelo.Usuario;
import ZpectrumApp.Peticiones.Peticiones;
import ZpectrumApp.Repositorio.UsuarioRepositorio;
import ZpectrumApp.Servicio.CryptoServicioIMPL;
import ZpectrumApp.Vista.MainWindow;

public class EventsHandlerUser implements ActionListener, MouseInputListener {

	private UsuarioRepositorio userRepository;
	private CryptoServicioIMPL servicioIMPL;
	private Peticiones peticiones;
	private MainWindow mainWindow;
	private Usuario user;

	public EventsHandlerUser(UsuarioRepositorio userRepository, CryptoServicioIMPL servicioIMPL, Peticiones peticiones,
			MainWindow mainWindow) {
		super();
		this.userRepository = userRepository;
		this.servicioIMPL = servicioIMPL;
		this.peticiones = peticiones;
		this.mainWindow = mainWindow;
	}

	public MainWindow getMainWindow() {
		return mainWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == mainWindow.getUserPanel().getjBtnRegister()) {

			if (!mainWindow.getUserPanel().getUsersJList().isSelectionEmpty()) {
				userLoggin();
			} else {

				if (mainWindow.getUserPanel().getjTextFUserName().getText().length() == 0
						|| mainWindow.getUserPanel().getjTxtFERD().getText().length() != 62) {
					JOptionPane.showMessageDialog(null, "The user name or erd is empty or not correct");
				} else {

					if (peticiones.connectionTest(mainWindow.getUserPanel().getjTxtFERD().getText())) {

						Usuario user = new Usuario();
						userParameters(user);
						List<Usuario> lista = userRepository.findByerd(user.getErd());

						if (!lista.isEmpty()) {

							JOptionPane.showMessageDialog(null, "Login Succesfull");
							mainWindow.getUserPanel().updateList();
							mainWindow.setLoggedUser(true);
							mainWindow.setUser(user);
							mainWindow.getLogout().setVisible(true);
							mainWindow.makePanels();

						} else {
							try {

								userRepository.save(user);
								JOptionPane.showMessageDialog(null, "User saved");
								mainWindow.getUserPanel().updateList();
								mainWindow.setLoggedUser(true);
								mainWindow.getLogout().setVisible(true);
								mainWindow.setUser(user);
								mainWindow.makePanels();

							} catch (Exception e2) {
								System.out.println(e2.getMessage());
								e2.printStackTrace();
							}
						}

						clearForm();

					} else {
						JOptionPane.showMessageDialog(null, "ERD addres is not correct");
					}

				}
			}

		}

		if (e.getSource() == mainWindow.getUserPanel().getjBtnDelete()) {
			if (mainWindow.getUserPanel().getUsersJList().isSelectionEmpty()) {
				JOptionPane.showMessageDialog(null, "You must select an user before");
			}
			if (mainWindow.getUserPanel().getUsersJList().getSelectedValue() == "No hay usuarios registrados") {
				try {
					JOptionPane.showMessageDialog(null, "You must select an user before");
				} catch (NullPointerException e2) {
					System.out.println("No hay usuarios por lo que usuario es null");
				}

			} else {
				if (!mainWindow.getUserPanel().getUsersJList().isSelectionEmpty()) {
					deleteUser();
				}
			}

		}
		if (e.getSource() == mainWindow.getUserPanel().getjBtnCreate()) {
			linkToBrowse("https://wallet.elrond.com/");
		}

	}// Action

	public void deleteUser() {
		try {
			user = null;
			user = userRepository.findByuserName(mainWindow.getUserPanel().getUsersJList().getSelectedValue());
			userRepository.delete(user);
			mainWindow.getUserPanel().updateList();
			JOptionPane.showMessageDialog(null, "User deleted");
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
			e2.printStackTrace();
		}
	}

	public void userLoggin() {
		try {
			user = null;
			user = userRepository.findByuserName(mainWindow.getUserPanel().getUsersJList().getSelectedValue());
			if (user == null) {
				JOptionPane.showMessageDialog(null, "there is no users");
			} else {
				mainWindow.setLoggedUser(true);
				mainWindow.setUser(user);
				mainWindow.getLogout().setVisible(true);
				JOptionPane.showMessageDialog(null, "User logged");
				// TODO volver a pintar las ventanas de PORTFOLIO y WATCHLIST con el usuario
				// registrado
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void linkToBrowse(String linkToEnter) {
		Desktop enlace = Desktop.getDesktop();
		try {
			enlace.browse(new URI(linkToEnter));
		} catch (IOException | URISyntaxException e) {
			e.getMessage();
		}
	}

	private void userParameters(Usuario user) {

		List<CryptoDTO> cryptoList = peticiones.obtainTokensAccount(mainWindow.getUserPanel().getjTxtFERD().getText());
		List<Crypto> finalCryptoList = new ArrayList<Crypto>();
		List<NftDTO> nftList = peticiones.obtainNftAccount(mainWindow.getUserPanel().getjTxtFERD().getText());
		List<Nft> finalNftList = new ArrayList<Nft>();

		user.setUserName(mainWindow.getUserPanel().getjTextFUserName().getText());
		user.setErd(mainWindow.getUserPanel().getjTxtFERD().getText());
		user.setBalance(peticiones.obtainBalanceAccount(mainWindow.getUserPanel().getjTxtFERD().getText()));
		user.setShard(peticiones.getShard(mainWindow.getUserPanel().getjTxtFERD().getText()));
		for (CryptoDTO crypto : cryptoList) {
			finalCryptoList.add(servicioIMPL.mapearEntidad(crypto));
		}
		for (Crypto crypto : finalCryptoList) {
			crypto.setOwner(user);
		}
		user.setCryptoList(finalCryptoList);

		for (NftDTO nft : nftList) {
			finalNftList.add(servicioIMPL.mapearNft(nft));
		}
		for (Nft nft : finalNftList) {
			nft.setUserName(user);
		}
		user.setNftList(finalNftList);

	}

	private void clearForm() {

		mainWindow.getUserPanel().getjTextFUserName().setText("");
		mainWindow.getUserPanel().getjTxtFERD().setText("");

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {

		mainWindow.getUserPanel().getjLblNewHelpText().setVisible(true);

	}

	@Override
	public void mouseExited(MouseEvent e) {

		mainWindow.getUserPanel().getjLblNewHelpText().setVisible(false);

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
