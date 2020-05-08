package vista;

import java.awt.BasicStroke;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
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

import modelo.componentes.Componente;
import modelo.componentes.Elemento;
import modelo.componentes.tablero.Casilla;
import modelo.componentes.tablero.Tablero;
import modelo.componentes.tokens.Jasper;
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
		paint(g);
	}
	
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setPaintMode();
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(3));
		
		// Primero se pinta el tablero
		// Empieza en la x = 0, y = 40. Anchura = 485, altura = 972
		g.drawImage(tablero.getImage(), tablero.getX(), tablero.getY(), tablero.getWidth(), tablero.getHeight(), null);
		// Color defaultColor = g.getColor();
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		
		try
		{
			// Dibujamos la puntuación
			int score = tablero.getScore();
			String scoreBox = String.format("Marcador: %,8d", score);
			// Marcador
			g.drawString(scoreBox, 300, 66);
			
			// Nombre del jugador
			g.drawString(tablero.getPlayerName(), 390, 1000);
			
			// Si ya hay un player, la partida está andando
			// y se pinta el texto de los dados
			g.drawString("Tokens:", 25, 66);
			g.drawString("Columna:", 125, 66);
			
			// Y se dibuja el asalto
			Elemento assault = (Elemento) tablero.getPartida().getAssault();
			g.setColor(Color.GREEN);
			g2d.drawRoundRect(
					assault.getX(), assault.getY(),
					assault.getWidth(), assault.getHeight(),
					10, 10
					);
			g.setColor(Color.WHITE);
		}
		catch (NullPointerException npe) {}
		
		// Dibujamos el mensaje del tablero
		g.setFont(new Font("TimesRoman", Font.BOLD, 30));
		drawMessage(tablero.getMessage(), g);
		
		// Dibujamos las casillas activas
		for (Casilla[] row : tablero.getCasillas())
		{
			for (Casilla casilla : row)
			{
				if (casilla.isActive())
				{
					g.setColor(Color.CYAN);
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
			for (Componente componente : tablero.getComponentes())
			{
				if (componente instanceof Token)
				{
					// Se dibuja el marco del Token
					g2d.setColor(Color.DARK_GRAY);
					g2d.drawRect(
							componente.getX(), 
							(componente instanceof Jasper) ? 
									(componente.getY() + 3) : componente.getY(), 
							componente.getWidth(), componente.getHeight());
				}
				// A Jasper se le dibuja 4 px más abajo que el resto, porque no cuadra
				// bien en su casilla
				g.drawImage(
						componente.getImage(), 
						componente.getX(), 
						(componente instanceof Jasper) ? 
								(componente.getY() + 4) : componente.getY(), 
						componente.getWidth(), componente.getHeight(), null);
			}			
		}
		catch(NullPointerException npe) {}
	}
	
	public void drawMessage(String message, Graphics g)
	{
		Dimension dim = this.getSize();
		int width = (int) (dim.getWidth() - 1);
		FontMetrics fm = g.getFontMetrics();
		int x = (width - fm.stringWidth(message)) / 2;
		g.drawString(message, x, 480);
		
	}

}
