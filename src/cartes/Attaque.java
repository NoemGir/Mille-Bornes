package cartes;

import java.util.List;
import java.util.Set;

import jeu.Joueur;

public class Attaque extends Bataille {


	public Attaque(int nombre, Type type) {
		super(nombre, type);
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
	
	@Override
	public boolean appliquer(Joueur j) {
		Set<Botte> bottes = j.getBottes();
		if (bottes.contains(new Botte(1,this.getType()))) {
			return false;
		}
		List<Bataille> listeBataille = j.getPileBataille();
		listeBataille.add(this);
		return true;
	}

}
