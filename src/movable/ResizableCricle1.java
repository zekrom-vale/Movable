package movable;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("javadoc")

public class ResizableCricle1 implements Movable, Resizable{
	private final Circle circle;


	public ResizableCricle1(
		final int x, final int y, final double dx, final double dy,
		final int radius, final Color color
		){
		this.circle=new Circle(x, y, dx, dy, radius, color);
	}
	/**
	 * @param g
	 * @see     movable.Circle#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(final Graphics g){
		this.circle.draw(g);
	}

	/**
	 *
	 * @see movable.Circle#move()
	 */
	@Override
	public void move(){
		this.circle.move();
	}

	/**
	 * @param  t
	 * @param  factor
	 * @return
	 * @see           movable.Circle#moveDown(double, double)
	 */
	@Override
	public Circle moveDown(final double t, final double factor){
		return this.circle.moveDown(t, factor);
	}

	/**
	 * @param  t
	 * @param  factor
	 * @return
	 * @see           movable.Circle#moveLeft(double, double)
	 */
	@Override
	public Circle moveLeft(final double t, final double factor){
		return this.circle.moveLeft(t, factor);
	}

	/**
	 * @param  t
	 * @param  factor
	 * @return
	 * @see           movable.Circle#moveRight(double, double)
	 */
	@Override
	public Circle moveRight(final double t, final double factor){
		return this.circle.moveRight(t, factor);
	}

	/**
	 * @param  t
	 * @param  factor
	 * @return
	 * @see           movable.Circle#moveUp(double, double)
	 */
	@Override
	public Circle moveUp(final double t, final double factor){
		return this.circle.moveUp(t, factor);
	}

	/**
	 *
	 * @see movable.Circle#next()
	 */
	@Override
	public void next(){
		this.circle.next();
	}
	@Override
	public void resize(final double percent){
		this.circle.radius=(int)(this.circle.radius*percent/100);

	}
}
