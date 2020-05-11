package modelo.componentes.movements;

import modelo.componentes.tokens.Token;

public class NormalAdvance extends Advance
{

	public NormalAdvance(Token token)
	{
		super(token, new NormalFirstMovement(token), new NormalSecondMovement(token));
	}

}
