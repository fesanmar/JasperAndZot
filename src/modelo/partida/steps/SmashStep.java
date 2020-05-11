package modelo.partida.steps;

import modelo.componentes.tokens.Token;
import modelo.partida.*;

public class SmashStep implements Step {

	private Partida partida;

	public SmashStep(Partida partida)
	{
		this.partida = partida;
	}
	
	public void descend() {}

	public void place(int x, int y) {}

	public void shoot() {}

	public void smash() 
	{
		for (Token token : partida.getTokens())
		{
			// Aquí se implementa el aplastamiento
		}
		
		partida.setStep(partida.getDescendStep());
		partida.nextTurn();
		partida.display();
	}

	@Override
	public void display()
	{
		
		partida.getTablero().setMessage("¡Cuidado con tus calabazas!");
		partida.repaintHome();
		smash();
	}

	@Override
	public boolean isSelectable(int x, int y)
	{
		return false;
	}

	@Override
	public void stopThread()
	{
		// TODO Auto-generated method stub
		
	}

}