package controlador;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import modelo.partida.Partida;
import vista.Home;

public class ControladorHome
{
	Home vistaHome;
	ControladorVentana controladorVentana;
	public ControladorHome(Home vistaHome)
	{
		this.vistaHome = vistaHome;
		controladorVentana = new ControladorVentana();
		
		//////////// Eventos de ventana ///////////////
		this.vistaHome.addWindowListener(controladorVentana);
		this.vistaHome.dlgJugador.addWindowListener(
				new WindowAdapter()
				{	
					@Override
					public void windowClosing(WindowEvent e) { 
						vistaHome.dlgJugador.setVisible(false);
						}
				}
				);
		this.vistaHome.dlgSalir.addWindowListener(
				new WindowAdapter()
				{	
					@Override
					public void windowClosing(WindowEvent e) { 
						vistaHome.dlgSalir.setVisible(false);
						}
				}
				);
		
		///////////  Eventos del menú  ///////////////
		this.vistaHome.miNuevoJuego.addActionListener(
				ale -> this.vistaHome.dlgJugador.setVisible(true)
				);
		this.vistaHome.miSalir.addActionListener(
				ae -> this.vistaHome.dlgSalir.setVisible(true)
				);
		
		
		/////////// Eventos de botones  //////////////
		// Botones Dialog SALIR
		this.vistaHome.btnDlgSi.addActionListener(ale -> System.exit(0));
		this.vistaHome.btnDlgNo.addActionListener(
				ale -> this.vistaHome.dlgSalir.setVisible(false)
				);
		this.vistaHome.btnDlgJugador.addActionListener(ale -> {
			startGame();
		});
		
		////////////  Eventos de TextFields  ///////////
		this.vistaHome.txtDlgJugador.addKeyListener(
				new KeyAdapter()
				{
					@Override
					public void keyReleased(KeyEvent arg0) 
					{
						String name = vistaHome.txtDlgJugador.getText();
						if (name.trim().length() > 0 && name.length() <= 8)
						{
							vistaHome.btnDlgJugador.setEnabled(true);
						}
						else
						{
							vistaHome.btnDlgJugador.setEnabled(false);
						}
					}
					
					@Override
					public void keyPressed(KeyEvent e) 
					{
						if(vistaHome.btnDlgJugador.isEnabled())
						{
							if (e.getKeyCode() == 10)
							{
								startGame();								
							}
							
						}
					}
				}
				);
		
		
		this.vistaHome.setVisible(true);
	}

	private void startGame()
	{
		String player = this.vistaHome.txtDlgJugador.getText();
		if (!player.trim().isEmpty())
		{
			this.vistaHome.tablero.setPartida(new Partida(player, vistaHome.tablero));
			this.vistaHome.dlgJugador.setVisible(false);
			this.vistaHome.txtDlgJugador.setText("");
			this.vistaHome.tablero.getPartida().place();
			this.vistaHome.repaint();
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
