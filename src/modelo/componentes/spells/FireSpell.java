package modelo.componentes.spells;

import java.util.ArrayList;

import modelo.componentes.tablero.Casilla;
import modelo.componentes.tablero.Tablero;
import modelo.componentes.tokens.Bomba;
import modelo.componentes.tokens.Flores;
import modelo.componentes.tokens.Token;
import modelo.partida.Partida;
import musicandfx.AudioPlayer;

public class FireSpell extends Spell
{
	
	public FireSpell(Partida partida)
	{
		super(255, 910, "fire.jpeg", partida);
		spellChain = new FireSpellChain(partida);
		
	}

	@Override
	public void cast()
	{
		AudioPlayer audioPlayer = new AudioPlayer("Fire.wav");
		audioPlayer.play(0);
		Token[] affectedTokens = getFirstAffectedTokens();
		for (Token token : affectedTokens)
		{
			if (token instanceof Bomba)
			{
				token.atack();
				break;
			}
			else if (token instanceof Flores)
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
					&& (token instanceof Flores || token instanceof Bomba))
			{
				casillasAffected.add(casilla);
			}
		}
		// Ordena las casillas de manera que la casilla con el token m�s 
		// cercano a Jasper quede en la posici�n 0
		casillasAffected.sort(
				(c1, c2) -> c2.getNumber() - c1.getNumber() 
				);
		if (casillasAffected.size() > 0)
			return casillasAffected.get(0).getTokens();
		else
			return new Token[0];
	}
}
