package modelo.componentes.tokens;

import modelo.componentes.Componente;
import modelo.componentes.tablero.Casilla;
import modelo.partida.Partida;

public class Flores extends Componente implements Token {

	Casilla casilla;
	Partida partida;
	private boolean willBurn;
	
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

	public void move() {}

	public void atack() {}

	public int die() 
	{
		partida.removeFromTheGame(this);
		return 1;
	}

	@Override
	public void casted() {}

	/**
	 * @return the willBurn
	 */
	public boolean willBurn()
	{
		return willBurn;
	}

	/**
	 * @param willBurn the willBurn to set
	 */
	public void setWillBurn(boolean willBurn)
	{
		this.willBurn = willBurn;
	}

}