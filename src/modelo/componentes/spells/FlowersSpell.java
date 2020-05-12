package modelo.componentes.spells;

import java.util.ArrayList;

import modelo.componentes.tablero.Casilla;
import modelo.componentes.tablero.Tablero;
import modelo.componentes.tokens.Bomba;
import modelo.componentes.tokens.Calabaza;
import modelo.componentes.tokens.Flores;
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
			if (token instanceof Bomba)
			{
				token.atack();
				break;
			}
			else if (token instanceof Zombi || token instanceof ZombiArdiente)
			{
				spellChain.createChain(affectedTokens);
				spellChain.updateScore();
				break;
			}
		}
		
	}

	@Override
	protected Token[] getFirstAffectedTokens()
	{
		int jasperColumn = partida.getJasper().getCasilla().getColumn();
		ArrayList<Casilla> casillasAffected = new ArrayList<Casilla>();
		
		for (Token token : partida.getTokens())
		{
			Casilla casilla = token.getCasilla();
			if (casilla.getColumn() == jasperColumn 
					&& casilla.getRow() >= Tablero.FENCE_ROW
					&& casilla.getRow() < Tablero.JASPER_ROW
					&& !(token instanceof Calabaza)
					&& !(token instanceof Flores))
			{
				casillasAffected.add(casilla);
			}
		}
		// Ordena las casillas de manera que la casilla con el token más 
		// cercano a Jasper quede en la posición 0
		casillasAffected.sort(
				(c1, c2) -> c2.getNumber() - c1.getNumber() 
				);
		if (casillasAffected.size() > 0)
			return casillasAffected.get(0).getTokens();
		else
			return new Token[0];
	}
}
