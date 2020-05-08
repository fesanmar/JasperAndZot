package modelo.componentes.tablero;

import java.util.ArrayList;

import modelo.componentes.Elemento;
import modelo.componentes.tokens.Token;

public class CasillaReal extends Elemento implements Casilla {

	public static final int SIDE = 60;
	private int row;
	private int column;
	private int number;
	private boolean active;
	private Tablero tablero;
	
	public CasillaReal(Tablero tablero, int x, int y, int row, int column)
	{
		super(x, y, SIDE);
		this.tablero = tablero;
		this.row = row;
		this.column = column;
		this.number = 5 * row + row + column;
		
		this.active = false;
	}

	@Override
	public boolean hasToken()
	{
		Token[] tokens = getTokens();
		if (tokens.length > 0) return true;
		else return false;
		
	}
	
	@Override
	public Token[] getTokens()
	{
		ArrayList<Token> tokens = tablero.getPartida().getTokens();
		ArrayList<Token> casillaTokens = new ArrayList<Token>();
		for (Token token : tokens)
		{
			if (token.getCasilla().equals(this))
			{
				casillaTokens.add(token);
			}
		}
		Token[] arrayTokens = new Token[casillaTokens.size()];
		for (int i = 0; i < arrayTokens.length; i++)
		{
			arrayTokens[i] = casillaTokens.get(i);
		}
		return arrayTokens;
	}
	
	public int getRow() 
	{
		return this.row;
	}

	public int getColumn() 
	{
		return this.column;
	}

	/**
	 * 
	 * @param row
	 */
	public void setRow(int row) 
	{
		this.row = row;
	}

	/**
	 * 
	 * @param column
	 */
	public void setColumn(int column) 
	{
		this.column = column;
	}

	public int getNumber() 
	{
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number)
	{
		this.number = number;
	}


	/**
	 * @return the tablero
	 */
	public Tablero getTablero()
	{
		return tablero;
	}

	@Override
	public boolean isActive()
	{
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active)
	{
		this.active = active;
	}

	@Override
	public boolean isMe(int x, int y)
	{
		if (isInMyColumn(x) && isInMyRow(y))
		{
			return true;
		}
		
		return false;
	}
	
	public boolean isInMyColumn(int x)
	{
		if ((x > getX()) && (x < (getX() + getWidth())))
		{
			return true;
		}
		
		return false;
	}
	
	public boolean isInMyRow(int y)
	{
		if ((y > getY()) && (y < (getY() + getHeight())))
		{
			return true;
		}
		
		return false;
	}

	@Override
	public Casilla getRightCasilla()
	{
		try
		{
			return tablero.getCasilla(this.getRow(), this.getColumn() + 1);
			
		}
		catch(ArrayIndexOutOfBoundsException aiobe)
		{
			return new CasillaNull();
		}
	}

	@Override
	public Casilla getLeftCasilla()
	{
		try
		{
			return tablero.getCasilla(this.getRow(), this.getColumn() - 1);
			
		}
		catch(ArrayIndexOutOfBoundsException aiobe)
		{
			return new CasillaNull();
		}
	}

	@Override
	public Casilla getAboveCasilla()
	{
		try
		{
			return tablero.getCasilla(this.getRow() - 1, this.getColumn());
			
		}
		catch(ArrayIndexOutOfBoundsException aiobe)
		{
			return new CasillaNull();
		}
	}

	@Override
	public Casilla getBottomCasilla()
	{
		try
		{
			if (this.getColumn() + 1 == Tablero.JASPER_ROW)
				throw new ArrayIndexOutOfBoundsException();
			
			return tablero.getCasilla(this.getRow() + 1, this.getColumn());
			
		}
		catch(ArrayIndexOutOfBoundsException aiobe)
		{
			return new CasillaNull();
		}
	}

	@Override
	public void explote()
	{
		Token[] tokens = this.getTokens();
		
		for (Token token : tokens)
		{
			// Se descarta, en vez de matarlo, para que no puntúe.
			tablero.getPartida().discard(token);
		}
	}
		
		

}