package cartes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jeu.Joueur;

public class Parade extends Bataille {
	
	private static Map<Type,String> nomCartes = new HashMap<>();


	public Parade(int nombre, Type type) {
		super(nombre, type);
	}
	
	static {
		nomCartes.put(Type.ACCIDENT, "Reparation");
		nomCartes.put(Type.CREVAISON, "Roue de secours");
		nomCartes.put(Type.ESSENCE,"Essence");
		nomCartes.put(Type.FEU, "FeuVert");
	}
	
	@Override
	public String toString() {
		return nomCartes.get(getType());
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
		if(!bottes.contains(new Botte(1,this.getType())) && !listeBataille.isEmpty()){
			Bataille top = listeBataille.get(listeBataille.size()-1);
			if (top.equals(new Attaque(1, this.getType()))) {
				listeBataille.add(this);
				System.out.println("ajout de la parade " + this);
				return true;
			}
		}
		return false;
	}
}
