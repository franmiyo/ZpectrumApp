package ZpectrumApp.Vista;


import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import ZpectrumApp.EventHandler.EventsHandlerWatchlist;
import ZpectrumApp.Modelo.Usuario;


public class WatchlistPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5295423397999336755L;

	private JPanel contentPaneWatchlist;
	private Font fuente1 = new Font("Tahoma", Font.PLAIN, 22);
	private MainWindow mainWindow;
	private Usuario user;

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public MainWindow getMainWindow() {
		return mainWindow;
	}

	public JPanel getContentPaneWatchlist() {
		return contentPaneWatchlist;
	}

	public WatchlistPanel(MainWindow mainWindow) {

		this.mainWindow = mainWindow;

		setUI();
		setVisible(false);
	}

	public void setUI() {

		setBounds(100, 100, 1400, 900);
		contentPaneWatchlist = new JPanel();
		setMinimumSize(new Dimension(1400, 900));
		contentPaneWatchlist.setFont(fuente1);

	}

	public void setWatchlistHandler(EventsHandlerWatchlist handler) {

		//itemPortfolioWatchlist.addActionListener(handler);

	}

}
