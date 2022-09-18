package ZpectrumApp.Vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
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

public class UserPanel extends JPanel implements ListCellRenderer<String> {

	/**
	 * 
	 */
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

	public JList<String> getUsersJList() {
		return usersJList;
	}

	public List<Usuario> getFinalUserList() {
		return finalUserList;
	}

	public JButton getjBtnCreate() {
		return jBtnCreate;
	}

	public MainWindow getMainWindow() {
		return mainWindow;
	}

	public JButton getjBtnDelete() {
		return jBtnDelete;
	}

	public JLabel getResgisteredUsers() {
		return registeredUsers;
	}

	public JList<String> getList() {
		return usersJList;
	}

	public JLabel getjLblNewHelpText() {
		return jLblNewHelpText;
	}

	public JLabel getjLblHelp() {
		return jLblHelp;
	}

	public JTextField getjTxtFERD() {
		return jTxtFERD;
	}

	public JTextField getjTextFUserName() {
		return jTextFUserName;
	}

	public JButton getjBtnRegister() {
		return jBtnRegister;
	}

	public JPanel getContentPaneUser() {
		return contentPaneUser;
	}

	public UserPanel(UsuarioRepositorio userRepository, MainWindow mainwindow) {

		this.mainWindow = mainwindow;
		this.userRepository = userRepository;
		setUI();
		setVisible(true);
	}

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
		jLblHelp.setIcon(new ImageIcon("Images/question.png"));
		contentPaneUser.add(jLblHelp, "cell 0 1");

		jLblNewHelpText = new JLabel(
				"The ERD adress (elrond abbreviated) adress data it's required by the elrond blockchain to "
						+ "locate the adress and all info related");
		jLblNewHelpText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLblNewHelpText.setVisible(false);
		contentPaneUser.add(jLblNewHelpText, "cell 1 2, alignx center");

		registeredUsers = new JLabel(" Usuarios registrados: ");
		registeredUsers.setFont(fuente2);
		contentPaneUser.add(registeredUsers, "cell 1 0, alignx center");

		jBtnRegister = new JButton("Login");
		jBtnRegister.setPreferredSize(new Dimension(125,35));
		contentPaneUser.add(jBtnRegister, "cell 1 1, alignx center");

		jBtnDelete = new JButton("Delete");
		jBtnDelete.setPreferredSize(new Dimension(125,35));
		contentPaneUser.add(jBtnDelete, "cell 1 1, alignx center");

		jBtnCreate = new JButton("Create");
		jBtnCreate.setPreferredSize(new Dimension(125,35));
		contentPaneUser.add(jBtnCreate, "cell 1 1, alignx center");

		setUserList();

	}

	public void setUserHandler(EventsHandlerUser handler) {

		jBtnRegister.addActionListener(handler);
		jBtnDelete.addActionListener(handler);
		jBtnCreate.addActionListener(handler);
		jLblHelp.addMouseListener(handler);

	}

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
			model.addElement("No hay usuarios registrados");
		} else {
			for (Usuario user : userList) {
				finalUserList.add(user);
			}

			for (Usuario user : finalUserList) {
				model.addElement(user.getUserName());
			}
		}

	}

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
			model.addElement("No hay usuarios registrados");
		}

	}

	@Override
	public Component getListCellRendererComponent(JList<? extends String> list, String value, int index,
			boolean isSelected, boolean cellHasFocus) {
		// TODO Auto-generated method stub
		return null;
	}
}
