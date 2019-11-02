package movable;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("javadoc")
public class Rectangle implements Movable{
	private final Point bottomRight;
	private final Point topLeft;
	public Rectangle(
		final int x1, final int y1, final int x2, final int y2, final double dx,
		final double dy, final Color color
		){
		this.bottomRight=new Point(x2, y2, dx, dy, color);
		this.topLeft=new Point(x1, y1, dx, dy, color);
	}

	@Override
	public void draw(final Graphics g){
		g.setColor(this.topLeft.getColor());
		g.fillRect(
			this.topLeft.getX(), this.topLeft.getY(),
			this.bottomRight.getX()-this.topLeft.getX(),
			this.bottomRight.getY()-this.topLeft.getY()
			);
	}

	@Override
	public void move(){
		this.bottomRight.move();
		this.topLeft.move();
	}

	@Override
	public Movable moveDown(final double t, final double factor){
		this.bottomRight.moveDown(t, factor);
		this.topLeft.moveDown(t, factor);
		return this;
	}

	@Override
	public Movable moveLeft(final double t, final double factor){
		this.bottomRight.moveLeft(t, factor);
		this.topLeft.moveLeft(t, factor);
		return this;
	}

	@Override
	public Movable moveRight(final double t, final double factor){
		this.bottomRight.moveRight(t, factor);
		this.topLeft.moveRight(t, factor);
		return this;
	}

	@Override
	public Movable moveUp(final double t, final double factor){
		this.bottomRight.moveUp(t, factor);
		this.topLeft.moveUp(t, factor);
		return this;
	}

	@Override
	public void next(){
		this.bottomRight.next();
		this.topLeft.next();

	}

	@Override
	public String toString(){
		return "Rectangle with points: ("+this.topLeft.getX()+", "+
			this.topLeft.getY()+") and ("+this.bottomRight.getX()+", "+
			this.bottomRight.getY()+")";
	}
}
