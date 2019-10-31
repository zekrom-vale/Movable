package movable;

import java.awt.Graphics;

@SuppressWarnings("javadoc")
public interface Movable{
	void draw(Graphics g);

	void move();

	default Movable moveDown(final double t){
		this.moveDown(t, 1);
		return this;
	}

	Movable moveDown(double t, double factor);

	default Movable moveLeft(final double t){
		this.moveLeft(t, 1);
		return this;
	}

	Movable moveLeft(double t, double factor);

	default Movable moveRight(final double t){
		this.moveRight(t, 1);
		return this;
	}

	Movable moveRight(double t, double factor);

	default void moveUp(final double t){
		this.moveUp(t, 1);
	}

	Movable moveUp(double t, double factor);

	void next();

	default Movable sleep(final double t){
		this.moveUp(t, 0);
		return this;
	}
}
