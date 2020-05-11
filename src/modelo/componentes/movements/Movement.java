package modelo.componentes.movements;

import modelo.componentes.tablero.Casilla;
import modelo.componentes.tablero.Tablero;
import modelo.componentes.tokens.Token;

public abstract class Movement
{
	protected Token token;
	
	public Movement(Token token)
	{
		this.token= token;
	}
	
	protected boolean allowedGoForward()
	{
		Casilla nextCasilla = token.getCasilla().getBottomCasilla();
		
		if (nextCasilla.getRow() == Tablero.JASPER_ROW)
			return false;
		if (nextCasilla.hasImpassableToken())
			return false;
		return true;
	}
	
	public abstract void go();
}
