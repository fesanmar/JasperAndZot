package modelo.componentes.tokens;

import modelo.componentes.Componente;
import modelo.componentes.tablero.Casilla;

public class Calabaza extends Componente implements Token
{
	Casilla casilla;
	
	public Calabaza(int x, int y)
	{
		super(x, y, SIDE, "./images/calabaza.jpeg");
	}

	@Override
	public Casilla getCasilla()
	{
		return casilla;
	}

	@Override
	public void setCasilla(Casilla casilla)
	{
		this.casilla = casilla;
	}

	@Override
	public void move() {}

	@Override
	public void atack() {}

	@Override
	public void die()
	{
		
	}

}
