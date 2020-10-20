package modelo.componentes.tokens;

import modelo.componentes.Componente;
import modelo.componentes.movements.Advance;
import modelo.componentes.movements.NormalAdvance;
import modelo.componentes.tablero.Casilla;
import modelo.partida.Partida;
import musicandfx.AudioPlayer;

public class Bomba extends Componente implements Token {

	private Partida partida;
	private Casilla casilla;
	private Advance advance;

	public Bomba(Partida partida)
	{
		super(SIDE, "bomba.jpeg");
		this.partida = partida;
		advance = new NormalAdvance(this);
		
	}
	
	public Casilla getCasilla() 
	{
		return casilla;
	}

	public void setCasilla(Casilla casilla) 
	{
		setX(casilla.getX());
		setY(casilla.getY());
		this.casilla = casilla;
	}

	public void move() 
	{
		advance.walk();
	}

	public void atack() 
	{
		AudioPlayer audioPlayer = new AudioPlayer("bomb.wav");
		audioPlayer.play(0);
		// Explota su casilla con todos los tokens
		Casilla casilla = this.getCasilla();
		casilla.explote();
		
		Casilla rightCasilla = casilla.getRightCasilla();
		rightCasilla.explote();
				
		Casilla leftCasilla = casilla.getLeftCasilla();
		leftCasilla.explote();
		
		 Casilla upCasilla = casilla.getAboveCasilla();
		upCasilla.explote();
		
		Casilla downCasilla = casilla.getBottomCasilla();
		downCasilla.explote();
	}

	public int die() 
	{
		partida.discard(this);
		return 0;
	}
	@Override
	public void casted()
	{
		atack();
	}

}