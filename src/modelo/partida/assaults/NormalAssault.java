package modelo.partida.assaults;

import modelo.componentes.Elemento;
import modelo.componentes.tokens.Token;
import modelo.partida.Partida;

public class NormalAssault extends Elemento implements Assault
{
	Partida partida;
	
	public NormalAssault(Partida partida)
	{
		super(29, 68, 189, 73);
		this.partida = partida;
	}

	@Override
	public void placeZombies(Token... tokens)
	{
		// TODO Auto-generated method stub

	}

}
