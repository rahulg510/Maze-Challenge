package business;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

/**
 * 11/12: JL: Implemented LabelIcon
 *
 */
public class LabelIcon implements Icon {

	private int width;
	private int height;
	
	public LabelIcon(int width,int height){
        this.width=width;
        this.height=height;
    }
	
	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		g.setColor(Color.RED);
		g.fillOval(x,y,width,height);
	}

}