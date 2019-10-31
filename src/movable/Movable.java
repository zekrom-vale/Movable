package movable;

import java.awt.Graphics;

@SuppressWarnings("javadoc")
public interface Movable{
	void draw(Graphics g);

	void move();

	default Movable moveDown(final int t){
		this.moveDown(t, 1);
		return this;
	}

	Movable moveDown(int t, double factor);

	default Movable moveLeft(final int t){
		this.moveLeft(t, 1);
		return this;
	}

	Movable moveLeft(int t, double factor);

	default Movable moveRight(final int t){
		this.moveRight(t, 1);
		return this;
	}

	Movable moveRight(int t, double factor);

	default void moveUp(final int t){
		this.moveUp(t, 1);
	}

	Movable moveUp(int t, double factor);

	void next();

	default Movable sleep(final int t){
		this.moveUp(t, 0);
		return this;
	}
}
