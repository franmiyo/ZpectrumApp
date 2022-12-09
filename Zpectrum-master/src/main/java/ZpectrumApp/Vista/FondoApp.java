package ZpectrumApp.Vista;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.border.Border;

/**
 * The Class FondoApp.
 * 
 * @author Francisco González
 * @version 1.0
 */
public class FondoApp implements Border{

    private Image mImagen = null;
    
    /**
     * Constructor: We indicate the image that we want to be redimensioned.
     *
     * @param image the image
     */

	public FondoApp(Image  image) {
		super();
		this.mImagen = image;
	}

	/**
	 * Paint border.
	 *
	 * @param c the component
	 * @param g the graphics
	 * @param x the coordinate x
	 * @param y the coordinate y
	 * @param width the width
	 * @param height the height
	 */
	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        if (mImagen != null) {
            g.drawImage(mImagen, 0, 0, width, height, null);
        }		
	}

	/**
	 * Gets the border insets.
	 *
	 * @param c the component
	 * @return the border insets
	 */
	@Override
	public Insets getBorderInsets(Component c) {
		return new Insets(0, 0, 0, 0);
	}

	/**
	 * Checks if is border opaque.
	 *
	 * @return true, if is border opaque
	 */
	@Override
	public boolean isBorderOpaque() {
		return true;
	}
     


}
