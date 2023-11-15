package cartes;

import java.util.HashMap;
import java.util.Map;

public abstract class Probleme extends Carte {
	
	private Type type;

	public Probleme(int nombre, Type type) {
		super(nombre);
		this.type = type;
	}

	public Type getType() {
		return type;
	}
	
}
