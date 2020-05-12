package controlador;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import modelo.partida.Partida;
import vista.Home;
import modelo.WiningMatches;
import modelo.componentes.tablero.Casilla;
import modelo.componentes.tokens.Token;;

public class ControladorHome
{
	Home vistaHome;
	ControladorVentana controladorVentana;
	volatile Partida partida;

	public ControladorHome(Home vistaHome)
	{
		this.vistaHome = vistaHome;
		controladorVentana = new ControladorVentana();

		//////////// Eventos de ventana ///////////////
		this.vistaHome.addWindowListener(controladorVentana);
		this.vistaHome.dlgJugador.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				vistaHome.dlgJugador.setVisible(false);
			}
		});
		this.vistaHome.dlgSalir.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				vistaHome.dlgSalir.setVisible(false);
			}
		});

		/////////// Eventos del menú ///////////////
		this.vistaHome.miNuevoJuego.addActionListener(ale -> this.vistaHome.dlgJugador.setVisible(true));
		this.vistaHome.miSalir.addActionListener(ae -> this.vistaHome.dlgSalir.setVisible(true));

		/////////// Eventos de botones //////////////
		// Botones Dialog SALIR
		this.vistaHome.btnDlgSi.addActionListener(ale -> System.exit(0));
		this.vistaHome.btnDlgNo.addActionListener(ale -> this.vistaHome.dlgSalir.setVisible(false));
		this.vistaHome.btnDlgJugador.addActionListener(ale ->
		{
			startGame();
		});
		this.vistaHome.miRanking10.addActionListener(
				ale -> {
					WiningMatches wm = new WiningMatches();
					wm.queryForWiningMatches();
				});

		//////////// Eventos de TextFields ///////////
		this.vistaHome.txtDlgJugador.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyReleased(KeyEvent arg0)
			{
				String name = vistaHome.txtDlgJugador.getText();
				if (name.trim().length() > 0 && name.length() <= 8)
				{
					vistaHome.btnDlgJugador.setEnabled(true);
				} else
				{
					vistaHome.btnDlgJugador.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e)
			{
				if (vistaHome.btnDlgJugador.isEnabled())
				{
					if (e.getKeyCode() == 10)
					{
						startGame();
					}

				}
			}
		});

		////////// Eventos de ratón ///////////////
		this.vistaHome.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				System.out.println("x: " + e.getX());
				System.out.println("y: " + e.getY());
				try
				{
					vistaHome.tablero.getPartida().place(e.getX(), e.getY());
					Point point = new Point(e.getX(), e.getY());
					Casilla casillaOver = vistaHome.tablero.getCasilla(point);
					Token[] tokensCasillaOver = casillaOver.getTokens();
					for (Token token : tokensCasillaOver)
					{
						System.out.println(token);
					}
				} catch (NullPointerException npe)
				{
				}
			}
		});
		this.vistaHome.addMouseMotionListener(new MouseAdapter()
		{
			public void mouseMoved(MouseEvent e)
			{
				try
				{
					if (vistaHome.tablero.getPartida().getStep().isSelectable(e.getX(), e.getY()))
					{
						Cursor cursorDedo = new Cursor(Cursor.HAND_CURSOR);
						vistaHome.setCursor(cursorDedo);
						
					} else
					{
						Cursor cursorDefaul = new Cursor(Cursor.DEFAULT_CURSOR);
						vistaHome.setCursor(cursorDefaul);
					}					
				}
				catch (NullPointerException npe) {}
			}
		});

		this.vistaHome.setVisible(true);
	}

	private void startGame()
	{
		if(vistaHome.tablero.getPartida() != null)
		{
			vistaHome.tablero.getPartida().quitPartida();
						
		}
		String player = this.vistaHome.txtDlgJugador.getText();
		if (!player.trim().isEmpty())
		{
			partida = new Partida(player, this.vistaHome.tablero, this.vistaHome);
			this.vistaHome.tablero.setPartida(partida);
			this.vistaHome.dlgJugador.setVisible(false);
			this.vistaHome.txtDlgJugador.setText("");
			this.vistaHome.tablero.getPartida().display();

		}
	}

	class ControladorVentana extends WindowAdapter
	{
		@Override
		public void windowClosing(WindowEvent e)
		{
			vistaHome.dlgSalir.setVisible(true);
		}

	}

}
