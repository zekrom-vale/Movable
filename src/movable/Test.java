package movable;

import java.awt.Color;

public class Test{
	public static void main(final String[] args){
		final Movable[] moveable=new Movable[10];
		moveable[0]=new Circle(10, 30, 100, 100, 60, Color.blue);
		moveable[1]=new Circle(1030, 330, 200, 210, 40, Color.red);
		moveable[2]=new Circle(423, 746, 50, 504, 200, Color.green);
	}
}
