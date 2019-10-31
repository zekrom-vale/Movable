package movable;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings({"javadoc", "hiding"})
public class Point implements Movable{
	public Action action=new Action(0, 0, 0);
	protected Queue<Action> actions=new LinkedList<>();
	protected Color color;
	protected double dx;
	protected double dy;
	protected int x;
	protected int y;

	public Point(
		final int x, final int y, final double dx, final double dy,
		final Color color
		){
		this.x=x;
		this.y=y;
		this.dx=dx;
		this.dy=dy;
		this.color=color;
		this.actions.add(this.action);
	}

	@Override
	public void draw(final Graphics g){
		g.setColor(this.color);
		g.fillRect(this.x+3, this.y+3, 5, 5);
	}


	/**
	 * @return the x
	 */
	public int getX(){
		return this.x;
	}


	/**
	 * @return the y
	 */
	public int getY(){
		return this.y;
	}


	@Override
	public void move(){
		this.y+=this.action.ddy;
		this.x+=this.action.ddx;
	}


	@Override
	public Point moveDown(final double t, final double factor){
		this.actions.add(new Action(0, (int)(this.dy*factor), t));
		return this;

	}


	@Override
	public Point moveLeft(final double t, final double factor){
		this.actions.add(new Action(-(int)(this.dy*factor), 0, t));
		return this;

	}


	@Override
	public Point moveRight(final double t, final double factor){
		this.actions.add(new Action((int)(this.dy*factor), 0, t));
		return this;

	}

	@Override
	public Point moveUp(final double t, final double factor){
		this.actions.add(new Action(0, -(int)(this.dy*factor), t));
		return this;

	}


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
