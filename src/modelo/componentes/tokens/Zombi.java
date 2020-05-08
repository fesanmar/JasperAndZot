package modelo.componentes.tokens;

import modelo.componentes.Componente;
import modelo.componentes.tablero.Casilla;
import modelo.partida.Partida;

public class Zombi extends Componente implements Token 
{
	private Partida partida;
	private Casilla casilla;

	public Zombi(Partida partida)
	{
		super(SIDE, "./images/zombi.jpeg");
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
		// TODO - implement Zombi.move
		throw new UnsupportedOperationException();
	}

	public void atack() {
		// TODO - implement Zombi.atack
		throw new UnsupportedOperationException();
	}

	public int die() 
	{
		partida.discard(this);
		return 2;
		
	}

	@Override
	public void casted()
	{
		partida.addToken(new Flores(this.getCasilla(), partida));
		partida.discard(this);
	}

}