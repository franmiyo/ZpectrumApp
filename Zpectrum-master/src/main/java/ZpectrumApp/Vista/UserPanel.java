package ZpectrumApp.Vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import ZpectrumApp.EventHandler.EventsHandlerUser;
import ZpectrumApp.Modelo.Usuario;
import ZpectrumApp.Repositorio.UsuarioRepositorio;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.border.EmptyBorder;
import javax.swing.ListSelectionModel;

/**
 * The Class UserPanel.
 * 
 * @author Francisco González and Cristian Fernández
 * @version 1.0
 */
public class UserPanel extends JPanel implements ListCellRenderer<String> {

	private static final long serialVersionUID = 2131340037745280119L;
	private JPanel contentPaneUser;
	private Font fuente1 = new Font("Tahoma", Font.PLAIN, 22), fuente2 = new Font("Tahoma", Font.PLAIN, 14);
	private JLabel jLblERD, jLblUserName, jLblHelp, jLblNewHelpText, registeredUsers;
	private JTextField jTxtFERD, jTextFUserName;
	private JButton jBtnRegister, jBtnDelete, jBtnCreate;
	private UsuarioRepositorio userRepository;
	private JList<String> usersJList;
	private DefaultListModel<String> model = new DefaultListModel<>();
	private List<Usuario> finalUserList = new ArrayList<Usuario>();
	private MainWindow mainWindow;

	/**
	 * Constructor: Instantiates a new user panel.
	 *
	 * @param userRepository the user repository
	 * @param mainwindow     the mainwindow
	 */
	public UserPanel(UsuarioRepositorio userRepository, MainWindow mainwindow) {

		this.mainWindow = mainwindow;
		this.userRepository = userRepository;
		setUI();
		setVisible(true);
	}

