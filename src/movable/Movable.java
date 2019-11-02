package movable;

import java.awt.Graphics;

/**
* Interface Movable defines manditory methods for a class to impliment on how to move and draw it
*/
public interface Movable{
	/**
	* How to draw the object on the JPane
	* @param g The graphics to draw the object on
	*/
	void draw(Graphics g);
	
	/**
	* This method actualy moves the object in any direction rather than queueing the action up for later exicution
	*/
	void move();
	
	/**
	* Calls the method moveDown defined by the implimenting class
	* @param t how long to preform the action
	* @return this to allow chaining of methods
	*/
	default Movable moveDown(final double t){
		this.moveDown(t, 1);
		return this;
	}
	
	/**
	* Creates and stores an action to be preforemed latter, specificaly move down
	* @param t how long to preform the action
	* @param factor The factor of dy to move (2 is twice as fast, 1 is exactly the same speed, .5 is half, 0 is nothing)
	* @return this to allow chaining of methods
	*/
	Movable moveDown(double t, double factor);
	
	/**
	* Calls the method moveLeft defined by the implimenting class
	* @param t how long to preform the action
	* @return this to allow chaining of methods
	*/
	default Movable moveLeft(final double t){
		this.moveLeft(t, 1);
		return this;
	}
	
	/**
	* Creates and stores an action to be preforemed latter, specificaly move left
	* @param t how long to preform the action
	* @param factor The factor of dx to move (2 is twice as fast, 1 is exactly the same speed, .5 is half, 0 is nothing)
	* @return this to allow chaining of methods
	*/
	Movable moveLeft(double t, double factor);

	/**
	* Calls the method moveRight defined by the implimenting class
	* @param t how long to preform the action
	* @return this to allow chaining of methods
	*/
	default Movable moveRight(final double t){
		this.moveRight(t, 1);
		return this;
	}

	/**
	* Creates and stores an action to be preforemed latter, specificaly move right
	* @param t how long to preform the action
	* @param factor The factor of dx to move (2 is twice as fast, 1 is exactly the same speed, .5 is half, 0 is nothing)
	* @return this to allow chaining of methods
	*/
	Movable moveRight(double t, double factor);

	/**
	* Calls the method moveUp defined by the implimenting class
	* @param t how long to preform the action
	* @return this to allow chaining of methods
	*/
	default void moveUp(final double t){
		this.moveUp(t, 1);
	}

	/**
	* Creates and stores an action to be preforemed latter, specificaly move up
	* @param t how long to preform the action
	* @param factor The factor of dy to move (2 is twice as fast, 1 is exactly the same speed, .5 is half, 0 is nothing)
	* @return this to allow chaining of methods
	*/
	Movable moveUp(double t, double factor);

	/**
	* Manages switching actions and for how long they are preformed
	*/
	void next();

	/*
	* Makes the object to do nothing for the specifyed time
	* @param t how long to preform the action
	* @return this to allow chaining of methods
	*/
	default Movable sleep(final double t){
		this.moveUp(t, 0);
		return this;
	}
}
