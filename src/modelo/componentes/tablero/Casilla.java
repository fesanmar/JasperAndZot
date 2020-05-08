package modelo.componentes.tablero;

import modelo.componentes.tokens.Token;

public interface Casilla {

	abstract int getRow();

	abstract int getColumn();

	abstract int getNumber();
	
	abstract int getX();
	
	abstract int getY();
	
	abstract int getWidth();
	
	abstract int getHeight();
	
	abstract boolean isActive();
	
	abstract void setActive(boolean active);
	
	abstract boolean hasToken();
	
	abstract boolean isMe(int x, int y);
	
	abstract Token[] getTokens();
	
	abstract void setRow(int row);
	
	abstract void setColumn(int column);
	
	abstract void setNumber(int number);
	
	abstract Casilla getRightCasilla();
	
	abstract Casilla getLeftCasilla();
	
	abstract Casilla getAboveCasilla();
	
	abstract Casilla getBottomCasilla();
	
	abstract void explote();
	

}