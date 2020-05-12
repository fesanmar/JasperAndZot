package modelo;

import java.sql.Timestamp;

public class WiningMatch
{
	private int idWiningMatch;
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
	
	public Timestamp getTimeStamp()
	{
		return timeStamp;
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
