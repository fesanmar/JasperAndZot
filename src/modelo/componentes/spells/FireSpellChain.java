package modelo.componentes.spells;

import modelo.componentes.tablero.Casilla;
import modelo.componentes.tokens.Multiplicador;
import modelo.componentes.tokens.Token;
import modelo.partida.Partida;

public class FireSpellChain extends SpellChain
{

	public FireSpellChain(Partida partida)
	{
		super(partida);
	}

	@Override
	void updateScore()
	{
		// Comprueba cuáles de los tokens en la cadena no siguen en ella 
		// por haber sido seleccionados antes de que una bomba explotara su casilla
		int addScore = 0;
		int multipliers = 0;
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
					if (token instanceof Multiplicador) 
						multipliers++;
					addScore += token.die();
				}
			}
		}
		
		// Añade puntos extra
		int lengthChain = chainOfCasillas.size();
		if (lengthChain >= 5) addScore += 5;
		if (lengthChain >= 10) addScore += 10;
		if (multipliers > 0) addScore *= multipliers;
		partida.setScore(partida.getScore() + addScore);
		chainOfCasillas.clear();
	}

}
