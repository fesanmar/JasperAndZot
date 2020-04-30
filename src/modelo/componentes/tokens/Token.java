package modelo.componentes.tokens;

import modelo.componentes.tablero.Casilla;

public interface Token {

	abstract Casilla getCasilla();

	/**
	 * 
	 * @param casilla
	 */
	abstract void setCasilla(Casilla casilla);

	abstract void move();

	abstract void atack();

	abstract void die();

}