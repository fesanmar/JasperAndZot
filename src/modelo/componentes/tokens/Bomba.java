package modelo.componentes.tokens;

import modelo.componentes.Componente;
import modelo.componentes.tablero.Casilla;
import modelo.partida.Partida;

public class Bomba extends Componente implements Token {

	private Partida partida;
	private Casilla casilla;

	public Bomba(Partida partida)
	{
		super(SIDE, "./images/bomba.jpeg");
		this.partida = partida;
	}
	
	public Casilla getCasilla() 
	{
		return casilla;
	}

	public void setCasilla(Casilla casilla) 
	{
		setX(casilla.getX());
		setY(casilla.getY());
		this.casilla = casilla;
	}

	public void move() {
		// TODO - implement Bomba.move
		throw new UnsupportedOperationException();
	}

	public void atack() 
	{
		// Explota su casilla con todos los tokens
		Casilla casilla = this.getCasilla();
		casilla.explote();
		
		Casilla rightCasilla = casilla.getRightCasilla();
		rightCasilla.explote();
				
		Casilla leftCasilla = casilla.getLeftCasilla();
		leftCasilla.explote();
		
		 Casilla upCasilla = casilla.getAboveCasilla();
		upCasilla.explote();
		
		Casilla downCasilla = casilla.getBottomCasilla();
		downCasilla.explote();
	}

	public int die() 
	{
		partida.discard(this);
		return 0;
	}
	@Override
	public void casted()
	{
		atack();
	}

}