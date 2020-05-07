package modelo.partida.assaults;

import modelo.partida.Partida;
import modelo.partida.assaults.patterns.AssaultPattern;

public class AggravatedAssault extends Assault
{
	
	public AggravatedAssault(Partida partida)
	{
		super(222, 69, 229, 69, partida);
	}

	@Override
	public int getNumberOfTokensToDraw()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AssaultPattern createAssaultPattern(Partida partida)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
