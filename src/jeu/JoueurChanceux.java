package jeu;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import utils.Utils;

public class JoueurChanceux extends Joueur {

	public JoueurChanceux(String nom) {
		super(nom);
	}
	
	@Override
	public Coup selectionner() {
		List<Coup> coupsPossibles = Utils.melanger(new ArrayList<>(coupsPossibles(getJeu().getJoueurs())));
		
		for(Coup coup : coupsPossibles) {			
			if (coup.jouer(this)) {
				return coup;
			}
		}
		return null;
	}
	
	@Override
	public Coup rendreCarte() { 
		List<Coup> coupsdefaults = Utils.melanger(new ArrayList<>(coupsParDefault()));
		for(Coup coup : coupsdefaults) {
			if (coup.jouer(this)) {
				getMain().jouer(coup.getCarte());
				return coup;
			}
		}
		return null;
	}
	
}
