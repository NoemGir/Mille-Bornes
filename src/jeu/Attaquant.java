package jeu;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
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

public class Attaquant extends Joueur {
	
	private static Map<Class<? extends Carte>,Integer> valeurCarte = new HashMap<>();

	static {
		valeurCarte.put(Attaque.class, 6);
		valeurCarte.put(DebutLimite.class, 5);
		valeurCarte.put(FinLimite.class, 4);
		valeurCarte.put(Parade.class, 3);
		valeurCarte.put(Borne.class, 2);
		valeurCarte.put(Botte.class, 1);
	}
	
	private static final Comparator<Coup> COMPARATOR = new Comparator<Coup>(){
		
		private int compareBorne(Borne b1, Borne b2) {
			int comparaison = b1.compareTo(b2);
			if (comparaison == 0)
				return 1;
			return comparaison;
		}

		@Override
		public int compare(Coup c1, Coup c2) {
			Carte carteC1 = c1.getCarte();
			Carte carteC2 = c2.getCarte();
			
			int val1 = valeurCarte.get(carteC1.getClass());
			int val2 = valeurCarte.get(carteC2.getClass());
			
			int comparaison = val2 - val1;
			if (comparaison == 0) {
				if (carteC1.getClass() == Borne.class) {
					return compareBorne((Borne) carteC2, (Borne) carteC1 );
				}
				return 1;
			}
			
			return comparaison;
		}		
	};
	
	public Attaquant(String nom) {
		super(nom);
	}
	
	@Override
	public Set<Coup> coupsPossibles(Set<Joueur> participants) {
		Set<Coup> def = super.coupsPossibles(participants);
		NavigableSet<Coup> res = new TreeSet<>(COMPARATOR);
		res.addAll(def);
		return res;
	}
}
