package vista;

import java.awt.BasicStroke;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
import modelo.componentes.tokens.Token;

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

		// JUGADOR
		btnDlgJugador.setEnabled(false);
		dlgJugador.setIconImage(imgIcono);
		dlgJugador.setSize(220, 120);
		dlgJugador.setLocationRelativeTo(null);
		dlgJugador.setResizable(false);
		dlgJugador.setLayout(new FlowLayout());
		dlgJugador.add(lblDlgJugador);
		dlgJugador.add(txtDlgJugador);
		dlgJugador.add(btnDlgJugador);
	}
	
	@Override
	public void update(Graphics g)
	{
		g.setPaintMode();

		// Primero se pinta el tablero
		// Empieza en la x = 0, y = 40. Anchura = 485, altura = 972
		g.drawImage(tablero.getImage(), tablero.getX(), tablero.getY(), tablero.getWidth(), tablero.getHeight(), null);
		// Color defaultColor = g.getColor();
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		
		// Dibujamos la puntuación y las indicaciones
		try
		{
			String score = String.valueOf(tablero.getScore());
			// Indicaciones
			g.drawString(tablero.getPartida().getIndication(), 30, 65);
			// Marcador
			g.drawString(score, 400, 65);
			// Nombre del jugador
			g.drawString(tablero.getPlayerName(), 390, 1000);
			
			// g.setColor(defaultColor);			
		}
		catch (NullPointerException npe) {}
		
		// Dibujamos el mensaje del tablero
		g.setFont(new Font("TimesRoman", Font.BOLD, 30));
		g.drawString(tablero.getMessage(), 70, 480);
		
		// Dibujamos las casillas activas
		for (Casilla[] row : tablero.getCasillas())
		{
			for (Casilla casilla : row)
			{
				if (casilla.isActive())
				{
					g.setColor(Color.CYAN);
					Graphics2D g2d = (Graphics2D) g;
					g2d.setStroke(new BasicStroke(3));
					g2d.drawRoundRect(
							casilla.getX(), casilla.getY(), 
							casilla.getWidth(), casilla.getHeight(),
							10, 10
							);
				}
			}
		}
		
		// Sobre el tablero, se pintan los componenetes
		// Primera casilla:
		// posición x: 60 y: 230
		// Tamaño de la casilla: 60 x 60
		try
		{
			for (Token token : tablero.getPartida().getTokens())
			{
				g.drawImage(token.getImage(), token.getX(), token.getY(), token.getWidth(), token.getHeight(), null);
			}			
		}
		catch(NullPointerException npe) {}
		paint(g);
	}
	
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setPaintMode();

		// Primero se pinta el tablero
		// Empieza en la x = 0, y = 40. Anchura = 485, altura = 972
		g.drawImage(tablero.getImage(), tablero.getX(), tablero.getY(), tablero.getWidth(), tablero.getHeight(), null);
		// Color defaultColor = g.getColor();
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		
		// Dibujamos la puntuación y las indicaciones
		try
		{
			String score = String.valueOf(tablero.getScore());
			// Indicaciones
			g.drawString(tablero.getPartida().getIndication(), 30, 65);
			// Marcador
			g.drawString(score, 400, 65);
			// Nombre del jugador
			g.drawString(tablero.getPlayerName(), 390, 1000);
			
			// g.setColor(defaultColor);			
		}
		catch (NullPointerException npe) {}
		
		// Dibujamos el mensaje del tablero
		g.setFont(new Font("TimesRoman", Font.BOLD, 30));
		g.drawString(tablero.getMessage(), 70, 480);
		
		// Dibujamos las casillas activas
		for (Casilla[] row : tablero.getCasillas())
		{
			for (Casilla casilla : row)
			{
				if (casilla.isActive())
				{
					g.setColor(Color.CYAN);
					Graphics2D g2d = (Graphics2D) g;
					g2d.setStroke(new BasicStroke(3));
					g2d.drawRoundRect(
							casilla.getX(), casilla.getY(), 
							casilla.getWidth(), casilla.getHeight(),
							10, 10
							);
				}
			}
		}
		
		// Sobre el tablero, se pintan los componenetes
		// Primera casilla:
		// posición x: 60 y: 230
		// Tamaño de la casilla: 60 x 60
		try
		{
			for (Token token : tablero.getPartida().getTokens())
			{
				g.drawImage(token.getImage(), token.getX(), token.getY(), token.getWidth(), token.getHeight(), null);
			}			
		}
		catch(NullPointerException npe) {}
	}

}
