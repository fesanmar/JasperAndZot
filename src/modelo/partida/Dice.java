package modelo.partida;

import java.util.Random;

public class Dice {

	private int result;
	private Random random;
	
	public Dice()
	{
		random = new Random();
	}

	public int getResult() {
		return this.result;
	}

	public void roll() 
	{
		result = random.nextInt(6) + 1;
	}

}