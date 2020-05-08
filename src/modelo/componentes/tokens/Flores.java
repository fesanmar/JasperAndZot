package modelo.componentes.tokens;

import modelo.componentes.Componente;
import modelo.componentes.tablero.Casilla;
import modelo.partida.Partida;

public class Flores extends Componente implements Token {

	Casilla casilla;
	Partida partida;
	
	public Flores(Casilla casilla, Partida partida)
	{
		super(SIDE, "./images/flores.jpeg");
		setCasilla(casilla);
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
		// TODO - implement Flores.move
		throw new UnsupportedOperationException();
	}

	public void atack() {
		// TODO - implement Flores.atack
		throw new UnsupportedOperationException();
	}

	public void die() {
		// TODO - implement Flores.die
		throw new UnsupportedOperationException();
	}

	@Override
	public void casted()
	{
		// TODO Auto-generated method stub
		
	}

}