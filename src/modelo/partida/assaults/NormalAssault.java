package modelo.partida.assaults;

import modelo.componentes.Elemento;
import modelo.componentes.tokens.Token;
import modelo.partida.Partida;
import modelo.partida.assaults.patterns.AssaultPattern;
import modelo.partida.assaults.patterns.WrongNumberOfTokensException;
import modelo.partida.assaults.patterns.normal.NormalAssaultPattern1;
import modelo.partida.assaults.patterns.normal.NormalAssaultPattern2;

public class NormalAssault extends Elemento implements Assault
{
	Partida partida;
	
	public NormalAssault(Partida partida)
	{
		super(29, 68, 189, 73);
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
		int result = partida.getManydice().getResult();
		int many;
		
		switch(result) 
		{
		case 1:
			many = 1;
			break;
		case 2:
		case 3:
			many = 2;
			break;
		default:
			many = 3;
			break;
		}
		return many;
	}
	
	public AssaultPattern createAssaultPattern(Partida partida)
	{
		int result = partida.getManydice().getResult();
		switch(result) 
		{
		case 1:
			return new NormalAssaultPattern1(partida);
		case 2:
			return new NormalAssaultPattern2(partida);
		case 3:
		case 4:
		case 5:
		case 6:
		default:
			return null;
		}
	}

}
