package modelo.componentes.spells;

import java.util.ArrayList;

import modelo.componentes.tablero.Casilla;
import modelo.componentes.tokens.Bomba;
import modelo.componentes.tokens.Token;
import modelo.partida.Partida;

public abstract class SpellChain
{
	protected Partida partida;
	protected ArrayList<Casilla> chainOfCasillas;
	
	public SpellChain(Partida partida)
	{
		this.partida = partida;
		chainOfCasillas = new ArrayList<Casilla>();
	}
	
	public void createChain(Token[] affectedTokens)
	{
		Casilla initialTokenCasilla = affectedTokens[0].getCasilla();
		chainOfCasillas.add(initialTokenCasilla);
		
		// Si la siguiente está ocupada y no es una bomba, llamamos a la función
		// de nuevo, pero con esta nueva casilla. Así en el resto de direcciones
		Casilla rightCasilla = initialTokenCasilla.getRightCasilla();
		if (isOcuppiedAndChainable(rightCasilla))
		{
			createChain(rightCasilla.getTokens());
		}
		Casilla upCasilla = initialTokenCasilla.getAboveCasilla();
		
		if (isOcuppiedAndChainable(upCasilla))
		{
			createChain(upCasilla.getTokens());
		}
		
		Casilla downCasilla = initialTokenCasilla.getBottomCasilla();
		
		if (isOcuppiedAndChainable(downCasilla))
		{
			createChain(downCasilla.getTokens());
		}
		
		Casilla leftCasilla = initialTokenCasilla.getLeftCasilla();
		
		if (isOcuppiedAndChainable(leftCasilla))
		{
			createChain(leftCasilla.getTokens());
		}
	}
	
	protected boolean isOcuppiedAndChainable(Casilla casilla)
	{
		Token[] tokensInCasilla = casilla.getTokens();
		
		// Se comprueba si la casilla está ya en la cadena
		
		for (Casilla casillaInChain : chainOfCasillas) 
		{
			if(casilla.equals(casillaInChain)) return false;
		}
		
		for (Token token : tokensInCasilla)
		{
			// Si es una bomba, explota y devuelve false, ya que ese camino
			// habrá quedado invalidado.
			if (token instanceof Bomba)
			{
				token.casted();
				return false;
			}
			else 
			{
				return true;
			}
		}
		return false;
	}

	abstract void updateScore();
	
}
