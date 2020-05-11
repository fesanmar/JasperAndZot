package modelo.componentes.movements;

import modelo.componentes.tablero.Casilla;
import modelo.componentes.tokens.Flores;
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
				Token[] nextCasillaTokens = nextCasilla.getTokens();
				for (Token tokenInNext : nextCasillaTokens)
				{
					if (tokenInNext instanceof Flores)
					{
						((Flores) tokenInNext).setWillBurn(true);
					}
				}
			}
		}
	}

}
