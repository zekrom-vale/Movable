package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.function.Consumer;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import movable.Movable;
import movable.Point;

/**
 * Creates a new Top Frame to render objects
 *
 * @author Zekrom
 *
 */
@SuppressWarnings("javadoc")
public class Top extends JPanel{
	public class DrawPanel extends JPanel{
		/**
		 *
		 */
		private static final long serialVersionUID=1L;


		@Override
		public Dimension getPreferredSize(){
			return new Dimension(Top.width, Top.height);
		}

		@Override
		protected void paintComponent(final Graphics g){
			super.paintComponent(g);
			Top.this.list.forEach(x->{
				x.move();
				x.draw(g);
			});
		}

	}


	/**
	 * The height of the window
	 */
	private static final int height=500;


	/**
	 *
	 */
	private static final long serialVersionUID=1L;

	/**
	 * The width of the window
	 */
	private static final int width=700;


	/**
	 * Main method that starts the JFrame/JPain
	 *
	 * @param args
	 *                 Arguments
	 */
	@SuppressWarnings("unused")
	public static void main(final String[] args){
		java.awt.EventQueue.invokeLater(()->{
			new Top(x->{
				x.list
					.add(new movable.Point(0, 0, 100, 100, Color.cyan).moveDown(.3).moveRight(1).sleep(1).moveDown(1).moveUp(1, .7));
				x.list.add(
					new movable.Circle(100, 0, 150, 150, 20, Color.red).moveDown(1).moveRight(.6).moveDown(1).moveLeft(1).moveDown(2).moveUp(1, 4)
				);
				x.list
					.add(new Point(500, 300, 100, 200, Color.black).moveRight(1.2).moveDown(2).moveLeft(1));

			});
			new Top(x->{
				x.list
					.add(new movable.Point(0, 0, 100, 100, Color.cyan).moveDown(.3).moveRight(1).sleep(1).moveDown(1).moveUp(1, .7));
				x.list.add(
					new movable.Circle(100, 0, 150, 150, 20, Color.red).moveDown(1).moveRight(.6).moveDown(1).moveLeft(1).moveDown(2).moveUp(1, 4)
				);
				x.list
					.add(new Point(500, 300, 100, -100, Color.black).moveRight(1.2).moveDown(2).moveLeft(1));

			});
		});
	}


	/**
	 * The board that renders the objects
	 */
	DrawPanel drawPanel=new DrawPanel();


	/**
	 * A list of Movable objects
	 */
	protected ArrayList<Movable> list=new ArrayList<>();


	/**
	 * Default constructor<br>
	 * Creates a board to render objects on
	 */
	public Top(final Consumer<Top> consumer){
		consumer.accept(this);
		//Core
		final JFrame frame=new JFrame("Move");
		new Timer(16, new AbstractAction(){

			/**
			 *
			 */
			private static final long serialVersionUID=1L;

			@Override
			public void actionPerformed(final ActionEvent e){
				Top.this.list.forEach(x->{
					x.next();
				});
				Top.this.drawPanel.repaint();
			}
		}).start();
		frame.add(this.drawPanel);
		frame.pack();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
