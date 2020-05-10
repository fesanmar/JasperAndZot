package modelo.partida.steps;

import modelo.componentes.tokens.Token;
import modelo.partida.Partida;

public class DescendStep implements Step, Runnable {

	private Partida partida;
	private Thread thread;
	
	public DescendStep(Partida partida)
	{
		this.partida = partida;
	}

	public void descend() 
	{
		for (Token token : partida.getTokens())
		{
			token.move();
		}
		partida.repaintHome();
		partida.setStep(partida.getPlaceStep());
		partida.display();
	}

	public void shoot() {}

	public void smash() {}

	@Override
	public void display()
	{
		if (partida.getTurn() > 1)
		{
			partida.getTablero().setMessage("Comineza el descenso");
			partida.repaintMessageArea();
			thread = new Thread(this, "Descend thread" + partida.getTurn());
			thread.start();
			
		}
		else
		{
			partida.setStep(partida.getPlaceStep());
			partida.display();
		}
	}

	@Override
	public void place(int x, int y) {}

	@Override
	public boolean isSelectable(int x, int y)
	{
		return false;
	}

	@Override
	public void run()
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

	@Override
	public void stopThread()
	{
		// TODO Auto-generated method stub
		
	}

}