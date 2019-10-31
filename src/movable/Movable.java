package movable;

import java.awt.Graphics;

@SuppressWarnings("javadoc")
public interface Movable{
	void draw(Graphics g);

	void move();

	default Movable moveDown(){
		this.moveDown(1);
		return this;
	}

	Movable moveDown(double factor);

	default Movable moveLeft(){
		this.moveLeft(1);
		return this;
	}

	Movable moveLeft(double factor);

	default Movable moveRight(){
		this.moveRight(1);
		return this;
	}

	Movable moveRight(double factor);

	default void moveUp() {
		this.moveUp(1);
		return;
	}

	Movable moveUp(double factor);

	void next();
}
