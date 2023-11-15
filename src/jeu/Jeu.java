package jeu;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import cartes.Carte;
import cartes.JeuDeCarte;
import utils.Utils;

public class Jeu implements Iterable<Carte>{
	
	private Set<Joueur> joueurs;
	private JeuDeCarte jeu;
	private Sabot<Carte> sabot;
	
	public Jeu(Carte[] typesDeCartes) {
		
		joueurs = new LinkedHashSet<>();
		jeu = new JeuDeCarte(typesDeCartes);
	}
	
	public void distribuerCartes() {
		List<Carte> cartes = jeu.getListeCartes();
		
		for(Joueur joueur : joueurs ) {
			for(int i = 0; i < 6; i++) {
				joueur.donner(cartes.get(0));
				cartes.remove(0);
			}
		}
		sabot = new Sabot<>(cartes.size(),(Carte[]) cartes.toArray());
	}
	
	public void inscrire(Joueur joueur) {
		joueurs.add(joueur);
		joueur.setJeu(this);
	}

	public Set<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(Set<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public Sabot<Carte> getSabot() {
		return sabot;
	}

	public void setSabot(Sabot<Carte> sabot) {
		this.sabot = sabot;
	}

	@Override
	public Iterator<Carte> iterator() {
		return sabot.iterator();
	}
}
