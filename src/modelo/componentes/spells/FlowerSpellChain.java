package modelo.componentes.spells;

import modelo.componentes.tablero.Casilla;
import modelo.componentes.tokens.Token;
import modelo.partida.Partida;

public class FlowerSpellChain extends SpellChain
{

	public FlowerSpellChain(Partida partida)
	{
		super(partida);
	}

	@Override
	public void updateScore() 
	{
		for (Casilla casilla : chainOfCasillas)
		{
			for (Token token : casilla.getTokens())
			{
				if(!partida.getTokens().contains(token))
				{
					chainOfCasillas.remove(casilla);
				}
				else
				{
					token.casted();
				}
			}
		}
	}
}
