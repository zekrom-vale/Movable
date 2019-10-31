package movable;

@SuppressWarnings({"javadoc", "hiding"})
public class Action{
	public int ddx;
	public int ddy;
	public int t;


	public Action(final int ddx, final int ddy, final int t){
		this.ddx=ddx/62;
		this.ddy=ddy/62;
		this.t=t;
	}
}
