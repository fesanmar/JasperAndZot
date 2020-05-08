package modelo.componentes.spells;

import modelo.componentes.tokens.Flores;
import modelo.componentes.tokens.Token;
import modelo.partida.Partida;

public class FireSpell extends Spell
{
	public FireSpell(Partida partida)
	{
		super(255, 910, "./images/fire.jpeg", partida);
	}

	@Override
	public void cast()
	{
		Token[] affectedTokens = getFirstAffectedTokens();
		for (Token token : affectedTokens)
		{
			if (token instanceof Flores)
			{
				spellChain.createChain(affectedTokens);
				spellChain.updateScore();
				break;
			}
		}
	}
}
