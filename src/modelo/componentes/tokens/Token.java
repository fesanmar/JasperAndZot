package modelo.componentes.tokens;

import java.awt.Image;

import modelo.componentes.tablero.Casilla;

public interface Token {
	
	int SIDE = 60;

	abstract Casilla getCasilla();
	
	abstract Image getImage();
	
	abstract int getX();
	
	abstract int getY();
	
	abstract int getWidth();
	
	abstract int getHeight();

	/**
	 * 
	 * @param casilla
	 */
	abstract void setCasilla(Casilla casilla);

	abstract void move();

	abstract void atack();

	abstract void die();

}