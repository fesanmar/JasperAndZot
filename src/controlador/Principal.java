package controlador;
/** Juego Jasper and Zot en castellano para escritorio
 * @author Felipe Santa´Cruz
 * @author https://github.com/fesanmar/
 * @version 1.0
 * @since 1.0
*/
import java.util.TimeZone;

import modelo.componentes.tablero.Tablero;
import vista.Home;

public class Principal
{

	public static void main(String[] args)
	{
		// Fijo el TimeZone para que se comparezca con la conexión
		// a la base datos. De otra forma, hace los cast a un día menos.
		TimeZone timeZone = TimeZone.getTimeZone("Europe/Madrid");
		TimeZone.setDefault(timeZone);
		
		Tablero tablero = new Tablero();
		Home vistaHome = new Home(tablero);
		new ControladorHome(vistaHome);
	}

}
