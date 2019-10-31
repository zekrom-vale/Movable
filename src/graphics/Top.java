package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import movable.Movable;
import movable.Point;

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
	private static final int height=500;


	/**
	 *
	 */
	private static final long serialVersionUID=1L;

	private static final int width=700;
	@SuppressWarnings("unused")
	public static void main(final String[] args){
		java.awt.EventQueue.invokeLater(()->{
			new Top();
		});
	}


	DrawPanel drawPanel=new DrawPanel();


	protected ArrayList<Movable> list=new ArrayList<>();
	protected long tick=0;

	public Top(){
		this.list
			.add(new movable.Point(0, 0, 100, 100, Color.cyan).moveDown(1).moveRight(1).sleep(1).moveDown(1).moveUp(1, .7));
		this.list.add(
			new movable.Circle(100, 0, 100, 100, 20, Color.red).moveDown(1).moveRight(1).moveDown(1).moveLeft(1).moveDown(2).moveUp(1, 4)
			);
		this.list
		.add(new Point(500, 300, 100, 100, Color.black).moveRight(1).moveDown(2).moveLeft(1));

		//Core
		final JFrame frame=new JFrame("Move");
		new Timer(16, new AbstractAction(){

			/**
			 *
			 */
			private static final long serialVersionUID=1L;

			@Override
			public void actionPerformed(final ActionEvent e){
				if(Top.this.tick%62==0){
					Top.this.list.forEach(x->{
						x.next();
					});
				}
				Top.this.tick++;
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
