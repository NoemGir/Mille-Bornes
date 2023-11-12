package jeu;

import cartes.Attaque;
import cartes.Carte;
import cartes.DebutLimite;

public class Coup {
	
	private Carte carte;
	private Joueur cible;
	
	public Coup(Carte carte, Joueur cible) {
		this.carte = carte;
		this.cible = cible;
	}

	public Carte getCarte() {
		return carte;
	}

	public Joueur getCible() {
		return cible;
	}
	
	public boolean estValide(Joueur j) {
		if (carte instanceof Attaque || carte instanceof DebutLimite)
			return !j.equals(cible);
		else return true;
	}
	
	public boolean jouer(Joueur j) {
		boolean possible = false;
		
		if(cible == null) {
			j.getJeu().getSabot().add(carte);
			possible = true;
			System.out.println("le joueur " + j + "repose la carte : " + carte + "dans le sabot");
		}
		possible = possible || carte.appliquer(cible);
		
		if (possible) {
			j.getMain().jouer(carte);
			System.out.println("le joueur " + j + "joue la carte : " + carte + " sur la cible " + cible);
		}
		return possible;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Coup) {
			Coup coup = (Coup) o;
			return coup.carte.equals(carte) && coup.cible.equals(cible);
		}
		return false;
	}
	
	@Override 
	public int hashCode() {
		return carte.hashCode() + cible.hashCode();
	}
	
	
}
