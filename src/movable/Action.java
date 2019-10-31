package movable;

/**
 * Defines movement actions
 *
 * @author Zekrom
 */
@SuppressWarnings({"javadoc", "hiding"})
public class Action{
	/**
	 * The horizontal (x) distance to move per tick
	 */
	public int ddx;
	/**
	 * The vertical (y) distance to move per tick
	 */
	public int ddy;
	/**
	 * The amount of ticks to run the operation for
	 */
	public int t;

	public Action(final int ddx, final int ddy, final double t){
		this.ddx=ddx/62;
		this.ddy=ddy/62;
		this.t=(int)(t*62);
	}
}
