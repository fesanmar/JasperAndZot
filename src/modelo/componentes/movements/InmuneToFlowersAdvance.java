package modelo.componentes.movements;

import modelo.componentes.tokens.Token;

public class InmuneToFlowersAdvance extends Advance
{

	public InmuneToFlowersAdvance(Token token)
	{
		super(token, new FlamableMovement(token), new FlamableMovement(token));
	}
}
