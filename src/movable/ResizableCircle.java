package movable;

import java.awt.Color;

@SuppressWarnings({"javadoc", "hiding"})
public class ResizableCircle extends Circle implements Resizable{
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
