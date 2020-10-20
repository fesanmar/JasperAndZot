package modelo.partida.steps;

import modelo.componentes.tokens.Token;
import modelo.partida.Partida;
import modelo.partida.assaults.NormalAssault;
import musicandfx.AudioPlayer;

public class PlaceStep implements Step, Runnable
{

	private Partida partida;
	private Thread thread;
	private boolean isTheEnd;

	public PlaceStep(Partida partida)
	{
		this.partida = partida;
		this.isTheEnd = false;
	}

	public void descend()
	{
		partida.getManydice().roll();
		partida.getAppearDice().roll();
		partida.repaintDiceArea();

		Token[] drawedTokens = new Token[partida.getAssault().getNumberOfTokensToDraw()];
		for (int i = 0; i < drawedTokens.length; i++)
		{
			drawedTokens[i] = partida.getTokensBag().getToken();
			System.out.println("Quedan " + partida.getTokensBag().tokensLeft());
			if (partida.getTokensBag().isEmpty())
			{
				if (partida.getAssault() instanceof NormalAssault)
				{
					partida.getTokensBag().refillBag();
					partida.setAssault(partida.getAggravatedAssault());
				} else
				{
					isTheEnd = true;
				}
			}
		}
		if (isTheEnd)
		{
			partida.setStep(partida.getVictoryStep());
		}
		else
		{
			partida.getAssault().placeTokens(drawedTokens);
			partida.repaintHome();
			partida.setStep(partida.getMoveShootStep());			
		}

		partida.display();
	}

	public void place(int x, int y)
	{
	}

	public void shoot()
	{
		// TODO - implement PlaceStep.moveAndShoot
		throw new UnsupportedOperationException();
	}

	public void smash()
	{
		// TODO - implement PlaceStep.Smash
		throw new UnsupportedOperationException();
	}

	@Override
	public void display()
	{
		partida.getTablero().setMessage("Lanzando los dados");
		partida.repaintMessageArea();
		AudioPlayer audioPlayer = new AudioPlayer("dice-29.wav");
		audioPlayer.play(0);
		thread = new Thread(this, "PlaceStep thread" + partida.getTurn());
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