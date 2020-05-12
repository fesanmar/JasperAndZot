package modelo.partida.steps;

import modelo.partida.Partida;
import musicandfx.AudioPlayer;

public class GameOverStep implements Step
{
	private Partida partida;

	public GameOverStep(Partida partida)
	{
		this.partida = partida;
	}

	@Override
	public void display()
	{
		this.partida.getAudioPlayer().stop();
		AudioPlayer audioPlayer = new AudioPlayer("./audio/game_over_bad_chest.wav");
		audioPlayer.play(0);
		this.partida.getTablero().setMessage("¡Has perdido!");
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
