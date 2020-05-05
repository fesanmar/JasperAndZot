package modelo.partida.steps;

import modelo.partida.*;

public class SmashStep implements Step {

	private Partida partida;

	public SmashStep(Partida partida)
	{
		this.partida = partida;
	}
	
	public void descend() {
		// TODO - implement SmashStep.descend
		throw new UnsupportedOperationException();
	}

	public void place(int x, int y) {
		// TODO - implement SmashStep.place
		throw new UnsupportedOperationException();
	}

	public void moveAndShoot() {
		// TODO - implement SmashStep.moveAndShoot
		throw new UnsupportedOperationException();
	}

	public void Smash() {
		// TODO - implement SmashStep.Smash
		throw new UnsupportedOperationException();
	}

	@Override
	public void display()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isSelectable(int x, int y)
	{
		// TODO Auto-generated method stub
		return false;
	}

}