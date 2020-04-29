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

public class Home extends Frame
{
	private static final long serialVersionUID = 1L;
	
	////////////////  Menú  /////////////////////
	MenuBar menuBar = new MenuBar();
	
	Menu mnArchivo = new Menu("Archivo");
	Menu mnPuntacion = new Menu("Puntuación"); 
	Menu mnAyuda = new Menu("Ayuda");
	
	MenuItem miNuevoJuego = new MenuItem("Nuevo juego");
	MenuItem miRanking10 = new MenuItem("Ranking");
	MenuItem miManual = new MenuItem("Manual");
	MenuItem miCreditos = new MenuItem("Créditos");
	
	/////////////  Imágenes  //////////////////
	Image imgIcono;
	Image imgTablero;
	
	////////////  Componenetes  //////////////
	
	
	public Home()
	{		
		// Imágenes
		File pathIcono = new File("./images/jasper.jpeg");
		try
		{
			imgIcono = ImageIO.read(pathIcono);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		File pathTablero = new File("./images/tablero.jpg");
		try
		{
			imgTablero = ImageIO.read(pathTablero);
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
		g.drawImage(imgTablero, 0, 40, 485, 972, null);
		
		// Sobre el tablero, se pintan los componenetes
		// Primera casilla: 
		// posición x: 60 y: 230 
		// Tamaño de la casilla: 60 x 60
		// g.drawRect(62, 230, 58, 58);
		g.drawRect(60, 230, 60, 60);
	}

}
