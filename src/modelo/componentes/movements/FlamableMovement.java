package modelo.componentes.movements;

import modelo.componentes.tablero.Casilla;
import modelo.componentes.tokens.Token;

public class FlamableMovement extends Movement
{

	public FlamableMovement(Token token)
	{
		super(token);
	}

	@Override
	public void go()
	{
		if (allowedGoForward())
		{
			Casilla nextCasilla = token.getCasilla().getBottomCasilla();
			token.setCasilla(nextCasilla);
			if (nextCasilla.hasFlowers())
			{
				Casilla nextCasillaLeft = nextCasilla.getLeftCasilla();
				Casilla nextCasillaRight = nextCasilla.getRightCasilla();
				nextCasilla.burn();
				nextCasillaLeft.burn();
				nextCasillaRight.burn();
			}
		}
	}

}
