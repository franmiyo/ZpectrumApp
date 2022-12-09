package ZpectrumApp.Vista;


import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import ZpectrumApp.EventHandler.EventsHandlerWatchlist;
import ZpectrumApp.Modelo.Usuario;

/**
 * The Class WatchlistPanel.
 * 
 * @author Francisco González
 * @version 1.0
 */
public class WatchlistPanel extends JPanel {

	private static final long serialVersionUID = -5295423397999336755L;
	private JPanel contentPaneWatchlist;
	private Font fuente1 = new Font("Tahoma", Font.PLAIN, 22);
	private MainWindow mainWindow;
	private Usuario user;

	/**
	 * Constructor: Instantiates a new watchlist panel.
	 *
	 * @param mainWindow the main window
	 */
	public WatchlistPanel(MainWindow mainWindow) {

		this.mainWindow = mainWindow;
		setUI();
		setVisible(false);
	}
	
	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public Usuario getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(Usuario user) {
		this.user = user;
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
	 * Gets the content panel watchlist.
	 *
	 * @return the content panel watchlist
	 */
	public JPanel getContentPaneWatchlist() {
		return contentPaneWatchlist;
	}

	/**
	 * Sets the user interface.
	 */
	public void setUI() {

		setBounds(100, 100, 1400, 900);
		contentPaneWatchlist = new JPanel();
		setMinimumSize(new Dimension(1400, 900));
		contentPaneWatchlist.setFont(fuente1);

	}

	/**
	 * Sets the watchlist handler.
	 *
	 * @param handler the new watchlist handler
	 */
	public void setWatchlistHandler(EventsHandlerWatchlist handler) {

		//itemPortfolioWatchlist.addActionListener(handler);

	}

}
