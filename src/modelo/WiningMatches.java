package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class WiningMatches
{
	private ArrayList<WiningMatch> winingMatches;
	
	public WiningMatches()
	{
		winingMatches = new ArrayList<WiningMatch>();
	}
	
	public ArrayList<WiningMatch> getWiningMatches()
	{
		return winingMatches;
	}

	public void queryForWiningMatches()
	{
		winingMatches.clear();
		
		ResultSet rs = null;
		Statement statement = null;
		Conector conector = new Conector();
		Connection conn = conector.getConexion();
		String query = "SELECT * FROM matches " + 
				"ORDER BY score DESC, turns DESC LIMIT 10";
		int position = 1;
		
		try
		{
			statement = conn.createStatement();
			rs = statement.executeQuery(query);
			
			while (rs.next())
			{
				WiningMatch winingMatch = new WiningMatch();
				winingMatch.setIdWiningMatch(rs.getInt("idMatch"));
				winingMatch.setTimeStamp(rs.getTimestamp("gameDateTime"));
				winingMatch.setPlayer(rs.getString("player"));
				winingMatch.setTurns(rs.getInt("turns"));
				winingMatch.setScore(rs.getInt("score"));
				winingMatch.setPosition(position);
				
				winingMatches.add(winingMatch);
				position++;
			}
			rs.close();
			statement.close();
			conector.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
