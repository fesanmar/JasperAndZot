package modelo.partida.assaults.patterns.normal;

import modelo.componentes.tablero.Casilla;
import modelo.componentes.tokens.Token;
import modelo.partida.Partida;
import modelo.partida.assaults.patterns.AssaultPattern;
import modelo.partida.assaults.patterns.WrongNumberOfTokensException;

public class NormalAssaultPattern2 implements AssaultPattern
{
	Partida partida;

	public NormalAssaultPattern2(Partida partida)
	{
		this.partida = partida;
	}

	@Override
	public void placeTokens(Token... tokens) throws WrongNumberOfTokensException
	{
		if (tokens.length != 2)
			throw new WrongNumberOfTokensException();

		Casilla casilla1 = partida.getTablero().getCasilla(0, partida.getAppearDice().getResult());
		Casilla casilla2 = partida.getTablero().getCasilla(0, partida.getAppearDice().getResult() + 1);
		tokens[0].setCasilla(casilla1);
		tokens[1].setCasilla(casilla2);
		partida.addToken(tokens[0]);
		partida.addToken(tokens[1]);
	}

}
