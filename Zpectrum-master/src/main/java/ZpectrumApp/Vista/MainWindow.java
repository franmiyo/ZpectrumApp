package ZpectrumApp.Vista;

import java.awt.*;
import java.net.URL;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import ZpectrumApp.EventHandler.EventsHandlerMainWindow;
import ZpectrumApp.EventHandler.EventsHandlerPortfolio;
import ZpectrumApp.EventHandler.EventsHandlerWatchlist;
import ZpectrumApp.Modelo.TokensMaiar;
import ZpectrumApp.Modelo.Usuario;
import ZpectrumApp.Peticiones.Peticiones;
import ZpectrumApp.Repositorio.NftRepositorio;
import ZpectrumApp.Repositorio.UsuarioRepositorio;
import ZpectrumApp.Servicio.CryptoServicioIMPL;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;
import java.util.List;
import javax.swing.JTable;
import javax.swing.SwingConstants;

/**
 * The Class MainWindow declares and initializes everything inside the main
 * window.
 * 
 * @author Francisco González y Cristian Fernández
 * @version 1.0
 */
public class MainWindow extends JFrame implements TableModel {

	private static final long serialVersionUID = -8312087735648019235L;
	private Peticiones peticiones;
	private JPanel contentPane, mainWindowContainer, capas, mainPanel;
	private CardLayout cardLayout = new CardLayout();
	private JMenuBar menuBar;
	private JMenu home, tools, session;
	private JMenuItem itemPortfolio, itemWatchlist, itemLogout, itemLogin, itemExchange;
	private JLabel presentationJLabel2, maiarExchangeLabel;
	private JButton loginButton;
	private FondoApp fondo;
	private Font fuente1 = new Font("Tahoma", Font.PLAIN, 22), fuenteTable = new Font("Tahoma", Font.PLAIN, 15);
	private JTable table;
	private UsuarioRepositorio userRepository;
	private UserPanel userPanel;
	private PortfolioPanel portfolioPanel;
	private WatchlistPanel watchListPanel;
	private Usuario user;
	private CryptoServicioIMPL servicioIMPL;
	private EventsHandlerPortfolio portfolioWindowHandler;
	private EventsHandlerWatchlist watchlistWindowHandler;
	private boolean loggedUser;
	private NftRepositorio nftRepository;

	/**
	 * Constructor: Instantiates a new main window.
	 *
	 * @param fondo                  the app's background.
	 * @param peticiones             the requests.
	 * @param userRepository         the user repository.
	 * @param watchlistWindowHandler the watchlist window handler.
	 * @param portfolioWindowHandler the portfolio window handler.
	 * @param loggedUser             the logged user.
	 * @param servicioIMPL           the IMPL service.
	 * @param nftRepository          the NFT repository.
	 */
	public MainWindow(FondoApp fondo, Peticiones peticiones, UsuarioRepositorio userRepository,
			EventsHandlerWatchlist watchlistWindowHandler, EventsHandlerPortfolio portfolioWindowHandler,
			boolean loggedUser, CryptoServicioIMPL servicioIMPL, NftRepositorio nftRepository) {
		this.fondo = fondo;
		this.peticiones = peticiones;
		this.userRepository = userRepository;
		this.userPanel = new UserPanel(userRepository, this);
		this.watchlistWindowHandler = watchlistWindowHandler;
		this.portfolioWindowHandler = portfolioWindowHandler;
		this.loggedUser = loggedUser;
		this.servicioIMPL = servicioIMPL;
		this.nftRepository = nftRepository;
		initMenu();
		setUI();
		this.getUserPanel().updateList();
		setVisible(true);
	}

