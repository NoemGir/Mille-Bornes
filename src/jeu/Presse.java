package jeu;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

import cartes.Borne;
import cartes.Carte;

public class Presse extends Joueur {
	
	private static final Comparator<Coup> COMPARATOR = new Comparator<Coup>() {

		@Override
		public int compare(Coup c1, Coup c2) {
			Carte carteC1 = c1.getCarte();
			Carte carteC2 = c2.getCarte();
			if (carteC1.getClass() == Borne.class) {
				if (carteC2.getClass() == Borne.class) {
					return ((Borne) carteC2).compareTo((Borne) carteC1);
				}
				return -1;
			}
			if(carteC2.getClass() == Borne.class) {
				return 1;
			}
			return -1;
		}
		
	};

	public Presse(String nom) {
		super(nom);
	}
	
	@Override
	public Set<Coup> coupsPossibles(Set<Joueur> joueurs) {
		Set<Coup> def = super.coupsPossibles(joueurs);
		NavigableSet<Coup> res = new TreeSet<>(COMPARATOR) ;
		res.addAll(def);
		return res;
	}
	
}
