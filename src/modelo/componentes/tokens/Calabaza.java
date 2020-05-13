package modelo.componentes.tokens;

import modelo.componentes.Componente;
import modelo.componentes.tablero.Casilla;
import modelo.componentes.tablero.CasillaNull;
import modelo.partida.Partida;
import modelo.partida.assaults.NormalAssault;
import musicandfx.AudioPlayer;

public class Calabaza extends Componente implements Token
{
	Casilla casilla;
	Partida partida;
	
	public Calabaza(Casilla casilla, Partida partida)
	{
		super(SIDE, "./images/calabaza.jpeg");
		this.partida = partida;
		setCasilla(casilla);
	}

	@Override
	public Casilla getCasilla()
	{
		return casilla;
	}

	@Override
	public void setCasilla(Casilla casilla)
	{
		setX(casilla.getX());
		setY(casilla.getY());
		this.casilla = casilla;
	}

	@Override
	public void move() {}

	@Override
	public void atack() {}

	@Override
	public int die()
	{
		AudioPlayer audioPlayer = new AudioPlayer("./audio/smahedPumkin.wav");
		audioPlayer.play(0);
		setCasilla(new CasillaNull());
		partida.delToken(this);
		if (partida.getAssault() instanceof NormalAssault)
		{
			partida.setAssault(partida.getAggravatedAssault());			
		}
		partida.setScore(partida.getScore() -10);
		return -10;
	}

	@Override
	public void casted() {}

}
