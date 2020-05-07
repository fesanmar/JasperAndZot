package modelo.partida.steps;

import java.awt.Point;

import com.mysql.cj.exceptions.WrongArgumentException;

import modelo.componentes.tablero.Casilla;
import modelo.componentes.tablero.CasillaNull;
import modelo.componentes.tablero.Tablero;
import modelo.componentes.tokens.Calabaza;
import modelo.componentes.tokens.Token;
import modelo.partida.*;

public class MoveShootStep implements Step, Runnable
{

	private Partida partida;
	private Thread thread;
	private boolean hasMoved;
	private boolean hasShooted;

	public MoveShootStep(Partida partida)
	{
		this.partida = partida;
		thread = new Thread(this, "MoveAndShot thread");
	}

	public void descend()
	{
	}

	public void place(int x, int y)
	{
		try
		{
			Casilla newCasillaForJasper = getCasillaIfValid(x, y);
			partida.getJasper().setCasilla(newCasillaForJasper);
			hasMoved = true;
			partida.getTablero().setMessage("¡Dispara!");
			partida.repaintMessageArea();
			partida.repaintJasperArea();
		}
		catch (WrongArgumentException wae) 
		{
			// Aquí va el código para disparar. Ya que, si la casilla no es válida
			// comprobamos si es un hechizo. En tal caso, llamamos a shoot.
		}
	}

	public void shoot()
	{
		// TODO - implement MoveShootStep.moveAndShoot
		throw new UnsupportedOperationException();
	}

	public void Smash()	{}

	@Override
	public void display()
	{
		hasMoved = false;
		hasShooted = false;
		
		partida.getTablero().setMessage("Mueve a Jasper y/o dispara");
		partida.repaintHome();
		thread.start();
	}

	@Override
	public boolean isSelectable(int x, int y)
	{
		Point point = new Point(x, y);
		Casilla casilla = partida.getTablero().getCasilla(point);
		if (!(casilla instanceof CasillaNull) && isAValidMovement(casilla.getRow(), casilla.getColumn()))
		{
			return true;
		}
		return false;
	}
	
	public Casilla getCasillaIfValid(int x, int y) throws WrongArgumentException
	{
		Point point = new Point(x, y);
		Casilla casilla = partida.getTablero().getCasilla(point);
		if (!(casilla instanceof CasillaNull) && isAValidMovement(casilla.getRow(), casilla.getColumn()))
		{
			return casilla;
		}
		else
		{
			throw new WrongArgumentException(
					"x: " + x + " e y: " + y 
					+ " no corresponden a ninguna casilla váida");
		}
	}
	
	private boolean isAValidMovement(int row, int column)
	{
		int jasperActualColumn = partida.getJasper().getCasilla().getColumn();
		if(row != Tablero.JASPER_ROW) return false;
		if (column == jasperActualColumn) return false;
		
		if (jasperActualColumn > column)
		{
			if (column >= jasperActualColumn - 3)
				return true;
			else
				return false;
		}
		else if (jasperActualColumn < column)
		{
			if (column <= jasperActualColumn + 3)
				return true;
			else
				return false;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void run()
	{
		while (hasMoved == false)
		{
			// Activa las casillas de la fila de Zot
			for (int i = 0; i < Tablero.COLUMNS; i++)
			{
				Casilla casilla = partida.getTablero().getCasilla(Tablero.JASPER_ROW, i);
				int row = partida.getTablero().getCasilla(Tablero.JASPER_ROW, i).getRow();
				int column = partida.getTablero().getCasilla(Tablero.JASPER_ROW, i).getColumn();
				if(isAValidMovement(row, column))
				{
					casilla.setActive(true);					
				}
				partida.repaintJasperArea();
			}
			try
			{
				Thread.sleep(200);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			for (int i = 0; i < Tablero.COLUMNS; i++)
			{
				Casilla casilla = partida.getTablero().getCasilla(Tablero.JASPER_ROW, i);
				casilla.setActive(false);
				partida.repaintJasperArea();
			}
			try
			{
				Thread.sleep(200);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

}