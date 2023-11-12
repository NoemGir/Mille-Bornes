package jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cartes.Carte;

public class Jeu {
	
	private Set<Joueur> joueurs;
	private List<Carte> sabot;
	
	public Jeu() {
		joueurs = new HashSet<>();
		sabot = new ArrayList<>();
	}
	
	public void s_inscrire(Joueur joueur) {
		joueurs.add(joueur);
		joueur.setJeu(this);
	}

	public Set<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(Set<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public List<Carte> getSabot() {
		return sabot;
	}

	public void setSabot(List<Carte> sabot) {
		this.sabot = sabot;
	}
}
