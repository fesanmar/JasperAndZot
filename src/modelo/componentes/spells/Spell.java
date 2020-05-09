package modelo.componentes.spells;

import modelo.componentes.Componente;
import modelo.componentes.tokens.Token;
import modelo.partida.Partida;

public abstract class Spell extends Componente
{
	protected Partida partida;
	protected SpellChain spellChain;
	
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
	protected abstract Token[] getFirstAffectedTokens();
	
	public abstract void cast();
}
