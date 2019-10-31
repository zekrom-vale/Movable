package movable;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings({"javadoc", "hiding"})
public class Circle implements Movable{

	protected Point point;
	private final int radius;
	public Circle(
		final int x, final int y, final double dx, final double dy,
		final int radius, final Color color
		){
		this.point=new Point(x, y, dx, dy, color);
		this.radius=radius;
	}


	@Override
	public void draw(final Graphics g){
		g.setColor(this.point.color);
		g.fillOval(this.point.x, this.point.y, this.radius*2, this.radius*2);
	}

	@Override
	public void move(){
		this.point.move();

	}

	/**
	 * @param factor
	 * @see          movable.Point#moveDown(double)
	 */
	@Override
	public Circle moveDown(final int t, final double factor){
		this.point.moveDown(t, factor);
		return this;
	}

	/**
	 * @param factor
	 * @see          movable.Point#moveLeft(double)
	 */
	@Override
	public Circle moveLeft(final int t, final double factor){
		this.point.moveLeft(t, factor);
		return this;
	}

	/**
	 * @param factor
	 * @see          movable.Point#moveRight(double)
	 */
	@Override
	public Circle moveRight(final int t, final double factor){
		this.point.moveRight(t, factor);
		return this;
	}


	/**
	 * @param factor
	 * @see          movable.Point#moveUp(double)
	 */
	@Override
	public Circle moveUp(final int t, final double factor){
		this.point.moveUp(t, factor);
		return this;
	}


	@Override
	public void next(){
		this.point.next();
	}
}
