package modelo.partida.assaults;

import modelo.componentes.tokens.Token;
import modelo.partida.Partida;
import modelo.partida.assaults.patterns.AssaultPattern;

public interface Assault
{
	abstract void placeTokens(Token ... tokens);
	
	abstract int getNumberOfTokensToDraw();
	
	abstract AssaultPattern createAssaultPattern(Partida partida);
}
