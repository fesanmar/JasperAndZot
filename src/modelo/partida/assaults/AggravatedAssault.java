package modelo.partida.assaults;

import modelo.componentes.Elemento;
import modelo.componentes.tokens.Token;
import modelo.partida.Partida;

public class AggravatedAssault extends Elemento implements Assault
{
	Partida partida;
	
	public AggravatedAssault(Partida partida)
	{
		super(222, 69, 229, 69);
		this.partida = partida;
	}

	@Override
	public void placeZombies(Token... tokens)
	{
		// TODO Auto-generated method stub

	}

}
