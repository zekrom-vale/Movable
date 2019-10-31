package graphics;

import java.awt.BorderLayout;
import java.util.LinkedList;
import java.util.function.Consumer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;


/**
 * Creates a new Top Frame to render objects
 *
 * @author Zekrom
 *
 */
@SuppressWarnings("javadoc")
public class Top extends JPanel{
	/**
	 * The height of the window
	 */
	public static final int height=500;


	/**
	 *
	 */
	private static final long serialVersionUID=1L;

	/**
	 * The width of the window
	 */
	public static final int width=700;

	/**
	 * The board that renders the objects
	 */
	public final LinkedList<DrawPanel> drawPanel=new LinkedList<>();


	public JFrame frame=new JFrame("Move");

	/**
	 * Default constructor<br>
	 * Creates a board to render objects on
	 */
	public Top(final Consumer<Top> consumer){
		this.frame.setLayout(new BorderLayout());
		consumer.accept(this);
		new Timer(16, e->{
			Top.this.drawPanel.forEach(p->{
				p.list.forEach(x->{
					x.next();
				});
				p.repaint();
			});
		}).start();
		this.frame.pack();
		this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
	}
}
