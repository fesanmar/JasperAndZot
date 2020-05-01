package modelo.partida.steps;

import modelo.partida.*;

public class PrevStep implements Step {

	private Partida partida;
	
	public PrevStep(Partida partida)
	{
		this.partida = partida;
	}

	public void descend() {
		// TODO - implement PrevStep.descend
		throw new UnsupportedOperationException();
	}

	public void place() 
	{
		partida.setIndication("Elije una casilla para colocar a Zot");
	}

	public void moveAndShoot() {
		// TODO - implement PrevStep.moveAndShoot
		throw new UnsupportedOperationException();
	}

	public void Smash() {
		// TODO - implement PrevStep.Smash
		throw new UnsupportedOperationException();
	}

}