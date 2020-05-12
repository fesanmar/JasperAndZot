package modelo;


import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WiningMatch
{
	private int idWiningMatch;
	private int position;
	private Timestamp timeStamp;
	private String player;
	private int turns;
	private int score;
	
	public int getIdWiningMatch()
	{
		return idWiningMatch;
	}
	
	public void setIdWiningMatch(int idWiningMatch)
	{
		this.idWiningMatch = idWiningMatch;
	}
	
	/**
	 * @return the position
	 */
	public int getPosition()
	{
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(int position)
	{
		this.position = position;
	}

	public Timestamp getTimeStamp()
	{
		return timeStamp;
	}
	
	public String getDate()
	{
		LocalDate localDate = timeStamp.toLocalDateTime().toLocalDate();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY"); 
        return formatter.format(localDate);
		
	}
	
	public void setTimeStamp(Timestamp timeStamp)
	{
		this.timeStamp = timeStamp;
	}
	
	public String getPlayer()
	{
		return player;
	}
	
	public void setPlayer(String player)
	{
		this.player = player;
	}
	
	public int getTurns()
	{
		return turns;
	}
	
	public void setTurns(int turns)
	{
		this.turns = turns;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public void setScore(int score)
	{
		this.score = score;
	}
}
