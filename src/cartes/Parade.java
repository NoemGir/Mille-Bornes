package cartes;

public class Parade extends Bataille {

	public Parade(int nombre, Type type) {
		super(nombre, type);
	}
	
	@Override
	public String toString() {
		switch (getType()) {
		case ACCIDENT : return "Reparation";
		case CREVAISON : return "Roue de secours";
		case ESSENCE : return "Essence";
		case FEU : return "FeuVert";
		}
		return null;
	}
}
