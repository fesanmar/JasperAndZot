package modelo.componentes.tablero;

import java.awt.Point;
import java.util.ArrayList;

import modelo.componentes.Componente;
import modelo.componentes.tokens.Token;
import modelo.partida.Partida;

public class Tablero extends Componente {

	private final static String PATH_TABLERO = "./images/tablero.jpg";
	public final static int ROWS = 11;
	public final static int COLUMNS = 6;
	private final static int FIRST_X = 61;
	private final static int FIRST_Y = 230;
	public static final int JASPER_ROW = 10;
	public static final int PUMPKIN_ROW = 9;
	
	private Casilla[][] casillas;
	
	private Partida partida;
	private String message;
	
	private ArrayList<Componente> volatileComponents;
	
	public Tablero()
	{
		super(0, 40, 485, 972, PATH_TABLERO);
		// El mensaje de inicio muestra que se inicie partida
		message = "Comineza una nueva partida";
		
		// Inicializamos las 66 casillas que tiene el tablero
		casillas = new CasillaReal[ROWS][COLUMNS];
		volatileComponents = new ArrayList<Componente>();
		
		for (int i = 0; i < ROWS; i++)
		{
			for (int j = 0; j < COLUMNS; j++)
			{
				casillas[i][j] = new CasillaReal(
						this,
						FIRST_X + j * CasillaReal.SIDE, 
						FIRST_Y + i * CasillaReal.SIDE,
						i, j);
			}
		}
	}
	
	public Casilla[][] getCasillas()
	{
		return casillas;
	}
	
	public Casilla[] getRow(int row)
	{
		Casilla[] rowCasillas = new Casilla[6];
		
		for (int i = 0; i < rowCasillas.length; i++)
		{
			rowCasillas[i] = casillas[row][i];
		}
		return rowCasillas;
	}
	
	public ArrayList<Componente> getComponentes()
	{
		ArrayList<Componente> componentes = 
				new ArrayList<Componente>(volatileComponents);
		for(Token token : partida.getTokens())
		{
			componentes.add((Componente) token);
		}
		componentes.add(partida.getManydice());
		componentes.add(partida.getAppearDice());
		
		return componentes;
	}

	public int getScore()
	{
		return partida.getScore();
	}
	
	public String getPlayerName()
	{
		return partida.getPlayer();
	}
	
	public Casilla getCasilla(int row, int column) throws ArrayIndexOutOfBoundsException
	{
		return casillas[row][column];
	}
	
	public Casilla getCasilla(Point punto)
	{
		Casilla casillaTemp = new CasillaNull();
		for (Casilla[] fila : casillas)
		{
			for (Casilla casilla : fila)
			{
				if (casilla.isMe(punto.x, punto.y))
					casillaTemp = casilla;
			}
		}
		return casillaTemp;
	}

	/**
	 * @return the partida
	 */
	public Partida getPartida()
	{
		return partida;
	}

	/**
	 * @param partida the partida to set
	 */
	public void setPartida(Partida partida)
	{
		this.partida = partida;
	}

	/**
	 * @return the message
	 */
	public String getMessage()
	{
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	public void addVolatileComponents(Componente component)
	{
		volatileComponents.add(component);
	}
	
	public void removeVolatileComponents(Componente component)
	{
		volatileComponents.remove(component);
	}
	
	public void clearVolatileComponents()
	{
		volatileComponents.clear();
	}

}