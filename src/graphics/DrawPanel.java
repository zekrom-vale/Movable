package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JLayeredPane;

import movable.Movable;

/**
 * DrawPanel defines a JPanel to draw on
 */
public class DrawPanel extends JLayeredPane{
	/**
	 *
	 */
	private static final long serialVersionUID=1L;
	/**
	 * A list of Movable objects
	 */
	protected LinkedList<Movable> list=new LinkedList<>();
	{
		this.setOpaque(false);
		super.setBackground(new Color(0, 0, 0, 0));
		this.setBounds(0, 0, Top.width, Top.height);
	}


	@Override
	public Dimension getPreferredSize(){
		return new Dimension(Top.width, Top.height);
	}

	@Override
	protected void paintComponent(final Graphics g){
		super.paintComponent(g);
		this.list.forEach(x->{
			x.move();
			x.draw(g);
		});
	}

}