package ZpectrumApp.EventHandler;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import ZpectrumApp.Peticiones.Peticiones;
import ZpectrumApp.Vista.MainWindow;

/**
 * The Class EventsHandlerMainWindow handles all main window-related actions in
 * the app.
 * 
 * @author Francisco González and Cristian Fernández
 * @version 1.0
 */
public class EventsHandlerMainWindow extends ComponentAdapter implements ActionListener {

	private Peticiones peticiones;
	private MainWindow mainWindow;
	private CardLayout cardLayout;

	/**
	 * Constructor: Instantiates a new events handler main window.
	 *
	 * @param mainWindow the main window
	 * @param peticiones the requests
	 */
	public EventsHandlerMainWindow(MainWindow mainWindow, Peticiones peticiones) {
		super();
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
	 * Mouse clicked.
	 *
	 * @param e the mouse event
	 */
	public void MouseClicked(MouseEvent e) {

	}

	/**
	 * Action performed in the app.
	 *
	 * @param e the action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == mainWindow.getItemExchange()) {
			cardLayout = (CardLayout) (mainWindow.getCapas().getLayout());
			cardLayout.show(mainWindow.getCapas(), "MainWindowPanel");
			mainWindow.getMaiarExchangeLabel().setText("<html><p>Maiar Exchange</p></html>");
		}

		if (e.getSource() == mainWindow.getItemPortfolio()) {

			if (mainWindow.getUserPanel().getUsersJList().getModel().getSize() == 0) {
				JOptionPane.showMessageDialog(mainWindow, "Need to login before enter");
			} else {
				if (!mainWindow.isLoggedUser()) {
					JOptionPane.showMessageDialog(mainWindow, "Need to login before enter");
				} else {
					cardLayout = (CardLayout) (mainWindow.getCapas().getLayout());
					mainWindow.getMaiarExchangeLabel().setText("<html><p>Portfolio</p></html>");
					cardLayout.show(mainWindow.getCapas(), "PortfolioPanel");
					System.out.println("ventana portfolio");
				}

			}

		}

		if (e.getSource() == mainWindow.getItemWatchlist()) {

			if (!mainWindow.isLoggedUser()) {
				JOptionPane.showMessageDialog(mainWindow, "Need to login before enter");

			} else {
				cardLayout = (CardLayout) (mainWindow.getCapas().getLayout());
				mainWindow.getMaiarExchangeLabel().setText("<html><p>WatchList</p></html>");
				cardLayout.show(mainWindow.getCapas(), "WatchlistPanel");
				System.out.println("ventana watchlist");
			}
		}

		if (e.getSource() == mainWindow.getItemLogin()) {

			cardLayout = (CardLayout) (mainWindow.getCapas().getLayout());
			cardLayout.show(mainWindow.getCapas(), "UserPanel");
			mainWindow.getMaiarExchangeLabel().setText("<html><p>Login Page</p></html>");

			if (mainWindow.isLoggedUser()) {
				mainWindow.getItemLogout().setVisible(true);
			}
			System.out.println("ventana login");

		}

		if (e.getSource() == mainWindow.getItemLogout()) {
			int reply = JOptionPane.showConfirmDialog(null, "Do you want to close session?", "Close session",
					JOptionPane.YES_NO_OPTION);

			if (reply == JOptionPane.YES_OPTION) {
				mainWindow.setLoggedUser(false);
				cardLayout = (CardLayout) (mainWindow.getCapas().getLayout());
				cardLayout.show(mainWindow.getCapas(), "UserPanel");
				mainWindow.getMaiarExchangeLabel().setText("<html><p>Login Page</p></html>");
				mainWindow.getItemLogout().setVisible(false);
			}
		}

		if (e.getSource() == mainWindow.getLoginButton()) {
			cardLayout = (CardLayout) (mainWindow.getCapas().getLayout());
			cardLayout.show(mainWindow.getCapas(), "UserPanel");

			if (mainWindow.isLoggedUser()) {
				mainWindow.getItemLogout().setVisible(true);
			}

			mainWindow.getMaiarExchangeLabel().setText("<html><p>Login Page</p></html>");
			System.out.println("ventana login");
		}

	}

	/**
	 * Event to display when a component is resize.
	 *
	 * @param e the component event
	 */
	@Override
	public void componentResized(ComponentEvent e) {

		if (mainWindow.getContentPane().getBounds().width > mainWindow.getContentPane().getMinimumSize().width + 1550) {
			Border b = new EmptyBorder(130, 0, 0, 0);
			mainWindow.getContainer().setBorder(b);
		}

		if (mainWindow.getContentPane().getBounds().width < mainWindow.getContentPane().getMinimumSize().width + 1550) {
			Border b = new EmptyBorder(0, 0, 0, 0);
			mainWindow.getContainer().setBorder(b);
		}
	}

	/**
	 * Prints the ecent information. usefull to print trace of the program stream
	 *
	 * @param cadena the string
	 * @param e      the menu event
	 */
	private void printEcentInfo(String cadena, MenuEvent e) {
		JMenu menu = (JMenu) e.getSource();
		System.out.println("La cadena es la siguiente: " + menu.getText());
	}

}
