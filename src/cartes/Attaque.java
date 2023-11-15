package cartes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jeu.Joueur;

public class Attaque extends Bataille {

	private static Map<Type,String> nomCartes = new HashMap<>();

	public Attaque(int nombre, Type type) {
		super(nombre, type);
	}
	
	static {
		nomCartes.put(Type.ACCIDENT, "Accident");
		nomCartes.put(Type.CREVAISON, "Crevaison");
		nomCartes.put(Type.ESSENCE, "Panne d'essence");
		nomCartes.put(Type.FEU, "FeuRouge");
	}

	@Override
	public String toString() {
		return nomCartes.get(getType());
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
		j.getPileBataille().add(this);
		return true;
	}

}
