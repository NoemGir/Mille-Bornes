package cartes;

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