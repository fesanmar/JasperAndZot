package modelo.partida.assaults.patterns.aggravated;

import modelo.componentes.tablero.Casilla;
import modelo.componentes.tokens.Token;
import modelo.partida.Partida;
import modelo.partida.assaults.patterns.AssaultPattern;
import modelo.partida.assaults.patterns.WrongNumberOfTokensException;

public class AggravatedAssaultPatter5 implements AssaultPattern
{
	
	private Partida partida;
	
	public AggravatedAssaultPatter5(Partida partida)
	{
		this.partida = partida;
	}

	@Override
	public void placeTokens(Token... tokens) throws WrongNumberOfTokensException
	{
		// X_X
		// __X
		if (tokens.length != 3)
			throw new WrongNumberOfTokensException();
		Casilla casilla1;
		Casilla casilla2;
		Casilla casilla3;
		if (partida.getAppearDice().getResult() == 1)
		{
			casilla1 = partida.getTablero().getCasilla(0, partida.getAppearDice().getResult() - 1);
			casilla2 = partida.getTablero().getCasilla(0, partida.getAppearDice().getResult() + 1);
			casilla3 = partida.getTablero().getCasilla(1, partida.getAppearDice().getResult() + 1);
		}
		else if (partida.getAppearDice().getResult() == 6)
		{
			casilla1 = partida.getTablero().getCasilla(0, partida.getAppearDice().getResult() - 3);
			casilla2 = partida.getTablero().getCasilla(0, partida.getAppearDice().getResult() - 1);
			casilla3 = partida.getTablero().getCasilla(1, partida.getAppearDice().getResult() - 1);
		}
		else
		{
			casilla1 = partida.getTablero().getCasilla(0, partida.getAppearDice().getResult() - 2);
			casilla2 = partida.getTablero().getCasilla(0, partida.getAppearDice().getResult());
			casilla3 = partida.getTablero().getCasilla(1, partida.getAppearDice().getResult());
		}
		tokens[0].setCasilla(casilla1);
		tokens[1].setCasilla(casilla2);
		tokens[2].setCasilla(casilla3);
		partida.addToken(tokens[0]);
		partida.addToken(tokens[1]);
		partida.addToken(tokens[2]);
	}

}
