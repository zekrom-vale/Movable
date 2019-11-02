package movable;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings({"javadoc", "hiding"})
public class Circle implements Movable{

	protected Point point;
	protected int radius;
	
	/**
	* Creates a new Circle
	* @param x the current x cordanate of the circle
	* @param y the current y cordanate of the circle
	* @param dx the default speed the circle can travel per second in the x direction
	* @param dy the default speed the circle can travel per second in the y direction
	* @param radius the radius of the circle
	* @param color the color of the circle
	*/
	public Circle(
		final int x, final int y, final double dx, final double dy,
		final int radius, final Color color
		){
		this.point=new Point(x, y, dx, dy, color);
		this.radius=radius;
	}

	/**
	* Draws the circle on the JPain
	* @param g the graphics to draw on
	*/
	@Override
	public void draw(final Graphics g){
		g.setColor(this.point.color);
		g.fillOval(
			this.point.x-this.radius, this.point.y-this.radius, this.radius*2,
			this.radius*2
			);
	}

	/**
	* Moves the x and y cord by the current action 
	*/
	@Override
	public void move(){
		this.point.move();

	}

	/**
	* Creates a new {@link Action} object to to store the action for later use<br>
	* Creates and stores an action to be preforemed latter, specificaly move down
	* @param t how long to preform the action
	* @param factor The factor of dx to move (2 is twice as fast, 1 is exactly the same speed, .5 is half, 0 is nothing)
	* @return this to allow chaining of methods
	 * @see          movable.Point#moveDown(double)
	 */
	@Override
	public Circle moveDown(final double t, final double factor){
		this.point.moveDown(t, factor);
		return this;
	}

	/**
	* Creates a new {@link Action} object to to store the action for later use<br>
	* Creates and stores an action to be preforemed latter, specificaly move left
	* @param t how long to preform the action
	* @param factor The factor of dx to move (2 is twice as fast, 1 is exactly the same speed, .5 is half, 0 is nothing)
	* @return this to allow chaining of methods
	 * @see          movable.Point#moveLeft(double)
	 */
	@Override
	public Circle moveLeft(final double t, final double factor){
		this.point.moveLeft(t, factor);
		return this;
	}

	/**
	* Creates a new {@link Action} object to to store the action for later use<br>
	* Creates and stores an action to be preforemed latter, specificaly move right
	* @param t how long to preform the action
	* @param factor The factor of dx to move (2 is twice as fast, 1 is exactly the same speed, .5 is half, 0 is nothing)
	* @return this to allow chaining of methods
	 * @see          movable.Point#moveRight(double)
	 */
	@Override
	public Circle moveRight(final double t, final double factor){
		this.point.moveRight(t, factor);
		return this;
	}


	/**
	* Creates a new {@link Action} object to to store the action for later use<br>
	* Creates and stores an action to be preforemed latter, specificaly move up
	* @param t how long to preform the action
	* @param factor The factor of dy to move (2 is twice as fast, 1 is exactly the same speed, .5 is half, 0 is nothing)
	* @return this to allow chaining of methods
	 * @see          movable.Point#moveUp(double)
	 */
	@Override
	public Circle moveUp(final double t, final double factor){
		this.point.moveUp(t, factor);
		return this;
	}

	/**
	* Manages switching actions and for how long they are preformed
	*/
	@Override
	public void next(){
		this.point.next();
	}
}
