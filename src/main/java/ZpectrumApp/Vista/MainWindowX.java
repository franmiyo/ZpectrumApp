package ZpectrumApp.Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainWindowX extends JFrame {

	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public MainWindowX() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		setContentPane(contentPane);
	}

}
