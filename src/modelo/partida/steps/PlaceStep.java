package modelo.partida.steps;

import modelo.componentes.tokens.EmptyBagException;
import modelo.componentes.tokens.Token;
import modelo.partida.Partida;
import modelo.partida.assaults.NormalAssault;

public class PlaceStep implements Step, Runnable
{

	private Partida partida;
	private Thread thread;

	public PlaceStep(Partida partida)
	{
		this.partida = partida;
		thread = new Thread(this, "PlaceStep thread");
	}

	public void descend()
	{
		partida.getManydice().roll();
		partida.getAppearDice().roll();
		partida.repaintDiceArea();

		Token[] drawedTokens = new Token[partida.getAssault().getNumberOfTokensToDraw()];
		for (int i = 0; i < drawedTokens.length; i++)
		{
			try
			{
				drawedTokens[i] = partida.getTokensBag().getToken();
			} catch (EmptyBagException ebe)
			{
				if (partida.getAssault() instanceof NormalAssault)
				{
					partida.getTokensBag().refillBag();
					partida.setAssault(partida.getAggravatedAssault());
				} else
				{
					partida.end();
				}
			}
		}

		partida.getAssault().placeTokens(drawedTokens);
		partida.repaintHome();
		partida.setStep(partida.getMoveShootStep());
		partida.getStep().display();
	}

	public void place(int x, int y)
	{
	}

	public void shoot()
	{
		// TODO - implement PlaceStep.moveAndShoot
		throw new UnsupportedOperationException();
	}

	public void Smash()
	{
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
	public void stopThread() {}

}