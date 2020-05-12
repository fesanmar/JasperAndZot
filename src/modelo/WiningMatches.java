package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class WiningMatches
{
	ArrayList<WiningMatch> winingMatches;
	
	public WiningMatches()
	{
		winingMatches = new ArrayList<WiningMatch>();
	}
	
	public void queryForWiningMatches()
	{
		winingMatches.clear();
		
		ResultSet rs = null;
		Statement statement = null;
		Conector conector = new Conector();
		Connection conn = conector.getConexion();
		String query = "SELECT * FROM matches " + 
				"ORDER BY score, turns LIMIT 10";
		
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
				
				winingMatches.add(winingMatch);
			}
			rs.close();
			statement.close();
			conector.close();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (WiningMatch wm : winingMatches)
		{
			System.out.println(wm.getPlayer() + " " + wm.getTimeStamp());
		}
		
	}
}
