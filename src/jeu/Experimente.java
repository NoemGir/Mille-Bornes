package jeu;

import java.util.Comparator;
import java.util.HashMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

import cartes.Attaque;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Parade;

public class Experimente extends Joueur {
	
	private static final int FAIBLE = 0;
	private static final int FORT = 1;

	private static HashMap<Class<? extends Carte>, Integer> numeroCarte = new HashMap<>();
	private int sens;
	
	static {
		numeroCarte.put(Botte.class, 6);
		numeroCarte.put(FinLimite.class, 5);
		numeroCarte.put(Borne.class, 4);
		numeroCarte.put(Parade.class, 3);
		numeroCarte.put(Attaque.class, 2);
		numeroCarte.put(DebutLimite.class, 1);
	}
	
	private Comparator<Coup> comparator = new Comparator<Coup>() {

		@Override
		public int compare(Coup c1, Coup c2) {
			int comparaison;
			int val1 = numeroCarte.get(c1.getCarte().getClass());
			int val2 = numeroCarte.get(c2.getCarte().getClass());
			if(sens == FAIBLE) {
				comparaison = val1 - val2;
			}
			else {
				comparaison = val2 - val1;
			}
			if(comparaison == 0) {
				if(c1.getCarte().getClass() == Borne.class) {
					if(sens == FAIBLE) {
						comparaison = ((Borne) c1.getCarte()).compareTo((Borne) c2.getCarte());
					}
					else {
						comparaison = ((Borne) c2.getCarte()).compareTo((Borne) c1.getCarte());
					}
					return comparaison;
				}
				if(c1.getCarte().getClass() == Attaque.class || c1.getCarte().getClass() == DebutLimite.class) {
					if(sens == FAIBLE) {
						comparaison = 1;
					}
					else {
						comparaison = c2.getCible().compareTo(c1.getCible());
					}
					return comparaison;
				}
				return 1;
			}
			return comparaison;
		}
	};
	
	public Experimente(String nom) {
		super(nom);
	}
	
	@Override
	public Set<Coup> coupsPossibles(Set<Joueur> joueurs){
		
		Set<Coup> def = super.coupsPossibles(joueurs);
		sens = FORT;
		NavigableSet<Coup> res = new TreeSet<>(comparator);
		res.addAll(def);
		return res;
	}
	
	@Override
	public Set<Coup> coupsParDefault(){
		
		Set<Coup> def = super.coupsParDefault();
		sens = FAIBLE;
		NavigableSet<Coup> res = new TreeSet<>(comparator);
		
		res.addAll(def);
		return res;
	}
	
}












