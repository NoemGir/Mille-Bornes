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
		default : return "";
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Botte) {
			Botte objetBotte = (Botte) o;
			return objetBotte.getType().equals(getType());
		}
		return false;
	} 
}
