package modelo.componentes.tokens;

import modelo.componentes.Componente;
import modelo.componentes.tablero.Casilla;
import modelo.partida.Partida;

public class Multiplicador extends Componente implements Token {

	private Partida partida;
	private Casilla casilla;

	public Multiplicador(Partida partida)
	{
		super(SIDE, "./images/pordos.jpeg");
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
		// TODO - implement Multiplicador.move
		throw new UnsupportedOperationException();
	}

	public void atack() {
		// TODO - implement Multiplicador.atack
		throw new UnsupportedOperationException();
	}

	public void die() 
	{
		partida.discard(this);
	}

}