package modelo.partida.assaults;

import modelo.componentes.Elemento;
import modelo.componentes.tokens.Token;

public class NormalAssault extends Elemento implements Assault
{
	public NormalAssault()
	{
		super(29, 68, 189, 73);
	}

	@Override
	public void placeZombies(Token... tokens)
	{
		// TODO Auto-generated method stub

	}

}
