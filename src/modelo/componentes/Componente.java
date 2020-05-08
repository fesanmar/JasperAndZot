package modelo.componentes;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Componente extends Elemento {

	private Image image;
	
	public Componente()
	{
		super();
		this.image = null;
	}
	
	public Componente(int x, int y, int width, int height, String file)
	{
		super(x, y, width, height);
		File pathImage = new File(file);
		try
		{
			this.image = ImageIO.read(pathImage);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public Componente(int x, int y, int side, String file)
	{
		super(x, y, side);
		File pathImage = new File(file);
		try
		{
			this.image = ImageIO.read(pathImage);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public Componente(int side, String file)
	{
		super(0, 0, side);
		File pathImage = new File(file);
		try
		{
			this.image = ImageIO.read(pathImage);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public Componente(int side)
	{
		super(0, 0, side);
	}
	
	public Componente(int x, int y, int side)
	{
		super(x, y, side);
	}

	public Image getImage() {
		return this.image;
	}

	/**
	 * 
	 * @param image
	 */
	public void setImage(Image image) {
		this.image = image;
	}
	
	public boolean isMe(int x, int y)
	{
		if (
				(x > getX() && x < (getX() + getWidth()))
				&&
				(y > getY() && y < (getY() + getHeight()))
				)
		{
			return true;
		}
		return false;
	}

}