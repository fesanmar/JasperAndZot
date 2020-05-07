package modelo.partida.assaults.patterns.aggravated;

import modelo.componentes.tablero.Casilla;
import modelo.componentes.tokens.Token;
import modelo.partida.Partida;
import modelo.partida.assaults.patterns.AssaultPattern;
import modelo.partida.assaults.patterns.WrongNumberOfTokensException;

public class AggravatedAssaultPatter1 implements AssaultPattern
{

	private Partida partida;
	
	public AggravatedAssaultPatter1(Partida partida)
	{
		this.partida = partida;
	}
	
	@Override
	public void placeTokens(Token... tokens) throws WrongNumberOfTokensException
	{
		// X
		//  X
		if (tokens.length != 2)
			throw new WrongNumberOfTokensException();
		Casilla casilla1;
		Casilla casilla2;
		try
		{
			casilla1 = partida.getTablero().getCasilla(0, partida.getAppearDice().getResult() - 1);
			casilla2 = partida.getTablero().getCasilla(1, partida.getAppearDice().getResult());			
		}
		catch (ArrayIndexOutOfBoundsException aiofe)
		{
			casilla1 = partida.getTablero().getCasilla(0, partida.getAppearDice().getResult() - 2);
			casilla2 = partida.getTablero().getCasilla(1, partida.getAppearDice().getResult() - 1);
		}
		tokens[0].setCasilla(casilla1);
		tokens[1].setCasilla(casilla2);
		partida.addToken(tokens[0]);
		partida.addToken(tokens[1]);
	}

}
