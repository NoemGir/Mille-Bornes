package cartes;

public class Botte extends Probleme {

	public Botte(int nombre, Type type) {
		super(nombre, type);
	}
	
	@Override
	public String toString() {
		switch (getType()) {
		case ACCIDENT : return "As du volant";
		case CREVAISON : return "Increvable";
		case ESSENCE : return "Citerne d'essence";
		case FEU : return "Vehicule Prioritaire";
		}
		return null;	}
}
