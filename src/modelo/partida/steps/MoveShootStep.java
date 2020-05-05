package modelo.partida.steps;

import modelo.partida.*;

public class MoveShootStep implements Step {

	private Partida partida;
	
	public MoveShootStep(Partida partida)
	{
		this.partida = partida;
	}
	public void descend() {
		// TODO - implement MoveShootStep.descend
		throw new UnsupportedOperationException();
	}

	public void place(int x, int y) {
		// TODO - implement MoveShootStep.place
		throw new UnsupportedOperationException();
	}

	public void moveAndShoot() {
		// TODO - implement MoveShootStep.moveAndShoot
		throw new UnsupportedOperationException();
	}

	public void Smash() {
		// TODO - implement MoveShootStep.Smash
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