package modelo.componentes.tokens;

import modelo.componentes.Componente;
import modelo.componentes.tablero.Casilla;
import modelo.componentes.tablero.CasillaNull;
import modelo.partida.Partida;

public class Calabaza extends Componente implements Token
{
	Casilla casilla;
	Partida partida;
	
	public Calabaza(int x, int y, Partida partida)
	{
		super(x, y, SIDE, "./images/calabaza.jpeg");
		this.partida = partida;
	}

	@Override
	public Casilla getCasilla()
	{
		return casilla;
	}

	@Override
	public void setCasilla(Casilla casilla)
	{
		this.casilla = casilla;
	}

	@Override
	public void move() {}

	@Override
	public void atack() {}

	@Override
	public void die()
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
		if (numberOfPumkins == 0) partida.gameOver();;
	}

}
