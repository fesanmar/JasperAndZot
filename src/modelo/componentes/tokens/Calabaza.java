package modelo.componentes.tokens;

import modelo.componentes.Componente;
import modelo.componentes.tablero.Casilla;
import modelo.componentes.tablero.CasillaNull;
import modelo.partida.Partida;

public class Calabaza extends Componente implements Token
{
	Casilla casilla;
	Partida partida;
	
	public Calabaza(Casilla casilla, Partida partida)
	{
		super(SIDE, "./images/calabaza.jpeg");
		this.partida = partida;
		setCasilla(casilla);
	}

	@Override
	public Casilla getCasilla()
	{
		return casilla;
	}

	@Override
	public void setCasilla(Casilla casilla)
	{
		setX(casilla.getX());
		setY(casilla.getY());
		this.casilla = casilla;
	}

	@Override
	public void move() {}

	@Override
	public void atack() {}

	@Override
	public int die()
	{
		setCasilla(new CasillaNull());
		partida.delToken(this);
		partida.setAssault(partida.getAggravatedAssault());
		
		int numberOfPumkins = 0;
		for (Token token : partida.getTokens())
		{
			if (token instanceof Calabaza)
			{
				numberOfPumkins++;
			}
		}
		if (numberOfPumkins == 0)
		{
			partida.setScore(partida.getScore() - 10);
			partida.gameOver();
		}
		partida.setScore(partida.getScore() -10);
		return -10;
	}

	@Override
	public void casted() {}

}
