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
		}
		return null;
	}
}
