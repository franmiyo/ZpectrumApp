package ZpectrumApp.Vista;

import java.awt.*;
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
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;
import java.util.List;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class MainWindow extends JFrame implements TableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8312087735648019235L;

	private Peticiones peticiones;
	private JPanel contentPane, mainWindowContainer, capas, mainPanel;
	private CardLayout cardLayout = new CardLayout();
	private JMenuBar menuBar;
	private JMenu home, tools, login, logout;
	private JMenuItem itemPortfolio, itemWatchlist;
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

	public NftRepositorio getNftRepository() {
		return nftRepository;
	}

	public UsuarioRepositorio getUserRepository() {
		return userRepository;
	}

	public Peticiones getPeticiones() {
		return peticiones;
	}

	public boolean isLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(boolean loggedUser) {
		this.loggedUser = loggedUser;
	}

	public EventsHandlerPortfolio getPortfolioWindowHandler() {
		return portfolioWindowHandler;
	}

	public void setPortfolioWindowHandler(EventsHandlerPortfolio portfolioWindowHandler) {
		this.portfolioWindowHandler = portfolioWindowHandler;
	}

	public EventsHandlerWatchlist getWatchlistWindowHandler() {
		return watchlistWindowHandler;
	}

	public void setWatchlistWindowHandler(EventsHandlerWatchlist watchlistWindowHandler) {
		this.watchlistWindowHandler = watchlistWindowHandler;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public JMenu getLogout() {
		return logout;
	}

	public JPanel getCapas() {
		return capas;
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public PortfolioPanel getPortfolioPanel() {
		return portfolioPanel;
	}

	public WatchlistPanel getWatchListPanel() {
		return watchListPanel;
	}

	public UserPanel getUserPanel() {
		return userPanel;
	}

	public JPanel getMainWindowContainer() {
		return mainWindowContainer;
	}

	public JLabel getMaiarExchangeLabel() {
		return maiarExchangeLabel;
	}

	public JLabel getPresentationJLabel2() {
		return presentationJLabel2;
	}

	public JPanel getContainer() {
		return mainWindowContainer;
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public JMenuItem getItemPortfolio() {
		return itemPortfolio;
	}

	public JMenuItem getItemWatchlist() {
		return itemWatchlist;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JMenu getHome() {
		return home;
	}

	public JMenu getTools() {
		return tools;
	}

	public JMenu getLogin() {
		return login;
	}

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

	public void initMenu() {

		menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.activeCaptionBorder);

		home = new JMenu("Home");
		tools = new JMenu("Tools");
		login = new JMenu("Login");
		logout = new JMenu("Logout");
		logout.setVisible(false);

		itemPortfolio = new JMenuItem("Portfolio");
		itemWatchlist = new JMenuItem("Watchlist");

		tools.add(itemPortfolio);
		tools.add(itemWatchlist);

		menuBar.add(home);
		menuBar.add(tools);
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(logout);
		menuBar.add(login);

		setJMenuBar(menuBar);

	}

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

		setIconImage(Toolkit.getDefaultToolkit().getImage("Images/elrondIcon.jpg"));
		setTitle("Zpectrum - Home");
		mainWindowPresentation();

	}

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
		mainPanel.add(new JScrollPane(tokensMaiar()), "cell 1 0, alignx center");
		mainPanel.add(loginButton, "cell 1 1, alignx center");

	}

	@SuppressWarnings("serial")
	private JTable tokensMaiar() {

		List<TokensMaiar> tokens = peticiones.tokensOnMaiar();
		String[] columsName = new String[] { "Name", "Price" };
		DefaultTableModel modelo = new DefaultTableModel(2, columsName.length);
		modelo.setColumnIdentifiers(columsName);

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
		// table.setDefaultRenderer(getClass(), renderer);
		table.getColumnModel().getColumn(0).setCellRenderer(renderer);
		table.getColumnModel().getColumn(1).setCellRenderer(renderer);

		return table;
	}

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

	public void setHandler(EventsHandlerMainWindow handler) {

		itemPortfolio.addActionListener(handler);
		itemWatchlist.addActionListener(handler);
		login.addMenuListener(handler);
		logout.addMenuListener(handler);
		home.addMenuListener(handler);
		contentPane.addComponentListener(handler);
		loginButton.addActionListener(handler);
	}

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

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}
}
