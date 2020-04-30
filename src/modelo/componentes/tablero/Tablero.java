package modelo.componentes.tablero;

import java.util.ArrayList;

import modelo.componentes.Componente;
import modelo.componentes.tokens.Token;

public class Tablero extends Componente {

	private final static String PATH_TABLERO = "./images/tablero.jpg";
	private final static int ROWS = 11;
	private final static int COLUMNS = 6;
	private final static int FIRST_X = 60;
	private final static int FIRST_Y = 230;
	private CasillaReal[][] casillas;
	private ArrayList<Token> tokens;
	
	public Tablero()
	{
		super(0, 40, 485, 972, PATH_TABLERO);
		
		// Inicializamos los tokens. Al inicio, el tablero empieza vacío
		tokens = new ArrayList<Token>();
		
		
		// Inicializamos las 66 casillas que tiene el tablero
		casillas = new CasillaReal[ROWS][COLUMNS];
		
		for (int i = 0; i < ROWS; i++)
		{
			for (int j = 0; j < COLUMNS; j++)
			{
				casillas[i][j] = new CasillaReal(
						FIRST_X + j * CasillaReal.SIDE, 
						FIRST_Y + i * CasillaReal.SIDE,
						i, j);
			}
		}
	}
	
	public void addToken(Token token)
	{
		tokens.add(token);
	}
	
	public Token getToken(Casilla casilla)
	{
		Token tempToken = null;
		for (Token token : tokens)
		{
			if (token.getCasilla() == casilla)
			{
				tempToken = token;
				break;
			}
		}
		return tempToken;
	}
	
	public CasillaReal getCasilla(int row, int column) throws ArrayIndexOutOfBoundsException
	{
		return casillas[row][column];
	}

}