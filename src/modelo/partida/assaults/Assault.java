package modelo.partida.assaults;

import modelo.componentes.tokens.Token;

public interface Assault
{
	abstract void placeZombies(Token ... tokens);
}
