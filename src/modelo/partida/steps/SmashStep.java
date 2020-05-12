package modelo.partida.steps;

import java.util.ArrayList;

import modelo.componentes.tablero.Tablero;
import modelo.componentes.tokens.Token;
import modelo.partida.*;

public class SmashStep implements Step, Runnable {

	private Partida partida;
	private Thread thread;

	public SmashStep(Partida partida)
	{
		this.partida = partida;
	}
	
	public void descend() {}

	public void place(int x, int y) {}

	public void shoot() {}

	public void smash() 
	{
		// Primero atacan los tokens en la fila anterior a las calabazas
		ArrayList<Token> tokensInFrontOfPumkins =
				partida.getToken(Tablero.PUMPKIN_ROW - 1);
		for (Token token : tokensInFrontOfPumkins)
		{
			token.atack();
		}
		partida.repaintHome();
		
		partida.setStep(partida.getDescendStep());
		partida.nextTurn();
		partida.display();
	}

	@Override
	public void display()
	{
		
		partida.getTablero().setMessage("¡Cuidado con tus calabazas!");
		partida.repaintHome();
		thread = new Thread(this, "SmashStep" + partida.getTurn());
		thread.start();
		// smash();
	}

	@Override
	public boolean isSelectable(int x, int y)
	{
		return false;
	}

	@Override
	public void stopThread() {}

	@Override
	public void run()
	{
		try
		{
			Thread.sleep(3000);
			partida.getTablero().setMessage("");
			partida.repaintMessageArea();
			smash();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}		
	}

}