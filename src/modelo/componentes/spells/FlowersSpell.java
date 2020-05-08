package modelo.componentes.spells;

import modelo.componentes.tokens.Token;
import modelo.partida.Partida;

public class FlowersSpell extends Spell
{
	public FlowersSpell(Partida partida)
	{
		super(185, 910, "./images/earth.jpeg", partida);
	}
	
	@Override
	public void cast()
	{
		Token[] affectedTokens = getFirstAffectedTokens();
		System.out.println(affectedTokens);
		
	}
}
