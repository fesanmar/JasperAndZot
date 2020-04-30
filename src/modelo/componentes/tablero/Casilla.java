package modelo.componentes.tablero;

public interface Casilla {

	abstract int getRow();

	abstract int getColumn();

	abstract int getNumber();
	
	abstract void setRow(int row);
	
	abstract void setColumn(int column);
	
	abstract void setNumber(int number);
	
	abstract int getX();
	
	abstract int getY();
	
	abstract int getWidth();
	
	abstract int getHeight();

}