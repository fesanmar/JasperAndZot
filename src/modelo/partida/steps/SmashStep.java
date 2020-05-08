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

	public void shoot() {
		// TODO - implement SmashStep.moveAndShoot
		throw new UnsupportedOperationException();
	}

	public void smash() 
	{
		// TODO: Aquí se implementa el aplasatado
		
		partida.setStep(partida.getDescendStep());
		partida.nextTurn();
		partida.getStep().display();
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