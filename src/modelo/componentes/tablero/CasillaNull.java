package modelo.componentes.tablero;

import modelo.componentes.Elemento;

public class CasillaNull extends Elemento implements Casilla {

	private int row;
	private int column;
	
	public CasillaNull() {}

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}

	public int getNumber() {
		// TODO - implement CasillaNull.getNumber
		throw new UnsupportedOperationException();
	}

	@Override
	public void setRow(int row)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setColumn(int column)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNumber(int number)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getX()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWidth()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight()
	{
		// TODO Auto-generated method stub
		return 0;
	}

}