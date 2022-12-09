package ZpectrumApp.EventHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.datatransfer.Clipboard;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import java.awt.datatransfer.StringSelection;
import ZpectrumApp.Peticiones.Peticiones;
import ZpectrumApp.Repositorio.UsuarioRepositorio;
import ZpectrumApp.Servicio.CryptoServicioIMPL;
import ZpectrumApp.Vista.MainWindow;

/**
 * The Class EventsHandlerPortfolio handles all portfolio-related actions in the app.
 * 
 * @author Francisco González and Cristian Fernández
 * @version 1.0
 */
public class EventsHandlerPortfolio implements ActionListener {

	private MainWindow mainWindow;
	private UsuarioRepositorio userRepository;
	private Peticiones peticiones;

	/**
	 * Constructor: Instantiates a new events handler portfolio.
	 *
	 * @param userRepository the user repository
	 * @param servicioIMPL   the service IMPL
	 * @param peticiones     the requests
	 * @param mainWindow     the main window
	 */
	public EventsHandlerPortfolio(UsuarioRepositorio userRepository, CryptoServicioIMPL servicioIMPL,
			Peticiones peticiones, MainWindow mainWindow) {
		super();
		this.mainWindow = mainWindow;
		this.userRepository = userRepository;
		this.peticiones = peticiones;
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
		
		if (e.getSource() == mainWindow.getPortfolioPanel().getCopyBtn()) {
			
			String str = mainWindow.getUser().getErd();
			Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection strSel = new StringSelection(str);
			cb.setContents(strSel, null);
			JOptionPane.showMessageDialog(null, "Address copied");
		
		}
		
		if (e.getSource() == mainWindow.getPortfolioPanel().getUpdateBtn()) {
			
			mainWindow.getPortfolioPanel().repaintComponents();
			JOptionPane.showMessageDialog(null, "Components reloaded");
			
		}

	}

}
