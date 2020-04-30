package modelo.componentes;

public class Elemento {

	private int x;
	private int y;
	private int height;
	private int width;
	
	public Elemento()
	{
		this(0, 0, 0, 0);
	}
	
	public Elemento(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	
	public Elemento(int x, int y, int side)
	{
		this(x, y, side, side);
	}

	public int getX() {
		return this.x;
	}

	/**
	 * 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	/**
	 * 
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	public int getHeight() {
		return this.height;
	}

	/**
	 * 
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return this.width;
	}

	/**
	 * 
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

}