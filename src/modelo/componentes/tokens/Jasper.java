package modelo.componentes.tokens;

import modelo.componentes.Componente;
import modelo.componentes.tablero.Casilla;
import modelo.partida.Partida;

public class Jasper extends Componente implements Token 
{
	Casilla casilla;
	Partida partida;
	
	public Jasper(Casilla casilla, Partida partida)
	{
		super(casilla.getX(), casilla.getY(), SIDE, "./images/jasper.jpeg");
		this.casilla = casilla;
		this.partida = partida;
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
		setX(casilla.getX());
		setY(casilla.getY());
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

	public int die() 
	{
		partida.gameOver();
		return 0;
	}

	@Override
	public void casted() {}

}