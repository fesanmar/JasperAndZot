package modelo.partida.steps;

import modelo.partida.Partida;

public class VictorySpet implements Step
{
	private Partida partida;

	public VictorySpet(Partida partida)
	{
		this.partida = partida;
	}

	@Override
	public void display()
	{
		this.partida.getTablero().setMessage("¡Enhorabuena! ¡Has ganado!");
		this.partida.repaintMessageArea();
	}

	@Override
	public void descend() {}

	@Override
	public void place(int x, int y) {}

	@Override
	public void shoot() {}

	@Override
	public void smash() {}

	@Override
	public boolean isSelectable(int x, int y)
	{
		return false;
	}

	@Override
	public void stopThread() {}

}
