package modelo.componentes.spells;

import java.util.ArrayList;

import modelo.componentes.Componente;
import modelo.componentes.tablero.Casilla;
import modelo.componentes.tablero.Tablero;
import modelo.componentes.tokens.Token;
import modelo.partida.Partida;

public abstract class Spell extends Componente
{
	Partida partida;
	
	public Spell(int x, int y, String file, Partida partida)
	{
		super(x, y, Token.SIDE, file);
		this.partida = partida;
	}
	
	protected Token[] getFirstAffectedTokens()
	{
		int jasperColumn = partida.getJasper().getCasilla().getColumn();
		ArrayList<Casilla> casillasAffected = new ArrayList<Casilla>();
		
		for (Token token : partida.getTokens())
		{
			Casilla casilla = token.getCasilla();
			if (casilla.getColumn() == jasperColumn 
					&& casilla.getRow() >= Tablero.FENCE_ROW)
			{
				casillasAffected.add(casilla);
			}
		}
		casillasAffected.sort(
				(c1, c2) -> c2.getNumber() - c1.getNumber() 
				);
		
		return casillasAffected.get(0).getTokens();
		
	}
	
	public abstract void cast();
}
