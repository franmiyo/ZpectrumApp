package ZpectrumApp.Vista;


import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;


@SuppressWarnings("serial")
public class JListCellRenderer extends JLabel implements ListCellRenderer<String> {

	public JListCellRenderer() {
		setOpaque(true);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends String> list, String value, int index,
			boolean isSelected, boolean cellHasFocus) {

		if (isSelected) {
			list.setFont(new Font("Tahoma", Font.ITALIC, 15));
		} else {
			list.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}

		return this;
	}

}
