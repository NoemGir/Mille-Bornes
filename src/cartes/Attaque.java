package cartes;

public class Attaque extends Bataille {


	public Attaque(int nombre, Type accident) {
		super(nombre, accident);
	}

	@Override
	public String toString() {
		switch (getType()) {
		case ACCIDENT : return "Accident";
		case CREVAISON : return "Crevaison";
		case ESSENCE : return "Panne d'essence";
		case FEU : return "FeuRouge";
		default : return "";
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Attaque ) {
			Attaque objetAttaque = (Attaque) o;
			return objetAttaque.getType().equals(getType());
		}
		return false;
	} 
}
