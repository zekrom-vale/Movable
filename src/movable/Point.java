package movable;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Queue;

/**
* Class Point impliments Movable<br>
* This class defines all movable subclasses and is the core of how objects move
*/
@SuppressWarnings({"javadoc", "hiding"})
public class Point implements Movable{
	
	/**
	* Defines the current action to preform
	*/
	public Action action=new Action(0, 0, 0);
	
	/**
	* Defines a queue of actions to preform at a later time, once actions are done with they are discarded
	*/
	protected Queue<Action> actions=new LinkedList<>();
	
	/**
	* The color the point is
	*/
	protected Color color;
	
	/**
	* How fast the point can travel per second in the x direction
	*/
	protected double dx;

	
	/**
	* How fast the point can travel per second in the y direction
	*/
	protected double dy;

	/**
	* The current x cordanate for the point
	*/
	protected int x;
	
	/**
	* The current y cordanate for the point
	*/
	protected int y;
	
	/**
	* Creates a new point
	* @param x the current x cordanate of the point
	* @param y the current y cordanate of the point
	* @param dx the default speed the point can travel per second in the x direction
	* @param dy the default speed the point can travel per second in the y direction
	* @param color the color of the point
	*/
	public Point(
		final int x, final int y, final double dx, final double dy,
		final Color color
		){
		this.x=x;
		this.y=y;
		this.dx=dx;
		this.dy=dy;
		this.color=color;
		//Add a blank action so it does not error out
		//May be unessasay now that it impliments it automaticaly if none is provided
		//TODO try removing it
		this.actions.add(this.action);
	}
	
	/**
	* Draws the Point on the JPain
	* @param g the graphics to draw on
	*/
	@Override
	public void draw(final Graphics g){
		g.setColor(this.color);
		//Draw a small but visable rectangle and shift the x and y to the upper left as x and y is in the center (Standard for graphics)
		g.fillRect(this.x+3, this.y+3, 5, 5);
	}

	/**
	 * @return the color
	 */
	public Color getColor(){
		return this.color;
	}

	/**
	 * @return the x cord
	 */
	public int getX(){
		return this.x;
	}


	/**
	 * @return the y cord
	 */
	public int getY(){
		return this.y;
	}

	/**
	* Moves the x and y cord by the current action 
	*/
	@Override
	public void move(){
		this.y+=this.action.ddy;
		this.x+=this.action.ddx;
	}

	/**
	* Creates a new {@link Action} object to to store the action for later use<br>
	* Creates and stores an action to be preforemed latter, specificaly move down
	* @param t how long to preform the action
	* @param factor The factor of dx to move (2 is twice as fast, 1 is exactly the same speed, .5 is half, 0 is nothing)
	* @return this to allow chaining of methods
	*/
	@Override
	public Point moveDown(final double t, final double factor){
		this.actions.add(new Action(0, (int)(this.dy*factor), t));
		return this;

	}

	/**
	* Creates a new {@link Action} object to to store the action for later use<br>
	* Creates and stores an action to be preforemed latter, specificaly move left
	* @param t how long to preform the action
	* @param factor The factor of dx to move (2 is twice as fast, 1 is exactly the same speed, .5 is half, 0 is nothing)
	* @return this to allow chaining of methods
	*/
	@Override
	public Point moveLeft(final double t, final double factor){
		this.actions.add(new Action(-(int)(this.dy*factor), 0, t));
		return this;

	}

	/**
	* Creates a new {@link Action} object to to store the action for later use<br>
	* Creates and stores an action to be preforemed latter, specificaly move right
	* @param t how long to preform the action
	* @param factor The factor of dx to move (2 is twice as fast, 1 is exactly the same speed, .5 is half, 0 is nothing)
	* @return this to allow chaining of methods
	*/
	@Override
	public Point moveRight(final double t, final double factor){
		this.actions.add(new Action((int)(this.dy*factor), 0, t));
		return this;

	}

	/**
	* Creates a new {@link Action} object to to store the action for later use<br>
	* Creates and stores an action to be preforemed latter, specificaly move up
	* @param t how long to preform the action
	* @param factor The factor of dy to move (2 is twice as fast, 1 is exactly the same speed, .5 is half, 0 is nothing)
	* @return this to allow chaining of methods
	*/
	@Override
	public Point moveUp(final double t, final double factor){
		this.actions.add(new Action(0, -(int)(this.dy*factor), t));
		return this;

	}
	
	/**
	* Manages switching actions and for how long they are preformed
	*/
	@Override
	public void next(){
		if(this.action.t==0){
			this.action=this.actions.poll();
			if(this.action==null){
				this.action=new Action(0, 0, 1000);
			}
			else this.next();
			return;
		}
		if(this.action.t--==0){
			this.action=this.actions.poll();
			if(this.action==null) this.action=new Action(0, 0, 1000);
		}
	}


	/**
	 * @param color the color to set
	 */
	public void setColor(final Color color){
		this.color=color;
	}


	/**
	 * @param x the x to set
	 */
	public void setX(final int x){
		this.x = x;
	}


	/**
	 * @param y the y to set
	 */
	public void setY(final int y){
		this.y = y;
	}
}
