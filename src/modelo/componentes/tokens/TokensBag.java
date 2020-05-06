package modelo.componentes.tokens;

import java.util.ArrayList;
import java.util.Random;

public class TokensBag
{
	ArrayList<Token> tokensBag;
	final ArrayList<Token> initialTokensBag;
	Random random;
	
	public TokensBag(ArrayList<Token> initialTokens)
	{
		initialTokensBag = initialTokens;
		tokensBag = new ArrayList<Token>(initialTokens);
		random = new Random();
		
	}
	
	public Token getToken() throws EmptyBagException
	{
		if (tokensBag.size() == 0)
			throw new EmptyBagException();
		
		int selection = random.nextInt(tokensBag.size());
		return tokensBag.get(selection);
	}
	
	public void refillBag()
	{
		tokensBag = initialTokensBag;
	}
	
	public boolean isEmpty()
	{
		return tokensBag.isEmpty();
	}
}
