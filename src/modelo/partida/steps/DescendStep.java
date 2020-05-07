package modelo.partida.steps;

import modelo.componentes.tablero.Casilla;
import modelo.partida.Partida;

public class DescendStep implements Step, Runnable {

	private Partida partida;
	private Thread thread;
	
	public DescendStep(Partida partida)
	{
		this.partida = partida;
		thread = new Thread(this, "Descend thread");
	}

	public void descend() 
	{
		partida.setStep(partida.getPlaceStep());
		partida.display();
	}

	public void shoot() {}

	public void Smash() {}

	@Override
	public void display()
	{
		if (partida.getTurn() > 1)
		{
			partida.getTablero().setMessage("Comineza el descenso");
			partida.repaintMessageArea();
			thread.start();			
		}
		else
		{
			partida.setStep(partida.getPlaceStep());
			partida.display();
		}
	}

	@Override
	public void place(int x, int y)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isSelectable(int x, int y)
	{
		Casilla[] firsRow = partida.getTablero().getRow(0);

		if (
				(firsRow[0].isMe(x, y) && !firsRow[0].hasToken())||
				(firsRow[1].isMe(x, y) && !firsRow[1].hasToken())||
				(firsRow[2].isMe(x, y) && !firsRow[2].hasToken())||
				(firsRow[3].isMe(x, y) && !firsRow[3].hasToken())||
				(firsRow[4].isMe(x, y) && !firsRow[4].hasToken())||
				(firsRow[5].isMe(x, y) && !firsRow[5].hasToken())
			)
		{
			return true;

		} else
		{
			return false;
		}
	}

	@Override
	public void run()
	{
		try
		{
			Thread.sleep(3000);
			partida.getTablero().setMessage("");
			partida.repaintMessageArea();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		descend();
	}

}