	public static Image getImage(final String pathAndFileName) {
		final URL url = Thread.currentThread().getContextClassLoader().getResource(pathAndFileName);
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public DefaultListModel<String> getModel() {
		return model;
	}

	/**
	 * Gets the users JList.
	 *
	 * @return the users JList
	 */
	public JList<String> getUsersJList() {
		return usersJList;
	}

	/**
	 * Gets the final user list.
	 *
	 * @return the final user list
	 */
	public List<Usuario> getFinalUserList() {
		return finalUserList;
	}

	/**
	 * Gets the Create button.
	 *
	 * @return the Create button
	 */
	public JButton getjBtnCreate() {
		return jBtnCreate;
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
	 * Gets the Delete button.
	 *
	 * @return the Delete button
	 */
	public JButton getjBtnDelete() {
		return jBtnDelete;
	}

	/**
	 * Gets the registered users.
	 *
	 * @return the registered users
	 */
	public JLabel getResgisteredUsers() {
		return registeredUsers;
	}

	/**
	 * Gets the user JList.
	 *
	 * @return the JList
	 */
	public JList<String> getList() {
		return usersJList;
	}

	/**
	 * Gets the new help text label.
	 *
	 * @return the new help text label
	 */
	public JLabel getjLblNewHelpText() {
		return jLblNewHelpText;
	}

	/**
	 * Gets the help label.
	 *
	 * @return the help label
	 */
	public JLabel getjLblHelp() {
		return jLblHelp;
	}

	/**
	 * Gets the FERD text field.
	 *
	 * @return the FERD text field
	 */
	public JTextField getjTxtFERD() {
		return jTxtFERD;
	}

	/**
	 * Gets the user name text.
	 *
	 * @return the user name text
	 */
	public JTextField getjTextFUserName() {
		return jTextFUserName;
	}

	/**
	 * Gets the Register button.
	 *
	 * @return the Register button
	 */
	public JButton getjBtnRegister() {
		return jBtnRegister;
	}

	/**
	 * Gets the content panel user.
	 *
	 * @return the content panel user
	 */
	public JPanel getContentPaneUser() {
		return contentPaneUser;
	}

	/**
	 * Sets the user handler.
	 *
	 * @param handler the new user handler
	 */
	public void setUserHandler(EventsHandlerUser handler) {

		jBtnRegister.addActionListener(handler);
		jBtnDelete.addActionListener(handler);
		jBtnCreate.addActionListener(handler);
		jLblHelp.addMouseListener(handler);
		mainWindow.getUserPanel().addMouseListener(handler);
		mainWindow.getContentPane().addMouseListener(handler);
	}

	/**
	 * Update list.
	 */
	public void updateList() {
		model.removeAllElements();
		List<Usuario> userList = userRepository.findAll();

		for (Usuario user : userList) {
			finalUserList.add(user);
		}

		for (Usuario user : userList) {
			model.addElement(user.getUserName());
		}

		for (Usuario usuario : userList) {
			System.out.println(usuario.getUserName());
		}

		if (userList.size() == 0) {
			model.addElement("There is no users");
		}
	}

	/**
	 * Gets the list cell renderer component.
	 *
	 * @param list         the list
	 * @param value        the value
	 * @param index        the index
	 * @param isSelected   the is selected
	 * @param cellHasFocus the cell has focus
	 * @return the list cell renderer component
	 */
	@Override
	public Component getListCellRendererComponent(JList<? extends String> list, String value, int index,
			boolean isSelected, boolean cellHasFocus) {

		return null;
	}

	/**
	 * Sets the user list.
	 */
	private void setUserList() {

		usersJList = new JList<String>(model);
		contentPaneUser.add(usersJList, "cell 2 0 0 3, grow, alignx left");
		usersJList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		usersJList.setForeground(Color.GRAY);
		usersJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		usersJList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		usersJList.setBorder(new EmptyBorder(5, 10, 5, 5));

		List<Usuario> userList = userRepository.findAll();

		if (userList.size() == 0) {
			model.addElement("There is no users");

		} else {

			for (Usuario user : userList) {
				finalUserList.add(user);
			}

			for (Usuario user : finalUserList) {
				model.addElement(user.getUserName());
			}
		}
	}

	/**
	 * Sets the user interface.
	 */
	private void setUI() {

		contentPaneUser = new JPanel(new MigLayout("fill", "[][grow][grow]", "[][][]"));

		jLblUserName = new JLabel("Name: ");
		jLblUserName.setPreferredSize(new Dimension(80, 25));
		jLblUserName.setFont(fuente1);
		contentPaneUser.add(jLblUserName, "cell 0 0");

		jTextFUserName = new JTextField();
		jTextFUserName.setColumns(10);
		contentPaneUser.add(jTextFUserName, "cell 0 0");

		jLblERD = new JLabel("ERD: ");
		jLblERD.setPreferredSize(new Dimension(80, 25));
		jLblERD.setFont(fuente1);
		contentPaneUser.add(jLblERD, "cell 0 1");

		jTxtFERD = new JTextField();
		jTxtFERD.setColumns(10);
		contentPaneUser.add(jTxtFERD, "cell 0 1");

		jLblHelp = new JLabel();
		jLblHelp.setIcon(new ImageIcon(getImage("question.png")));
		contentPaneUser.add(jLblHelp, "cell 0 1");

		jLblNewHelpText = new JLabel(
				"The ERD adress (elrond abbreviated) data it's required by the elrond blockchain to "
						+ "locate the adress and all info related");
		jLblNewHelpText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLblNewHelpText.setVisible(false);
		contentPaneUser.add(jLblNewHelpText, "cell 1 2, alignx center");

		registeredUsers = new JLabel(" Registered users: ");
		registeredUsers.setFont(fuente2);
		contentPaneUser.add(registeredUsers, "cell 1 0, alignx center");

		jBtnRegister = new JButton("Login");
		jBtnRegister.setPreferredSize(new Dimension(125, 35));
		contentPaneUser.add(jBtnRegister, "cell 1 1, alignx center");

		jBtnDelete = new JButton("Delete");
		jBtnDelete.setPreferredSize(new Dimension(125, 35));
		contentPaneUser.add(jBtnDelete, "cell 1 1, alignx center");

		jBtnCreate = new JButton("Create");
		jBtnCreate.setPreferredSize(new Dimension(125, 35));
		contentPaneUser.add(jBtnCreate, "cell 1 1, alignx center");

		setUserList();
	}
}
