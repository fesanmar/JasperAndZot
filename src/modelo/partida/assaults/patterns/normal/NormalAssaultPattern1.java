package modelo.partida.assaults.patterns.normal;

import modelo.componentes.tablero.Casilla;
import modelo.componentes.tokens.Token;
import modelo.partida.Partida;
import modelo.partida.assaults.patterns.AssaultPattern;
import modelo.partida.assaults.patterns.WrongNumberOfTokensException;

public class NormalAssaultPattern1 implements AssaultPattern
{
	
	Partida partida;
	
	public NormalAssaultPattern1(Partida partida)
	{
		this.partida = partida;
	}

	@Override
	public void placeTokens(Token... tokens) throws WrongNumberOfTokensException
	{
		if (tokens.length != 1) 
			throw new WrongNumberOfTokensException();
		
		Casilla casilla = 
				partida.getTablero().getCasilla(0, partida.getAppearDice().getResult());
		tokens[0].setCasilla(casilla);
		partida.addToken(tokens[0]);
	}

}
