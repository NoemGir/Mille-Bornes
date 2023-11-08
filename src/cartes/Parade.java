package cartes;

import java.util.List;
import java.util.Set;

import jeu.Joueur;

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
		default : return "";
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Parade) {
			Parade objetParade = (Parade) o;
			return objetParade.getType().equals(getType());
		}
		return false;
	} 
	
	@Override
	public boolean appliquer(Joueur j) {
		List<Bataille> listeBataille = j.getPileBataille();
		Set<Botte> bottes = j.getBottes();
		Bataille top = listeBataille.get(listeBataille.size());
		if (top instanceof Attaque && top.getType().equals(this.getType()) && !bottes.contains(new Botte(1,this.getType()))) {
			listeBataille.add(this);
			return true;
		}
		return false;
	}
}
