package modelo.partida.assaults.patterns;

public class WrongNumberOfTokensException extends Exception
{
	private static final long serialVersionUID = 1L;

	public WrongNumberOfTokensException()
	{
		super("El número de tokens a colocar no casa con el patrón.");
	}
}
