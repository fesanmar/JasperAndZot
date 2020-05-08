package modelo.componentes.spells;

import modelo.componentes.tokens.Token;
import modelo.componentes.tokens.Zombi;
import modelo.componentes.tokens.ZombiArdiente;
import modelo.partida.Partida;

public class FlowersSpell extends Spell
{
	
	public FlowersSpell(Partida partida)
	{
		super(185, 910, "./images/earth.jpeg", partida);
		spellChain = new FlowerSpellChain(partida);
		
	}
	
	@Override
	public void cast()
	{
		Token[] affectedTokens = getFirstAffectedTokens();
		for (Token token : affectedTokens)
		{
			if (token instanceof Zombi || token instanceof ZombiArdiente)
			{
				spellChain.createChain(affectedTokens);
				spellChain.updateScore();
				break;
			}
		}
		
	}
}
