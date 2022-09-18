package ZpectrumApp.EventHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import ZpectrumApp.Vista.MainWindow;
import ZpectrumApp.Vista.PortfolioPanel;
import ZpectrumApp.Vista.UserPanel;
import ZpectrumApp.Vista.WatchlistPanel;

public class EventsHandlerWatchlist extends ComponentAdapter implements ActionListener, MenuListener {

	private MainWindow mainWindow;
	
	public EventsHandlerWatchlist(MainWindow mainWindow) {
		super();
		
		this.mainWindow = mainWindow;

	}

	public MainWindow getMainWindow() {
		return mainWindow;
	}


	@Override
	public void menuSelected(MenuEvent e) {

	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {


	}

	@Override
	public void componentResized(ComponentEvent e) {
		/**
		if (watchlistWindow.getContentPane().getBounds().width > watchlistWindow.getContentPane().getMinimumSize().width
				+ 1550) {
			Border b = new EmptyBorder(130, 0, 0, 0);
			//watchlistWindow.getContainerWatchlist().setBorder(b);
		}
		if (watchlistWindow.getContentPane().getBounds().width < watchlistWindow.getContentPane().getMinimumSize().width
				+ 1550) {
			Border b = new EmptyBorder(0, 0, 0, 0);
			//watchlistWindow.getContainerWatchlist().setBorder(b);
		}
		**/
	}

}
