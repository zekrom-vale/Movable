package movable;

import java.awt.Color;
/**
* Class Test, tests the Movable[] interface class
*/
public class Test{
	public static void main(final String[] args){
		//Create an interface type of Movable[]
		final Movable[] moveable=new Movable[10];
		//Fill with subtypes, can't create a Movable object
		moveable[0]=new Circle(10, 30, 100, 100, 60, Color.blue);
		moveable[1]=new Circle(1030, 330, 200, 210, 40, Color.red);
		moveable[2]=new Circle(423, 746, 50, 504, 200, Color.green);
		for(int i=0; i<moveable.length; i++){
			//Prevent null pointers
			if(moveable[i]==null)continue;
			//Call move methods, does not do anything in the console or screen here as it is not linked up to the Top Graphics class
			moveable[i].moveUp(1, 1).moveDown(2, .7).moveRight(2).sleep(5).moveLeft(3, 10);
		}
		
	}
}
