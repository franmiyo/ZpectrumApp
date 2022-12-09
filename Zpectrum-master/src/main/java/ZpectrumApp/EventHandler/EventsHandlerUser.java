package ZpectrumApp.EventHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.Desktop;
import java.awt.Window;
import java.awt.BorderLayout;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Dialog.ModalityType;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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

/**
 * The Class EventsHandlerUser handles all user-related actions in the app.
 * 
 * @author Francisco González and Cristian Fernández
 * @version 1.0
 */
public class EventsHandlerUser extends AbstractAction
		implements ActionListener, MouseInputListener, ListSelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UsuarioRepositorio userRepository;
	private CryptoServicioIMPL servicioIMPL;
	private Peticiones peticiones;
	private MainWindow mainWindow;
	private Usuario user;

	/**
	 * Constructor: Instantiates a new events handler user.
	 *
	 * @param userRepository the user repository
	 * @param servicioIMPL   the service IMPL
	 * @param peticiones     the requests
	 * @param mainWindow     the main window
	 */
	public EventsHandlerUser(UsuarioRepositorio userRepository, CryptoServicioIMPL servicioIMPL, Peticiones peticiones,
			MainWindow mainWindow) {
		super();
		this.userRepository = userRepository;
		this.servicioIMPL = servicioIMPL;
		this.peticiones = peticiones;
		this.mainWindow = mainWindow;
	}

	/**
	 * Gets the main window.
	 *
	 * @return the main window
	 */
	public MainWindow getMainWindow() {
		return mainWindow;
	}

	/**
	 * Action performed in the app.
	 *
	 * @param e the action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == mainWindow.getUserPanel().getjBtnRegister()) {

			registerOrLogIn(e);

		}

		if (e.getSource() == mainWindow.getUserPanel().getjBtnDelete()) {

			if (mainWindow.getUserPanel().getUsersJList().isSelectionEmpty()
					|| mainWindow.getUserPanel().getUsersJList().getSelectedValue() == "There is no users") {
				JOptionPane.showMessageDialog(null, "You must select an user before");
			} else {

				if (!mainWindow.getUserPanel().getUsersJList().isSelectionEmpty()) {

					switch (JOptionPane.showConfirmDialog(null, "Are you sure to delete the user?", "Delete user",
							JOptionPane.YES_NO_OPTION)) {
					case JOptionPane.YES_OPTION:
						deleteUser();
						break;
					default:
						break;
					}
				}
			}
		}

		if (e.getSource() == mainWindow.getUserPanel().getjBtnCreate()) {
			linkToBrowse("https://wallet.elrond.com/");
		}

		if (!mainWindow.getUserPanel().getUsersJList().isSelectionEmpty()) {
			mainWindow.getUserPanel().getUsersJList().clearSelection();
		}
	}

	/**
	 * Delete user.
	 */
	public void deleteUser() {

		try {
			user = null;
			user = userRepository.findByuserName(mainWindow.getUserPanel().getUsersJList().getSelectedValue());
			userRepository.delete(user);
			mainWindow.getUserPanel().updateList();
			mainWindow.setLoggedUser(false);
			JOptionPane.showMessageDialog(null, "User deleted");

		} catch (Exception e2) {
			System.out.println(e2.getMessage());
			e2.printStackTrace();
		}
	}

	/**
	 * User log in.
	 */
	public void userLoggin() {

		try {
			user = null;
			user = userRepository.findByuserName(mainWindow.getUserPanel().getUsersJList().getSelectedValue());

			if (user == null || mainWindow.getUserPanel().getModel().isEmpty()) {
				JOptionPane.showMessageDialog(null, "There is no users");

			} else {
				mainWindow.setLoggedUser(true);
				mainWindow.setUser(user);
				mainWindow.getItemLogout().setVisible(true);
				mainWindow.makePanels();
				mainWindow.getPortfolioPanel().repaintComponents();
				JOptionPane.showMessageDialog(null, "User logged");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Link to browse.
	 *
	 * @param linkToEnter the link to enter
	 */
	public void linkToBrowse(String linkToEnter) {
		Desktop enlace = Desktop.getDesktop();

		try {
			enlace.browse(new URI(linkToEnter));

		} catch (IOException | URISyntaxException e) {
			e.getMessage();
		}
	}

	/**
	 * Mouse clicked.
	 *
	 * @param e the mouse event
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	/**
	 * Mouse pressed.
	 *
	 * @param e the mouse event
	 */
	@Override
	public void mousePressed(MouseEvent e) {

		if (e.getSource() == mainWindow.getUserPanel() || e.getSource() == mainWindow.getContentPane()) {
			mainWindow.getUserPanel().getUsersJList().clearSelection();
		}
	}

	/**
	 * Mouse released.
	 *
	 * @param e the mouse event
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Mouse entered.
	 *
	 * @param e the mouse event
	 */
	@Override
	public void mouseEntered(MouseEvent e) {

		if (e.getSource() == mainWindow.getUserPanel().getjLblHelp()) {
			mainWindow.getUserPanel().getjLblNewHelpText().setVisible(true);
		}

	}

	/**
	 * Mouse exited.
	 *
	 * @param e the mouse event
	 */
	@Override
	public void mouseExited(MouseEvent e) {

		if (e.getSource() == mainWindow.getUserPanel().getjLblHelp()) {
			mainWindow.getUserPanel().getjLblNewHelpText().setVisible(false);
		}

	}

	/**
	 * Mouse dragged.
	 *
	 * @param e the mouse event
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Mouse moved.
	 *
	 * @param e the mouse event
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Value changed.
	 *
	 * @param e the mouse event
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Method that set the user parameters using the peticiones service and the info
	 * from the User panel form.
	 *
	 * @param User user
	 */
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

	/**
	 * Method that empty the JLabel's forms.
	 */
	private void clearForm() {

		mainWindow.getUserPanel().getjTextFUserName().setText("");
		mainWindow.getUserPanel().getjTxtFERD().setText("");

	}

	private void registerOrLogIn(ActionEvent e) {
		SwingWorker<Void, Void> mySwingWorker = new SwingWorker<Void, Void>() {

			@Override
			protected Void doInBackground() throws Exception {
				if (!mainWindow.getUserPanel().getUsersJList().isSelectionEmpty()) {
					user = null;
					user = userRepository.findByuserName(mainWindow.getUserPanel().getjTextFUserName().getText());
					if (user != null) {
						JOptionPane.showMessageDialog(null, "The user name already exists");

					} else {
						userLoggin();
					}

				} else {

					if (mainWindow.getUserPanel().getjTextFUserName().getText().length() == 0
							|| mainWindow.getUserPanel().getjTxtFERD().getText().length() != 62) {
						JOptionPane.showMessageDialog(null, "The user name or erd is empty or not correct");
					} else {

						if (peticiones.connectionTest(mainWindow.getUserPanel().getjTxtFERD().getText())) {
							Usuario user = new Usuario();
							userParameters(user);
							List<Usuario> lista = userRepository.findByerd(user.getErd());

							if (userRepository.existsByerd(mainWindow.getUserPanel().getjTxtFERD().getText())
									|| userRepository.findByuserName(
											mainWindow.getUserPanel().getjTextFUserName().getText()) != null) {
								JOptionPane.showMessageDialog(null, "User already exists");

							} else {
								mainWindow.getItemLogout().setVisible(true);

								if (!lista.isEmpty()) {

									JOptionPane.showMessageDialog(null, "Login Succesfull");
									mainWindow.getUserPanel().updateList();
									mainWindow.setLoggedUser(true);
									mainWindow.setUser(user);
									mainWindow.makePanels();

								} else {

									try {

										userRepository.save(user);
										mainWindow.getUserPanel().updateList();
										mainWindow.setLoggedUser(true);
										mainWindow.setUser(user);
										mainWindow.makePanels();
										JOptionPane.showMessageDialog(null, "User saved");

									} catch (Exception e2) {
										System.out.println(e2.getMessage());
										e2.printStackTrace();
									}
								}
							}

						} else {
							JOptionPane.showMessageDialog(null, "ERD addres is not correct");
							mainWindow.getItemLogout().setVisible(false);
						}
					}
				}
				return null;
			}

		};
		Window win = SwingUtilities.getWindowAncestor((AbstractButton) e.getSource());
		final JDialog dialog = new JDialog(win, "Zpectrum", ModalityType.APPLICATION_MODAL);
		mySwingWorker.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getPropertyName().equals("state")) {
					if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
						dialog.dispose();
					}
				}
			}
		});
		mySwingWorker.execute();
		JProgressBar progressBar = new JProgressBar();
		progressBar.setIndeterminate(true);
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(progressBar, BorderLayout.CENTER);
		panel.add(new JLabel("Please wait......."), BorderLayout.PAGE_START);
		dialog.add(panel);
		dialog.pack();
		dialog.setLocationRelativeTo(win);
		dialog.setVisible(true);

		clearForm();
	}

}
