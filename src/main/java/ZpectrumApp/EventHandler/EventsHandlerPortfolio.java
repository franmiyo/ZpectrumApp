package ZpectrumApp.EventHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.datatransfer.Clipboard;
import java.awt.*;

import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.datatransfer.StringSelection;
import ZpectrumApp.Modelo.Usuario;
import ZpectrumApp.Peticiones.Peticiones;
import ZpectrumApp.Repositorio.UsuarioRepositorio;
import ZpectrumApp.Servicio.CryptoServicioIMPL;
import ZpectrumApp.Vista.MainWindow;

public class EventsHandlerPortfolio implements ActionListener {

	private MainWindow mainWindow;
	private UsuarioRepositorio userRepository;
	private Peticiones peticiones;
	private Usuario user;

	public EventsHandlerPortfolio(UsuarioRepositorio userRepository, CryptoServicioIMPL servicioIMPL, Peticiones peticiones,
			MainWindow mainWindow) {
		super();
		this.mainWindow = mainWindow;
		this.userRepository = userRepository;
		this.peticiones = peticiones;
	}

	public MainWindow getMainWindow() {
		return mainWindow;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mainWindow.getPortfolioPanel().getCopyBtn()) {
			String str = mainWindow.getUser().getErd();
			Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection strSel = new StringSelection(str);
			 cb.setContents(strSel, null);
			 JOptionPane.showMessageDialog(null, "Address copied");
		}
		if(e.getSource() == mainWindow.getPortfolioPanel().getUpdateBtn()) {
			
		}


	}



}
