package modelo.partida;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import modelo.Conector;
import modelo.componentes.spells.FireSpell;
import modelo.componentes.spells.FlowersSpell;
import modelo.componentes.tablero.Tablero;
import modelo.componentes.tokens.Bomba;
import modelo.componentes.tokens.Calabaza;
import modelo.componentes.tokens.Multiplicador;
import modelo.componentes.tokens.Token;
import modelo.componentes.tokens.TokensBag;
import modelo.componentes.tokens.Zombi;
import modelo.componentes.tokens.ZombiArdiente;
import modelo.partida.assaults.AggravatedAssault;
import modelo.partida.assaults.Assault;
import modelo.partida.assaults.NormalAssault;
import modelo.partida.steps.DescendStep;
import modelo.partida.steps.GameOverStep;
import modelo.partida.steps.MoveShootStep;
import modelo.partida.steps.PlaceStep;
import modelo.partida.steps.PrevStep;
import modelo.partida.steps.SmashStep;
import modelo.partida.steps.Step;
import modelo.partida.steps.VictorySpet;
import vista.Home;

public class Partida
{

	private String player;
	private int score;
	private int turn;
	private Tablero tablero;
	// Componentes
	private Token jasper;
	private TokensBag tokensBag;
	private Dice manyDice;
	private Dice appearDice;
	private ArrayList<Token> tokens;
	private ArrayList<Token> discardPile;

	// Spels
	private FireSpell fireSpell;
	private FlowersSpell flowersSpell;
	
	// Steps
	private Step step;
	private Step prevStep;
	private Step descendStep;
	private Step placeStep;
	private Step moveShootStep;
	private Step smashStep;
	private Step gameOverStep;
	private Step victoryStep;
	
	// Assaults
	private Assault assault;
	private Assault normalAssault;
	private Assault aggravatedAssault;
	private Home vistaHome;

	public Partida(String player, Tablero tablero, Home vistaHome)
	{
		this.player = player;
		this.setTablero(tablero);
		this.vistaHome = vistaHome;
		score = 0;
		setTurn(1);
		// Inicializamos los tokens. Al inicio, el tablero empieza vacío
		tokens = new ArrayList<Token>();
		discardPile = new ArrayList<Token>();
		manyDice = new Dice(90, 42);
		appearDice = new Dice(200, 42);
		// Steps
		prevStep = new PrevStep(this);
		descendStep = new DescendStep(this);
		placeStep = new PlaceStep(this);
		moveShootStep = new MoveShootStep(this);
		smashStep = new SmashStep(this);
		gameOverStep = new GameOverStep(this);
		victoryStep = new VictorySpet(this);

		// Borramos el mensaje de inicio del tablero
		tablero.setMessage("");
		// Seteamos el step como el previo
		step = prevStep;
		
		// Assaults
		normalAssault = new NormalAssault(this);
		aggravatedAssault = new AggravatedAssault(this);
		setAssault(normalAssault);
		
		// TokensBag:
		// zombies: 24
		// zombies ardientes: 8
		// bombas: 4
		// multiplicadores: 3
		ArrayList<Token> intialTokens = new ArrayList<Token>();
		for (int i = 0; i < 24; i++)
		{
			intialTokens.add(new Zombi(this));
			if (i < 8) intialTokens.add(new ZombiArdiente(this));
			if (i < 4) intialTokens.add(new Bomba(this));
			if (i < 3) intialTokens.add(new Multiplicador(this));
		}
		this.tokensBag = new TokensBag(intialTokens, this);
		
		// Spells
		fireSpell = new FireSpell(this);
		flowersSpell = new FlowersSpell(this);
	}
	
	public void repaintHome()
	{
		vistaHome.repaint();
	}
	
	public void repaintJasperArea()
	{
		vistaHome.repaint(50, 830, 485, 80);
	}
	
	public void repaintMessageArea()
	{
		vistaHome.repaint(30, 446, 415, 39);
	}
	
	public void repaintDiceArea()
	{
		vistaHome.repaint(25, 42, 235, 28);
	}
	
	public void display()
	{
		step.display();
	}
	
	public void descend()
	{
		step.descend();
	}

	public void place(int x, int y)
	{
		step.place(x, y);
	}
	
	public void addToken(Token token)
	{
		tokens.add(token);
	}
	
	public void delToken(Token token)
	{
		tokens.remove(token);
	}
	
	public void discard(Token token)
	{
		tokens.remove(token);
		discardPile.add(token);
	}
	
	public void removeFromTheGame(Token token)
	{
		tokens.remove(token);
	}

	public ArrayList<Token> getTokens()
	{
		return tokens;
	}
	
	public ArrayList<Token> getToken(int row)
	{
		ArrayList<Token> tokensInRow = new ArrayList<Token>();
		for (Token token : getTokens())
		{
			if (token.getCasilla().getRow() == row)
			{
				tokensInRow.add(token);
			}
		}
		return tokensInRow;
	}

