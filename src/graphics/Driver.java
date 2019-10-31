package graphics;

import java.awt.BorderLayout;
import java.awt.Color;

import movable.Movable;
import movable.Point;

public class Driver{
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
				final DrawPanel panel=new DrawPanel();

				final Movable object1
				=new movable.Point(0, 0, 100, 100, Color.cyan);
				object1.moveDown(.3);
				object1.moveRight(1);
				object1.sleep(1.13223);
				object1.moveDown(1);
				object1.moveUp(1, .7);

				final Movable object2
				=new movable.Circle(100, 0, 150, 150, 20, Color.red);
				object2.moveDown(1);
				object2.moveRight(.6);
				object2.moveDown(1);
				object2.moveLeft(1);
				object2.moveDown(2);
				object2.moveUp(1, 4);

				final Movable object3
				=new Point(500, 300, 100, 200, Color.black);
				object3.moveRight(1.2);
				object3.moveDown(2);
				object3.moveLeft(1);

				panel.list.add(object1);
				panel.list.add(object2);
				panel.list.add(object3);
				x.drawPanel.add(panel);
				x.frame.add(panel, BorderLayout.CENTER);


				final DrawPanel panelb=new DrawPanel();

				final Movable object1b
				=new movable.Point(0, 0, 200, 200, Color.cyan);
				object1b.moveDown(.3);
				object1b.moveRight(1);
				object1b.sleep(1.13223);
				object1b.moveDown(1);
				object1b.moveUp(1, .7);

				final Movable object2b
				=new movable.Circle(100, 0, 50, 50, 20, Color.red);
				object2b.moveDown(1);
				object2b.moveRight(.6);
				object2b.moveDown(1);
				object2b.moveLeft(1);
				object2b.moveDown(2);
				object2b.moveUp(1, 4);

				final Movable object3b
				=new Point(200, 300, 100, 200, Color.black);
				object3b.moveRight(1.2);
				object3b.moveDown(2);
				object3b.moveLeft(1);

				panelb.list.add(object1b);
				panelb.list.add(object2b);
				panelb.list.add(object3b);
				x.drawPanel.add(panelb);
				x.frame.add(panelb, BorderLayout.CENTER);

			});
		});
	}
}
