package modelo.componentes.movements;

import modelo.componentes.tablero.Casilla;
import modelo.componentes.tokens.Token;

public class NormalSecondMovement extends Movement
{

	public NormalSecondMovement(Token token)
	{
		super(token);
	}

	@Override
	public void go()
	{
		if (allowedGoForward())
		{
			Casilla actualCasilla = token.getCasilla();
			Casilla prevCasilla = actualCasilla.getAboveCasilla();
			Casilla nextCasilla = actualCasilla.getBottomCasilla();
			
			if (actualCasilla.hasFlowers() ||
					nextCasilla.hasFlowers() ||
					prevCasilla.hasFlowers())
			{
				token.setCasilla(actualCasilla);
			}
			else
			{
				token.setCasilla(nextCasilla);
			}
		}
	}

}
