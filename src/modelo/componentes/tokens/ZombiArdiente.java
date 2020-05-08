package modelo.componentes.tokens;

import modelo.componentes.Componente;
import modelo.componentes.tablero.Casilla;
import modelo.partida.Partida;

public class ZombiArdiente extends Componente implements Token {

	private Partida partida;
	private Casilla casilla;
	
	public ZombiArdiente(Partida partida)
	{
		super(SIDE, "./images/zombiardiente.jpeg");
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
		// TODO - implement ZombiArdiente.move
		throw new UnsupportedOperationException();
	}

	public void atack() {
		// TODO - implement ZombiArdiente.atack
		throw new UnsupportedOperationException();
	}

	public void die() 
	{
		partida.discard(this);
	}

	@Override
	public void casted()
	{
		// TODO Auto-generated method stub
		
	}

}