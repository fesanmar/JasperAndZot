package modelo.componentes.movements;

import modelo.componentes.tokens.Token;

public class Advance
{
	Token token;
	Movement firstMovement;
	Movement secondMovement;

	public Advance(Token token, Movement firstMovement, Movement secondMovement)
	{
		this.token = token;
		this.firstMovement = firstMovement;
		this.secondMovement = secondMovement;
	}
	
	public void walk()
	{
		firstMovement.go();
		secondMovement.go();
	}

}