	public static Image getImage(final String pathAndFileName) {
		final URL url = Thread.currentThread().getContextClassLoader().getResource(pathAndFileName);
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	/**
	 * Gets the NFT repository.
	 * 
	 * @return the NFT repository
	 */
	public NftRepositorio getNftRepository() {
		return nftRepository;
	}

	/**
	 * Gets the user repository.
	 *
	 * @return the user repository
	 */
	public UsuarioRepositorio getUserRepository() {
		return userRepository;
	}

	/**
	 * Gets the requests.
	 *
	 * @return the requests
	 */
	public Peticiones getPeticiones() {
		return peticiones;
	}

	/**
	 * Checks if is logged user.
	 *
	 * @return true, if is logged user
	 */
	public boolean isLoggedUser() {
		return loggedUser;
	}

	/**
	 * Sets the logged user.
	 *
	 * @param loggedUser the new logged user
	 */
	public void setLoggedUser(boolean loggedUser) {
		this.loggedUser = loggedUser;
	}

	/**
	 * Gets the portfolio window handler.
	 *
	 * @return the portfolio window handler
	 */
	public EventsHandlerPortfolio getPortfolioWindowHandler() {
		return portfolioWindowHandler;
	}

	/**
	 * Sets the portfolio window handler.
	 *
	 * @param portfolioWindowHandler the new portfolio window handler
	 */
	public void setPortfolioWindowHandler(EventsHandlerPortfolio portfolioWindowHandler) {
		this.portfolioWindowHandler = portfolioWindowHandler;
	}

	/**
	 * Gets the watchlist window handler.
	 *
	 * @return the watchlist window handler
	 */
	public EventsHandlerWatchlist getWatchlistWindowHandler() {
		return watchlistWindowHandler;
	}

	/**
	 * Sets the watchlist window handler.
	 *
	 * @param watchlistWindowHandler the new watchlist window handler
	 */
	public void setWatchlistWindowHandler(EventsHandlerWatchlist watchlistWindowHandler) {
		this.watchlistWindowHandler = watchlistWindowHandler;
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
	 * Gets the session.
	 *
	 * @return the session
	 */
	public JMenu getSession() {
		return session;
	}

	/**
	 * Gets the layers.
	 *
	 * @return the layers
	 */
	public JPanel getCapas() {
		return capas;
	}

	/**
	 * Gets the card layout.
	 *
	 * @return the card layout
	 */
	public CardLayout getCardLayout() {
		return cardLayout;
	}

	/**
	 * Gets the portfolio panel.
	 *
	 * @return the portfolio panel
	 */
	public PortfolioPanel getPortfolioPanel() {
		return portfolioPanel;
	}

	/**
	 * Gets the watchlist panel.
	 *
	 * @return the watchlist panel
	 */
	public WatchlistPanel getWatchListPanel() {
		return watchListPanel;
	}

	/**
	 * Gets the user panel.
	 *
	 * @return the user panel
	 */
	public UserPanel getUserPanel() {
		return userPanel;
	}

	/**
	 * Gets the main window container.
	 *
	 * @return the main window container
	 */
	public JPanel getMainWindowContainer() {
		return mainWindowContainer;
	}

	/**
	 * Gets the maiar exchange label.
	 *
	 * @return the maiar exchange label
	 */
	public JLabel getMaiarExchangeLabel() {
		return maiarExchangeLabel;
	}

	/**
	 * Gets the presentation label 2.
	 *
	 * @return the presentation label 2
	 */
	public JLabel getPresentationJLabel2() {
		return presentationJLabel2;
	}

	/**
	 * Gets the container.
	 *
	 * @return the container
	 */
	public JPanel getContainer() {
		return mainWindowContainer;
	}

	/**
	 * Gets the login button.
	 *
	 * @return the login button
	 */
	public JButton getLoginButton() {
		return loginButton;
	}

	/**
	 * Gets the item portfolio.
	 *
	 * @return the item portfolio
	 */
	public JMenuItem getItemPortfolio() {
		return itemPortfolio;
	}

	/**
	 * Gets the item watchlist.
	 *
	 * @return the item watchlist
	 */
	public JMenuItem getItemWatchlist() {
		return itemWatchlist;
	}

	/**
	 * Gets the item login.
	 *
	 * @return the item login
	 */
	public JMenuItem getItemLogin() {
		return itemLogin;
	}

	/**
	 * Gets the item logout.
	 *
	 * @return the item logout
	 */
	public JMenuItem getItemLogout() {
		return itemLogout;
	}

	/**
	 * Gets the item exchange.
	 *
	 * @return the item exchange
	 */
	public JMenuItem getItemExchange() {
		return itemExchange;
	}

	/**
	 * Gets the content pane.
	 *
	 * @return the content pane
	 */
	public JPanel getContentPane() {
		return contentPane;
	}

	/**
	 * Gets the home.
	 *
	 * @return the home
	 */
	public JMenu getHome() {
		return home;
	}

	/**
	 * Gets the tools.
	 *
	 * @return the tools
	 */
	public JMenu getTools() {
		return tools;
	}

	/**
	 * Inits the app menu.
	 */
	public void initMenu() {

		menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.activeCaptionBorder);

		home = new JMenu("Home");
		tools = new JMenu("Tools");
		session = new JMenu("Session");
		itemPortfolio = new JMenuItem("Portfolio");
		itemWatchlist = new JMenuItem("Watchlist");
		itemLogin = new JMenuItem("Login Page");
		itemLogout = new JMenuItem("Logout");
		itemLogout.setVisible(false);
		itemExchange = new JMenuItem("Exchange");

		tools.add(itemPortfolio);
		tools.add(itemWatchlist);

		session.add(itemLogin);
		session.add(itemLogout);

		home.add(itemExchange);

		menuBar.add(home);
		menuBar.add(tools);
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(session);

		setJMenuBar(menuBar);

	}

	/**
	 * Sets the user interface.
	 */
	public void setUI() {

		contentPane = new JPanel(new BorderLayout(50, 50));
		contentPane.setFont(fuente1);
		contentPane.setBorder(fondo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 900);
		setMinimumSize(new Dimension(1400, 900));
		setContentPane(contentPane);

		capas = new JPanel(cardLayout);

		mainWindowContainer = new JPanel(cardLayout);
		userPanel.setLayout(cardLayout);
		userPanel.add(userPanel.getContentPaneUser());

		capas.add(mainWindowContainer, "MainWindowPanel");
		capas.add(userPanel, "UserPanel");

		contentPane.add(capas, BorderLayout.CENTER);

		setIconImage(getImage("elrondIcon.jpg"));
		setTitle("Zpectrum");
		mainWindowPresentation();

	}

	/**
	 * Sets the listener handler of app.
	 *
	 * @param handler the new handler
	 */
	public void setHandler(EventsHandlerMainWindow handler) {

		itemExchange.addActionListener(handler);
		itemPortfolio.addActionListener(handler);
		itemWatchlist.addActionListener(handler);
		itemLogin.addActionListener(handler);
		itemLogout.addActionListener(handler);
		contentPane.addComponentListener(handler);
		loginButton.addActionListener(handler);

	}

	/**
	 * Make the app panels: portfolio y watchlist.
	 */
	public void makePanels() {

		portfolioPanel = new PortfolioPanel(this);
		watchListPanel = new WatchlistPanel(this);

		portfolioWindowHandler = new EventsHandlerPortfolio(userRepository, servicioIMPL, peticiones, this);
		watchlistWindowHandler = new EventsHandlerWatchlist(this);

		portfolioPanel.setLayout(cardLayout);
		portfolioPanel.add(portfolioPanel.getContentPanePortfolio());

		watchListPanel.setLayout(cardLayout);
		watchListPanel.add(watchListPanel.getContentPaneWatchlist());

		capas.add(portfolioPanel, "PortfolioPanel");
		capas.add(watchListPanel, "WatchlistPanel");

		this.getPortfolioPanel().setPortfolioHandler(portfolioWindowHandler);
		this.getWatchListPanel().setWatchlistHandler(watchlistWindowHandler);
	}

	/**
	 * Gets the row count.
	 *
	 * @return the row count
	 */
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Gets the column count.
	 *
	 * @return the column count
	 */
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Gets the column name.
	 *
	 * @param columnIndex the column index
	 * @return the column name
	 */
	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Gets the column class.
	 *
	 * @param columnIndex the column index
	 * @return the column class
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Gets the value at.
	 *
	 * @param rowIndex    the row index
	 * @param columnIndex the column index
	 * @return the value at
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Sets the value at.
	 *
	 * @param aValue      the a value
	 * @param rowIndex    the row index
	 * @param columnIndex the column index
	 */
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}

