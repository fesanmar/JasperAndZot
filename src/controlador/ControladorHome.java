package controlador;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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
				new WindowListener()
				{
					
					@Override
					public void windowOpened(WindowEvent e) {}
					
					@Override
					public void windowIconified(WindowEvent e) {}
					
					@Override
					public void windowDeiconified(WindowEvent e) {}
					
					@Override
					public void windowDeactivated(WindowEvent e) {}
					
					@Override
					public void windowClosing(WindowEvent e) { 
						vistaHome.dlgJugador.setVisible(false); }
					
					@Override
					public void windowClosed(WindowEvent e){}
					
					@Override
					public void windowActivated(WindowEvent e) {}
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
			String player = this.vistaHome.txtDlgJugador.getText();
			if (!player.trim().isEmpty())
			{
				this.vistaHome.tablero.setPartida(new Partida(player));
				this.vistaHome.dlgJugador.setVisible(false);
				this.vistaHome.txtDlgJugador.setText("");
				this.vistaHome.validate();
				this.vistaHome.repaint();
			}
		});
		
		
		this.vistaHome.setVisible(true);
	}
	
	class ControladorVentana implements WindowListener
	{

		@Override
		public void windowActivated(WindowEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent e)
		{
			vistaHome.dlgSalir.setVisible(true);
		}

		@Override
		public void windowDeactivated(WindowEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent e)
		{
			// TODO Auto-generated method stub
			
		}
		
	}

}
