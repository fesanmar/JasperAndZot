package modelo.partida.assaults;

import modelo.partida.Partida;
import modelo.partida.assaults.patterns.AssaultPattern;
import modelo.partida.assaults.patterns.aggravated.AggravatedAssaultPatter1;
import modelo.partida.assaults.patterns.aggravated.AggravatedAssaultPatter2;
import modelo.partida.assaults.patterns.aggravated.AggravatedAssaultPatter3;
import modelo.partida.assaults.patterns.aggravated.AggravatedAssaultPatter4;
import modelo.partida.assaults.patterns.aggravated.AggravatedAssaultPatter5;
import modelo.partida.assaults.patterns.aggravated.AggravatedAssaultPatter6;

public class AggravatedAssault extends Assault
{
	
	public AggravatedAssault(Partida partida)
	{
		super(222, 68, 229, 73, partida);
	}

	@Override
	public int getNumberOfTokensToDraw()
	{
		int result = partida.getManydice().getResult();
		int many;
		
		switch(result) 
		{
		case 1:
		case 2:
		case 3:
			many = 2;
			break;
		default:
			many = 3;
			break;
		}
		return many;
	}

	@Override
	public AssaultPattern createAssaultPattern(Partida partida)
	{
		int result = partida.getManydice().getResult();
		switch(result) 
		{
		case 1:
			return new AggravatedAssaultPatter1(partida);
		case 2:
			return new AggravatedAssaultPatter2(partida);
		case 3:
			return new AggravatedAssaultPatter3(partida);
		case 4:
			return new AggravatedAssaultPatter4(partida);
		case 5:
			return new AggravatedAssaultPatter5(partida);
		case 6:
			return new AggravatedAssaultPatter6(partida);
		default:
			return null;
		}
	}
}
