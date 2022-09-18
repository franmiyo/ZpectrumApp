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
import javax.swing.event.MenuListener;
import ZpectrumApp.Peticiones.Peticiones;
import ZpectrumApp.Vista.MainWindow;

public class EventsHandlerMainWindow extends ComponentAdapter implements ActionListener, MenuListener {

	private Peticiones peticiones;
	private MainWindow mainWindow;
	private CardLayout cardLayout;

	public EventsHandlerMainWindow(MainWindow mainWindow, Peticiones peticiones) {
		super();
		this.peticiones = peticiones;
		this.mainWindow = mainWindow;
	}

	public MainWindow getMainWindow() {
		return mainWindow;
	}

	public void MouseClicked(MouseEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * if(e.getSource() == mainWindow.getItemHome()) { System.out.println("anña");
		 * JOptionPane.showMessageDialog(mainWindow,
		 * "Eggs are not supposed to be green."); }
		 */
		if (e.getSource() == mainWindow.getHome()) {
			// JOptionPane.showMessageDialog(mainWindow, "Need to login before enter");
			mainWindow.getCardLayout().show(mainWindow.getMainWindowContainer(), "Main panel container");
			mainWindow.getMaiarExchangeLabel().setText("<html><p>Maiar Exchange</p></html>");
		}
		if (e.getSource() == mainWindow.getItemPortfolio()) {
			if (!mainWindow.isLoggedUser()) {
				JOptionPane.showMessageDialog(mainWindow, "Need to login before enter");
			} else {
				cardLayout = (CardLayout) (mainWindow.getCapas().getLayout());
				mainWindow.getMaiarExchangeLabel().setText("<html><p>Portfolio</p></html>");
				cardLayout.show(mainWindow.getCapas(), "PortfolioPanel");
				System.out.println("ventana portfolio");
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

		if (e.getSource() == mainWindow.getLoginButton()) {
			cardLayout = (CardLayout) (mainWindow.getCapas().getLayout());
			cardLayout.show(mainWindow.getCapas(), "UserPanel");
			mainWindow.getMaiarExchangeLabel().setText("<html><p>Login Page</p></html>");
			System.out.println("ventana login");
		}

	}

	@Override
	public void menuSelected(MenuEvent e) {

		if (e.getSource() == mainWindow.getHome()) {

			cardLayout = (CardLayout) (mainWindow.getCapas().getLayout());
			cardLayout.show(mainWindow.getCapas(), "MainWindowPanel");
			mainWindow.getMaiarExchangeLabel().setText("<html><p>Maiar Exchange</p></html>");
			printEcentInfo("Selected", e);
		}

		if (e.getSource() == mainWindow.getLogin()) {

			cardLayout = (CardLayout) (mainWindow.getCapas().getLayout());
			cardLayout.show(mainWindow.getCapas(), "UserPanel");
			mainWindow.getMaiarExchangeLabel().setText("<html><p>Login Page</p></html>");
			System.out.println("ventana login");

		}
		if (e.getSource() == mainWindow.getLogout()) {
			int reply = JOptionPane.showConfirmDialog(null, "Do you want to close session?", "Close session",
					JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				mainWindow.setLoggedUser(false);
				mainWindow.getLogout().setVisible(false);
				cardLayout = (CardLayout) (mainWindow.getCapas().getLayout());
				cardLayout.show(mainWindow.getCapas(), "UserPanel");
				mainWindow.getMaiarExchangeLabel().setText("<html><p>Login Page</p></html>");
			}
		}

	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub

	}

	private void printEcentInfo(String cadena, MenuEvent e) {
		JMenu menu = (JMenu) e.getSource();
		System.out.println("La cadena es la siguiente: " + menu.getText());
	}

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

}
