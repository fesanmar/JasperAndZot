package modelo.componentes.movements;

import modelo.componentes.tablero.Casilla;
import modelo.componentes.tokens.Flores;
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
			
			if (hasUnburnedFlowers(actualCasilla) ||
					hasUnburnedFlowers(nextCasilla) ||
					hasUnburnedFlowers(prevCasilla))
			{
				token.setCasilla(actualCasilla);
			}
			else
			{
				token.setCasilla(nextCasilla);
			}
		}
	}
	
	private boolean hasUnburnedFlowers(Casilla casilla)
	{
		// Devuelve false si alguno de los tokens que contiene
		// la casilla es una flor que va a arder.
		if (casilla.hasFlowers())
		{
			Token[] casillaTokens = casilla.getTokens();
			for (Token possibleFlower : casillaTokens)
			{
				if (possibleFlower instanceof Flores)
				{
					if (((Flores) possibleFlower).willBurn())
					{
						return false;
					}
				}
			}
			return true;
			
		}
		return false;
	}

}
