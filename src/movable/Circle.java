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
	public Circle moveDown(final double factor){
		this.point.moveDown(factor);
		return this;
	}

	/**
	 * @param factor
	 * @see          movable.Point#moveLeft(double)
	 */
	@Override
	public Circle moveLeft(final double factor){
		this.point.moveLeft(factor);
		return this;
	}

	/**
	 * @param factor
	 * @see          movable.Point#moveRight(double)
	 */
	@Override
	public Circle moveRight(final double factor){
		this.point.moveRight(factor);
		return this;
	}


	/**
	 * @param factor
	 * @see          movable.Point#moveUp(double)
	 */
	@Override
	public Circle moveUp(final double factor){
		this.point.moveUp(factor);
		return this;
	}


	@Override
	public void next(){
		this.point.next();
	}
}
