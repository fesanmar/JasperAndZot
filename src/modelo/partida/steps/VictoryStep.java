package modelo.partida.steps;

import modelo.partida.Partida;

public class VictoryStep implements Step
{
	private Partida partida;

	public VictoryStep(Partida partida)
	{
		this.partida = partida;
	}

	@Override
	public void display()
	{
		this.partida.getTablero().setMessage("¡Enhorabuena! ¡Has ganado!");
		this.partida.repaintMessageArea();
		partida.saveWinnerMatch();
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
