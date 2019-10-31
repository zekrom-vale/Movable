package movable;

@SuppressWarnings({"javadoc", "hiding"})
public class Action{
	public int ddx;
	public int ddy;


	public Action(final int ddx, final int ddy){
		this.ddx=ddx/62;
		this.ddy=ddy/62;
	}
}
