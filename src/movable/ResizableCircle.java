package movable;

import java.awt.Color;

/**
* Class ResizableCircle, extends Circle (implimenting Movable) and impliments Resizable
*/

@SuppressWarnings({"javadoc", "hiding"})
public class ResizableCircle extends Circle implements Resizable{
	//No need to impliment Movable as the subclass already does
	//Plus extending Circle already comes with the Movable imliminted methods so no need to define them here!
	public ResizableCircle(
		final int x, final int y, final double dx, final double dy,
		final int radius, final Color color
		){
		super(x, y, dx, dy, radius, color);
	}

	@Override
	public void resize(final double percent){
		this.radius=(int)(this.radius*percent/100);
	}

}
