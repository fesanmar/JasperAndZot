package modelo.partida.assaults;

import modelo.componentes.Elemento;
import modelo.componentes.tokens.Token;
import modelo.partida.Partida;
import modelo.partida.assaults.patterns.AssaultPattern;
import modelo.partida.assaults.patterns.WrongNumberOfTokensException;

public abstract class Assault extends Elemento
{
	Partida partida;
	
	public Assault(int x, int y, int width, int height, Partida partida)
	{
		super(x, y, width, height);
		this.partida = partida;
	}
	
	public void placeTokens(Token ... tokens)
	{
		AssaultPattern assaultPattern = createAssaultPattern(partida);
		try
		{
			assaultPattern.placeTokens(tokens);
		} catch (WrongNumberOfTokensException e)
		{
			e.printStackTrace();
		}
	}
	
	public abstract int getNumberOfTokensToDraw();
	
	public abstract AssaultPattern createAssaultPattern(Partida partida);
}
