package modelo.componentes.tablero;

import modelo.componentes.Elemento;

public class CasillaReal extends Elemento implements Casilla {

	public static final int SIDE = 60;
	private int row;
	private int column;
	private int number;
	
	public CasillaReal(int x, int y, int row, int column)
	{
		super(x, y, SIDE);
		this.row = row;
		this.column = column;
		this.number = 5 * row + row + column;
	}

	public int getRow() 
	{
		return this.row;
	}

	public int getColumn() 
	{
		return this.column;
	}

	/**
	 * 
	 * @param row
	 */
	public void setRow(int row) 
	{
		this.row = row;
	}

	/**
	 * 
	 * @param column
	 */
	public void setColumn(int column) 
	{
		this.column = column;
	}

	public int getNumber() 
	{
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number)
	{
		this.number = number;
	}

}