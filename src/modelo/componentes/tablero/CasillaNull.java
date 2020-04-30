package modelo.componentes.tablero;

public class CasillaNull implements Casilla {
	
	public CasillaNull() {}

	public int getRow() {
		return 0;
	}

	public int getColumn() {
		return 0;
	}

	public int getNumber() {
		return 0;
	}

	@Override
	public void setRow(int row) {}

	@Override
	public void setColumn(int column) {}

	@Override
	public void setNumber(int number) {}

	@Override
	public int getX()
	{
		return 0;
	}

	@Override
	public int getY()
	{
		return 0;
	}

	@Override
	public int getWidth()
	{
		return 0;
	}

	@Override
	public int getHeight()
	{
		return 0;
	}

}