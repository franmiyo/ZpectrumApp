package ZpectrumApp.Vista;


import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * The Class JListCellRenderer.
 * 
 * @author Francisco González
 * @version 1.0
 */
@SuppressWarnings("serial")
public class JListCellRenderer extends JLabel implements ListCellRenderer<String> {

	/**
	 * Constructor: Instantiates a new j list cell renderer.
	 */
	public JListCellRenderer() {
		setOpaque(true);
	}

	/**
	 * Gets the list cell renderer component.
	 *
	 * @param list the list
	 * @param value the value
	 * @param index the index
	 * @param isSelected if is selected
	 * @param cellHasFocus the cell has focus
	 * @return the list cell renderer component
	 */
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
