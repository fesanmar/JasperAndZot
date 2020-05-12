package modelo.componentes.tokens;

import java.util.ArrayList;
import java.util.Random;

import modelo.partida.Partida;

public class TokensBag
{
	ArrayList<Token> tokensBag;
	Random random;
	Partida partida;
	
	public TokensBag(ArrayList<Token> initialTokens, Partida partida)
	{
		this.partida = partida;
		tokensBag = new ArrayList<Token>(initialTokens);
		random = new Random();
		
	}
	
	public Token getToken()
	{
		int selection = random.nextInt(tokensBag.size());
		Token draweToken = tokensBag.get(selection);
		tokensBag.remove(draweToken);
		return draweToken;
	}
	
	public void refillBag()
	{
		tokensBag = partida.getDiscardPile();
		partida.emptyDiscardPile();
	}
	
	public boolean isEmpty()
	{
		return tokensBag.isEmpty();
	}
	
	public int tokensLeft()
	{
		return tokensBag.size();
	}
}
