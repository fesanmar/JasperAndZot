package modelo.componentes.spells;

import modelo.partida.Partida;

public class FireSpell extends Spell
{
	public FireSpell(Partida partida)
	{
		super(255, 910, "./images/fire.jpeg", partida);
	}

	@Override
	public void cast()
	{
		System.out.println("Se disparón el hechzo de fuego");
	}
}
