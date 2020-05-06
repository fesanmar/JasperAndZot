package modelo.partida.assaults.patterns;

import modelo.componentes.tokens.Token;

public interface AssaultPattern
{
	abstract void placeTokens(Token... tokens) throws WrongNumberOfTokensException;
}
