package modelo.componentes.tokens;

import modelo.componentes.Componente;
import modelo.componentes.movements.Advance;
import modelo.componentes.movements.NormalAdvance;
import modelo.componentes.tablero.Casilla;
import modelo.partida.Partida;

public class Multiplicador extends Componente implements Token {

	private Partida partida;
	private Casilla casilla;
	Advance advance;

	public Multiplicador(Partida partida)
	{
		super(SIDE, "pordos.jpeg");
		this.partida = partida;
		advance = new NormalAdvance(this);
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

	public void move() 
	{
		advance.walk();
	}

	public void atack() {}

	public int die() 
	{
		partida.discard(this);
		return 1;
	}

	@Override
	public void casted()
	{
		partida.addToken(new Flores(this.getCasilla(), partida));
		partida.discard(this);
		
	}

}