	public void setTokens(ArrayList<Token> tokens)
	{
		this.tokens = tokens;
	}

	/**
	 * @return the tokensBag
	 */
	public TokensBag getTokensBag()
	{
		return tokensBag;
	}

	/**
	 * @return the discardPile
	 */
	public ArrayList<Token> getDiscardPile()
	{
		return discardPile;
	}
	
	public void emptyDiscardPile()
	{
		discardPile.removeAll(tokens);
	}

	public Dice getManydice()
	{
		return manyDice;
	}

	public Dice getAppearDice()
	{
		return appearDice;
	}

	public String getPlayer()
	{
		return this.player;
	}

	public FireSpell getFireSpell()
	{
		return fireSpell;
	}

	public FlowersSpell getFlowersSpell()
	{
		return flowersSpell;
	}

	/**
	 * 
	 * @param player
	 */
	public void setPlayer(String player)
	{
		this.player = player;
	}

	public int getScore()
	{
		return this.score;
	}
	

	/**
	 * 
	 * @param score
	 */
	public void setScore(int score)
	{
		this.score = score;
	}

	/**
	 * @return the turn
	 */
	public int getTurn()
	{
		return turn;
	}

	/**
	 * @param turn the turn to set
	 */
	public void setTurn(int turn)
	{
		this.turn = turn;
	}
	
	public void nextTurn()
	{
		setTurn(getTurn() + 1);
	}

	public Step getStep()
	{
		return this.step;
	}

	/**
	 * 
	 * @param step
	 */
	public void setStep(Step step)
	{
		this.step = step;
	}

	public Step getPrevStep()
	{
		return this.prevStep;
	}

	public Step getDescendStep()
	{
		return this.descendStep;
	}

	public Step getPlaceStep()
	{
		return this.placeStep;
	}

	public Step getMoveShootStep()
	{
		return this.moveShootStep;
	}

	public Step getSmashStep()
	{
		return this.smashStep;
	}

	/**
	 * @return the gameOverStep
	 */
	public Step getGameOverStep()
	{
		return gameOverStep;
	}

	/**
	 * @return the victoryStep
	 */
	public Step getVictoryStep()
	{
		return victoryStep;
	}

	public Assault getAssault()
	{
		return assault;
	}

	/**
	 * @param assault the assault to set
	 */
	public void setAssault(Assault assault)
	{
		this.assault = assault;
	}

	public Assault getNormalAssault()
	{
		return normalAssault;
	}

	/**
	 * @return the aggravatedAssault
	 */
	public Assault getAggravatedAssault()
	{
		return aggravatedAssault;
	}

	/**
	 * @return the tablero
	 */
	public Tablero getTablero()
	{
		return tablero;
	}

	/**
	 * @param tablero the tablero to set
	 */
	public void setTablero(Tablero tablero)
	{
		this.tablero = tablero;
	}

	/**
	 * @return the jasper
	 */
	public Token getJasper()
	{
		return jasper;
	}

	/**
	 * @param jasper the jasper to set
	 */
	public void setJasper(Token jasper)
	{
		if (this.jasper == null)
		{
			this.jasper = jasper;
			addToken(this.jasper);
		}
	}
	
	public void addSpellsToGame()
	{
		tablero.addVolatileComponents(fireSpell);
		tablero.addVolatileComponents(flowersSpell);
	}
	
	public void removeSpellsFromGame()
	{
		tablero.removeVolatileComponents(fireSpell);
		tablero.removeVolatileComponents(flowersSpell);
	}
	
	public int getPumpkinsLeft()
	{
		int numberOfPumkins = 0;
		for (Token tokenLeft : getTokens())
		{
			if (tokenLeft instanceof Calabaza)
			{
				numberOfPumkins++;
			}
		}
		return numberOfPumkins;
	}
	
	public void quitPartida()
	{
		prevStep.stopThread();
		descendStep.stopThread();
		placeStep.stopThread();
		moveShootStep.stopThread();
		smashStep.stopThread();
	}
	
	public void saveWinnerMatch()
	{
		Conector conector = new Conector();
		Connection conn = conector.getConexion();
		String sql = "INSERT INTO matches (player, gameDateTime, turns, score) "
				+ "VALUES (?,?,?,?)";
		try
		{
			PreparedStatement pStatement = conn.prepareStatement(sql);
			Calendar date = Calendar.getInstance();
			Timestamp timestamp = new Timestamp(date.getTimeInMillis());
			pStatement.setString(1, getPlayer());
			pStatement.setTimestamp(2, timestamp);
			pStatement.setInt(3, getTurn());
			pStatement.setInt(4, getScore());
			
			// String consulta = pStatement.toString();
			pStatement.executeUpdate();
			
			pStatement.close();
			conector.close();
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}