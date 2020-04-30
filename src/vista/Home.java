package vista;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import modelo.componentes.tablero.Casilla;
import modelo.componentes.tablero.Tablero;

public class Home extends Frame
{
	private static final long serialVersionUID = 1L;
	
	////////////////  Menú  /////////////////////
	MenuBar menuBar = new MenuBar();
	
	Menu mnArchivo = new Menu("Archivo");
	Menu mnPuntacion = new Menu("Puntuación"); 
	Menu mnAyuda = new Menu("Ayuda");
	// Archivo
	MenuItem miNuevoJuego = new MenuItem("Nuevo juego");
	MenuItem miSalir = new MenuItem("Salir");
	MenuItem miRanking10 = new MenuItem("Ranking");
	MenuItem miManual = new MenuItem("Manual");
	MenuItem miCreditos = new MenuItem("Créditos");
	
	/////////////  Imágenes  //////////////////
	Image imgIcono;
	
	////////////  Componenetes  //////////////
	Tablero tablero;
	
	
	public Home(Tablero tablero)
	{
		this.tablero = tablero;
		// Cargamos el icono
		File pathIcono = new File("./images/jasper.jpeg");
		try
		{
			imgIcono = ImageIO.read(pathIcono);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		// Seteos iniciales
		setTitle("Jasper and Zot");
		setSize(485, 1012);
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(imgIcono);
		setLayout(new FlowLayout());
		
		mnArchivo.add(miNuevoJuego);
		mnArchivo.add(miSalir);
		mnPuntacion.add(miRanking10);
		mnAyuda.add(miManual);
		mnAyuda.add(miCreditos);
		
		menuBar.add(mnArchivo);
		menuBar.add(mnPuntacion);
		menuBar.add(mnAyuda);
		
		setMenuBar(menuBar);
		
		setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		// Primero se pinta el tablero
		// Empieza en la x = 0, y = 40. Anchura = 485, altura = 972
		g.drawImage(
				tablero.getImage(), 
				tablero.getX(), tablero.getY(), 
				tablero.getWidth(), tablero.getHeight(), 
				null
				);
		
		// Sobre el tablero, se pintan los componenetes
		// Primera casilla: 
		// posición x: 60 y: 230 
		// Tamaño de la casilla: 60 x 60
		// g.drawRect(62, 230, 58, 58);
		// La de abajo es la casilla 2,3
		// g.drawRect(60 + 120, 230 + 60, 60, 60);
		// Prueba, suando para dibujar las casillas del tablero
		Casilla casilla = tablero.getCasilla(1, 5);
		g.drawRect(casilla.getX(), casilla.getY(), casilla.getWidth(), casilla.getHeight());
	}

}
