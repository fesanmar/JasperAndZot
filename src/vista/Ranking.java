package vista;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.WindowAdapter;

import listmulticolumn.Cell;
import listmulticolumn.DisplayTogether;
import listmulticolumn.ListBody;
import listmulticolumn.ListHead;
import listmulticolumn.Row;
import modelo.WiningMatch;
import modelo.WiningMatches;

public class Ranking extends Dialog
{

	private static final long serialVersionUID = 1L;
	public final String VISTA_CONSULTAR = "Consultar empleado";
	
	///////////////// ListMultiColumn  /////////////////////
	// Heads
	Cell[] headsCells = {
			new Cell(10, "Posición", "Posición"), 
			new Cell(10, "Nombre", "Nombre"),
			new Cell(13, "Fecha", "Fecha"),
			new Cell(10, "Nº turnos", "Nº turnos"),
			new Cell(12, "Puntuación", "Puntuación")
			};
	Row headRow = new Row(headsCells);
	ListHead listHead = new ListHead(headRow);
	
	// Body
	ListBody listBody = new ListBody(10);
	
	// Display together
	public DisplayTogether lmcEmpleados = new DisplayTogether(listHead, listBody);
	
	public WiningMatches winingMatches;

	public Ranking(Frame frame, WiningMatches winingMatches)
	{
		super(frame, "10 mejores puntuaciones");
		
		this.winingMatches = winingMatches;
		add(lmcEmpleados);
		setLocation(new Point(600, 100));
		setSize(500, 300);
		setVisible(true);
		addWindowListener(
				new WindowAdapter()
				{
					public void windowClosing(java.awt.event.WindowEvent e) {
						setVisible(false);
					};
				});
		for (WiningMatch wm : winingMatches.getWiningMatches())
		{
			Row tempRow = new Row();
			Cell cellPosition = new Cell(headsCells[0].getSize(), String.valueOf(wm.getPosition()), (headsCells[0].getColumnName()));
			Cell cellName = new Cell(headsCells[1].getSize(), wm.getPlayer(), (headsCells[1].getColumnName()));
			Cell cellDate = new Cell(headsCells[2].getSize(), wm.getDate(), (headsCells[2].getColumnName()));
			Cell cellTurn = new Cell(headsCells[3].getSize(), String.valueOf(wm.getTurns()), (headsCells[3].getColumnName()));
			Cell cellScore = new Cell(headsCells[4].getSize(), String.valueOf(wm.getScore()), (headsCells[4].getColumnName()));
			tempRow.add(cellPosition);
			tempRow.add(cellName);
			tempRow.add(cellDate);
			tempRow.add(cellTurn);
			tempRow.add(cellScore);
			listBody.add(tempRow);
			
		}
	}
}
