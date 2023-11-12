package cartes;

import java.util.List;
import java.util.Set;

import jeu.Joueur;

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
	
	@Override
	public int hashCode() {
			return getType().hashCode();
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
