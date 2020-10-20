package modelo.componentes.tokens;

import modelo.componentes.Componente;
import modelo.componentes.movements.Advance;
import modelo.componentes.movements.InmuneToFlowersAdvance;
import modelo.componentes.tablero.Casilla;
import modelo.partida.Partida;

public class ZombiArdiente extends Componente implements Token {

	private Partida partida;
	private Casilla casilla;
	private Advance advance;
	
	public ZombiArdiente(Partida partida)
	{
		super(SIDE, "zombiardiente.jpeg");
		this.partida = partida;
		advance = new InmuneToFlowersAdvance(this);
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

	public void atack() 
	{
		Casilla nextCasilla = getCasilla().getBottomCasilla();
		Casilla leftCasilla = getCasilla().getLeftCasilla();
		Casilla rightCasilla = getCasilla().getRightCasilla();
		Token token;
		if ((token = nextCasilla.getPumpkin()) != null)
		{
			token.die();
		}
		else if((token = rightCasilla.getPumpkin()) != null)
		{
			token.die();
		}
		else if((token = leftCasilla.getPumpkin()) != null)
		{
			token.die();
		}
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