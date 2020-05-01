package vista;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextField;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import modelo.componentes.tablero.Casilla;
import modelo.componentes.tablero.Tablero;
import modelo.partida.Partida;

public class Home extends Frame
{
	private static final long serialVersionUID = 1L;

	//////////////// Menú /////////////////////
	public MenuBar menuBar = new MenuBar();

	public Menu mnArchivo = new Menu("Archivo");
	public Menu mnPuntacion = new Menu("Puntuación");
	public Menu mnAyuda = new Menu("Ayuda");
	// Archivo
	public MenuItem miNuevoJuego = new MenuItem("Nuevo juego");
	public MenuItem miSalir = new MenuItem("Salir");
	public MenuItem miRanking10 = new MenuItem("Ranking");
	public MenuItem miManual = new MenuItem("Manual");
	public MenuItem miCreditos = new MenuItem("Créditos");

	///////////////////// Diálogos //////////////////////////

	// Diálogo SALIR
	public Dialog dlgSalir = new Dialog(this, "Salir");
	public Label lblSalir = new Label("¿Está seguro de que quiere salir?");
	public Button btnDlgSi = new Button("Sí");
	public Button btnDlgNo = new Button("No");

	// Dialog JUGADOR
	public Dialog dlgJugador = new Dialog(this, "¿Quién juega?");
	public Label lblDlgJugador = new Label("Introduce tu nombre.");
	public TextField txtDlgJugador = new TextField(20);
	public Button btnDlgJugador = new Button("Aceptar");

	///////////// Imágenes //////////////////
	Image imgIcono;

	//////////// Componenetes //////////////
	public Tablero tablero;
	
	/////////// Partida  //////////////////
	public Partida partida;

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

		////////////// Seteos iniciales ////////////////
		setTitle("Jasper and Zot");
		setSize(485, 1012);
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(imgIcono);
		setLayout(new FlowLayout());

		///////////// Menú ///////////////

		mnArchivo.add(miNuevoJuego);
		mnArchivo.add(miSalir);
		mnPuntacion.add(miRanking10);
		mnAyuda.add(miManual);
		mnAyuda.add(miCreditos);

		menuBar.add(mnArchivo);
		menuBar.add(mnPuntacion);
		menuBar.add(mnAyuda);

		setMenuBar(menuBar);

		//////////// Seteos ventanas de DIÁLOGO /////////////
		// SALIR
		dlgSalir.setIconImage(imgIcono);
		dlgSalir.setSize(220, 100);
		dlgSalir.setLocationRelativeTo(null);
		dlgSalir.setResizable(false);
		dlgSalir.setLayout(new FlowLayout());
		dlgSalir.add(lblSalir);
		dlgSalir.add(btnDlgSi);
		dlgSalir.add(btnDlgNo);

		// SALIR
		dlgJugador.setIconImage(imgIcono);
		dlgJugador.setSize(220, 120);
		dlgJugador.setLocationRelativeTo(null);
		dlgJugador.setResizable(false);
		dlgJugador.setLayout(new FlowLayout());
		dlgJugador.add(lblDlgJugador);
		dlgJugador.add(txtDlgJugador);
		dlgJugador.add(btnDlgJugador);
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		g.setPaintMode();

		// Primero se pinta el tablero
		// Empieza en la x = 0, y = 40. Anchura = 485, altura = 972
		g.drawImage(tablero.getImage(), tablero.getX(), tablero.getY(), tablero.getWidth(), tablero.getHeight(), null);
		Color defaultColor = g.getColor();
		
		// Dibujamos la puntuación
		try
		{
			String socre = String.valueOf(partida.getScore());
			g.setColor(Color.WHITE);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			g.drawString(partida.getPlayer() + ": "+ socre, 300, 65);
			g.setColor(defaultColor);			
		}
		catch (NullPointerException npe) {}

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
