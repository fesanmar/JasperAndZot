package modelo.componentes.tokens;

import modelo.componentes.Componente;
import modelo.componentes.tablero.Casilla;

public class Jasper extends Componente implements Token 
{
	Casilla casilla;
	
	public Jasper(int x, int y)
	{
		super(x, y, SIDE, "./images/jasper.jpeg");
	}

	public Casilla getCasilla() 
	{
		return casilla;
	}

	/**
	 * 
	 * @param casilla
	 */
	public void setCasilla(Casilla casilla) 
	{
		this.casilla = casilla;
	}

	public void move() {
		// TODO - implement Jasper.move
		throw new UnsupportedOperationException();
	}

	public void atack() {
		// TODO - implement Jasper.atack
		throw new UnsupportedOperationException();
	}

	public void die() {
		// TODO - implement Jasper.die
		throw new UnsupportedOperationException();
	}

}