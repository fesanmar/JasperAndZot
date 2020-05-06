package modelo.partida.steps;

import modelo.partida.*;

public class PlaceStep implements Step, Runnable {

	private Partida partida;
	private Thread thread;
	private boolean dicesRolled = false;

	public PlaceStep(Partida partida)
	{
		this.partida = partida;
		thread = new Thread(this, "PlaceStep thread");
	}
	
	public void descend() 
	{
		partida.getManydice().roll();
		partida.getAppearDice().roll();
		dicesRolled = true;
		partida.repaintDiceArea();
	}

	public void place(int x, int y) {
		// TODO - implement PlaceStep.place
		throw new UnsupportedOperationException();
	}

	public void moveAndShoot() {
		// TODO - implement PlaceStep.moveAndShoot
		throw new UnsupportedOperationException();
	}

	public void Smash() {
		// TODO - implement PlaceStep.Smash
		throw new UnsupportedOperationException();
	}

	@Override
	public void display()
	{
		partida.getTablero().setMessage("Lanzando los dados");
		partida.repaintMessageArea();
		thread.start();
	}

	@Override
	public boolean isSelectable(int x, int y)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void run()
	{
		if (dicesRolled == false)
		{
			try
			{
				Thread.sleep(3000);
				partida.getTablero().setMessage("");
				partida.repaintMessageArea();
				descend();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

}