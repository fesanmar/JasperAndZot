package modelo.componentes.movements;

import modelo.componentes.tokens.Token;

public class InmuneToFlowersAdvnce extends Advance
{

	public InmuneToFlowersAdvnce(Token token)
	{
		super(token, new NormalFirstMovement(token), new NormalFirstMovement(token));
	}

}
