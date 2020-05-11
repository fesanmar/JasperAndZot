package modelo.componentes.movements;

import modelo.componentes.tablero.Casilla;
import modelo.componentes.tokens.Token;

public class NormalFirstMovement extends Movement
{

	public NormalFirstMovement(Token token)
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
		}
	}

}
