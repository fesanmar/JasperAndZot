package modelo.partida;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import modelo.componentes.Componente;

public class Dice extends Componente 
{

	private int result;
	private Random random;
	private Image[] diceImages;
	
	public Dice(int x, int y)
	{
		super(x, y, 32);
		random = new Random();
		diceImages = new Image[6];
		for (int i = 0; i < diceImages.length; i++)
		{
			File pathImage = new File("./images/dices/" + (i + 1) +".jpeg");
			System.out.println(pathImage.toString());
			try
			{
				Image image = ImageIO.read(pathImage);
				diceImages[i] = image;
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		setImage(diceImages[0]);
	}

	public int getResult() {
		return this.result;
	}

	public void roll() 
	{
		result = random.nextInt(6) + 1;
		setImage(diceImages[result - 1]);
	}

}