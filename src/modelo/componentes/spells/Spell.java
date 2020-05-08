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
	
	/***
	 * Devuelve los tokens que hay sobre la primera casilla con
	 * tokens golpeados por el hechizo.
	 * @return array con los tokens afectados por el hechizo
	 */
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
		// Ordena las casillas de manera que la casilla con el token más 
		// cercano a Jasper quede en la posición 0
		casillasAffected.sort(
				(c1, c2) -> c2.getNumber() - c1.getNumber() 
				);
		
		return casillasAffected.get(0).getTokens();
		
	}
	
	public abstract void cast();
}
