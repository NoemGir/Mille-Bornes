package cartes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jeu.Joueur;

public class Botte extends Probleme {
	
	private static Map<Type,String> nomCartes = new HashMap<>();

	public Botte(int nombre, Type type) {
		super(nombre, type);
	}
	
	static {
		nomCartes.put(Type.ACCIDENT, "As du volant");
		nomCartes.put(Type.CREVAISON, "Increvable");
		nomCartes.put(Type.ESSENCE, "Citerne");
		nomCartes.put(Type.FEU, "Prioritaire");
	}
	
	@Override
	public String toString() {
		return nomCartes.get(getType());
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Botte) {
			Botte objetBotte = (Botte) o;
			return objetBotte.getType().equals(getType());
		}
		return false;
	} 
	
	@Override
	public int hashCode() {
			return getType().hashCode()*13;
	} 


	@Override
	public boolean appliquer(Joueur j) {
		
		List<Bataille> listeBataille = j.getPileBataille();
		j.getBottes().add(this);
		/*
		if(!listeBataille.isEmpty()) {
			Bataille top = listeBataille.get(listeBataille.size()-1);
			if (top.equals(new Attaque(1, this.getType()))) {
				listeBataille.remove(listeBataille.size()-1);
			}		
		} */
		return true;
	}
}
