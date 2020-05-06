package modelo.partida.assaults;

import modelo.componentes.Elemento;
import modelo.componentes.tokens.Token;
import modelo.partida.Partida;
import modelo.partida.assaults.patterns.AssaultPattern;
import modelo.partida.assaults.patterns.WrongNumberOfTokensException;

public class AggravatedAssault extends Elemento implements Assault
{
	Partida partida;
	
	public AggravatedAssault(Partida partida)
	{
		super(222, 69, 229, 69);
		this.partida = partida;
	}

	@Override
	public void placeTokens(Token... tokens)
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

	@Override
	public int getNumberOfTokensToDraw()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AssaultPattern createAssaultPattern(Partida partida)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