	/**
	 * Adds the table model listener.
	 *
	 * @param l the l
	 */
	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	/**
	 * Removes the table model listener.
	 *
	 * @param l the l
	 */
	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	/**
	 * Checks if is cell editable.
	 *
	 * @param rowIndex    the row index
	 * @param columnIndex the column index
	 * @return true, if is cell editable
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Gets the price of cryptocurrency.
	 *
	 * @param crypto the cryptocurrency
	 * @return the price
	 */
	private String priceStringValue(TokensMaiar crypto) {
		String finalString = "0.";
		if (crypto.toString().contains("E-")) {

			String process = "";
			String lastC = String.valueOf(crypto.getPrice()).substring(String.valueOf(crypto.getPrice()).length() - 1);
			int lastCN = Integer.parseInt(lastC);
			int length = lastCN;
			length = length - 1;
			int[] ceros = new int[length];
			for (int i = 0; i < ceros.length; i++) {
				ceros[i] = 0;
				process += ceros[i];
			}
			String precio = String.valueOf(crypto.getPrice());
			process += precio;
			String aux = process.substring(process.length() - 3);
			process = process.replace(aux, "");
			process = process.replace(".", "");
			finalString += process;
			return finalString;
		}
		String result = String.valueOf(crypto.getPrice());
		return result;

	}

