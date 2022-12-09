package ZpectrumApp.EventHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import ZpectrumApp.Vista.MainWindow;

/**
 * The Class EventsHandlerWatchlist handles all watchlist-related actions in the
 * app.
 * 
 * @author Francisco González
 * @version 1.0
 */
public class EventsHandlerWatchlist extends ComponentAdapter implements ActionListener, MenuListener {

	private MainWindow mainWindow;

	/**
	 * Constructor: Instantiates a new events handler watchlist.
	 *
	 * @param mainWindow the main window
	 */
	public EventsHandlerWatchlist(MainWindow mainWindow) {
		super();

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
	 * Menu selected.
	 *
	 * @param e the menu event
	 */
	@Override
	public void menuSelected(MenuEvent e) {

	}

	/**
	 * Menu deselected.
	 *
	 * @param e the menu event
	 */
	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Menu canceled.
	 *
	 * @param e the menu event
	 */
	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Action performed in the app.
	 *
	 * @param e the action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

	}

	/**
	 * Resize the components of app.
	 *
	 * @param e the component event
	 */
	@Override
	public void componentResized(ComponentEvent e) {
		/**
		 * if (watchlistWindow.getContentPane().getBounds().width >
		 * watchlistWindow.getContentPane().getMinimumSize().width + 1550) { Border b =
		 * new EmptyBorder(130, 0, 0, 0);
		 * //watchlistWindow.getContainerWatchlist().setBorder(b); } if
		 * (watchlistWindow.getContentPane().getBounds().width <
		 * watchlistWindow.getContentPane().getMinimumSize().width + 1550) { Border b =
		 * new EmptyBorder(0, 0, 0, 0);
		 * //watchlistWindow.getContainerWatchlist().setBorder(b); }
		 **/
	}

}
