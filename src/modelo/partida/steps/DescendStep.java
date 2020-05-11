package modelo.partida.steps;

import java.util.ArrayList;

import modelo.componentes.tablero.Tablero;
import modelo.componentes.tokens.Bomba;
import modelo.componentes.tokens.Flores;
import modelo.componentes.tokens.Multiplicador;
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
		partida.getTokens().sort(
				(t1, t2) -> t2.getCasilla().getNumber() - t1.getCasilla().getNumber() 
				);
		for (Token token : partida.getTokens())
		{
			token.move();
		}
		// Hacemos arder las flores afectadas por zombis de fuego
		ArrayList<Token> flowersToBurn = new ArrayList<Token>();
		for (Token token : partida.getTokens())
		{
			if (token instanceof Flores)
			{
				if (((Flores) token).willBurn())
				{
					flowersToBurn.add(token);
				}
			}
		}
		partida.getTokens().removeAll(flowersToBurn);
		// Explotan las bombas que quedan frente a calabazas o las que llegan a la 
		// barrera.  Y hace desparecer los x2 en la misma situación
		ArrayList<Token> tokensLeft =partida.getTokens(); 
		for (int i = 0; i < tokensLeft.size(); i++)
		{
			if (tokensLeft.get(i) instanceof Bomba)
			{
				if (tokensLeft.get(i).getCasilla().getBottomCasilla().hasPumpkin() 
						|| tokensLeft.get(i).getCasilla().getRow() == Tablero.PUMPKIN_ROW)
				{
					tokensLeft.get(i).atack();
				}
			}
			else if (tokensLeft.get(i) instanceof Multiplicador)
			{
				if (tokensLeft.get(i).getCasilla().getBottomCasilla().hasPumpkin() 
						|| tokensLeft.get(i).getCasilla().getRow() == Tablero.PUMPKIN_ROW)
				{
					tokensLeft.get(i).die();
				}
			}
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