	/**
	 * Gets table of tokens maiar.
	 *
	 * @return the table of tokens
	 */
	@SuppressWarnings("serial")
	private JTable tokensMaiar() {

		List<TokensMaiar> tokens = peticiones.tokensOnMaiar();
		String[] columsName = new String[] { "Name", "Price" };
		DefaultTableModel modelo = new DefaultTableModel(1, columsName.length);
		modelo.setColumnIdentifiers(columsName);
		if (tokens.size() == 0) {
			return null;
		}

		for (TokensMaiar tokenMaiar : tokens) {

			modelo.addRow(new Object[] { tokenMaiar.getName(), priceStringValue(tokenMaiar) });
		}
		modelo.removeRow(0);
		table = new JTable(modelo) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// disable editing:
				return false;
			}
		};
		table.setRowHeight(22);
		table.setShowGrid(false);
		table.setOpaque(false);
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				setFont(fuenteTable);
				if (hasFocus) {
					table.setFont(new Font("Tahoma", Font.ITALIC, 16));
				}
				return this;
			}

		};

		renderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(renderer);
		table.getColumnModel().getColumn(1).setCellRenderer(renderer);

		return table;
	}

	/**
	 * Main window presentation.
	 */
	private void mainWindowPresentation() {

		maiarExchangeLabel = new JLabel("<html><p>Maiar Exchange</p></html>");
		maiarExchangeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		maiarExchangeLabel.setFont(fuente1);
		maiarExchangeLabel.setForeground(Color.WHITE);
		maiarExchangeLabel.setBorder(new EmptyBorder(40, 0, 0, 0));
		contentPane.add(maiarExchangeLabel, BorderLayout.NORTH);

		String warningText = "<html><p>This space is dedicated to monitoring your actions, records, nft's and a lot more within elrond blockchain."
				+ " This app and his creator takes none responsibility for any loss may cost you. You are the only one responsible of "
				+ "any data you give.</p></html>";
		presentationJLabel2 = new JLabel(warningText);
		presentationJLabel2.setFont(fuente1);
		presentationJLabel2.setForeground(Color.WHITE);
		Border margin2 = new EmptyBorder(10, 30, 80, 10);
		presentationJLabel2.setBorder(margin2);
		contentPane.add(presentationJLabel2, BorderLayout.SOUTH);

		loginButton = new JButton("Login");
		loginButton.setPreferredSize(new Dimension(120, 30));
		mainPanel = new JPanel(new MigLayout("fill", "[][grow]", "[grow][]"));

		mainWindowContainer.add(mainPanel);
		if (tokensMaiar() == null) {
			mainPanel.add(new JLabel("Maiar Exchange api call under maintenance, sorry for the inconvenience"),
					"cell 1 0, alignx center");
		} else {
			mainPanel.add(new JScrollPane(tokensMaiar()), "cell 1 0, alignx center");
		}

		mainPanel.add(loginButton, "cell 1 1, alignx center");

	}
}
