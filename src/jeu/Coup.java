package jeu;

import cartes.Attaque;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Parade;

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
		if (carte.getClass() == Attaque.class || carte.getClass() ==  DebutLimite.class)
			return !j.equals(cible);
		else return j.equals(cible);
	}
	
	
	public boolean jouer(Joueur j) {
		
		if(cible == null) {
			System.out.println(" \u001B[35m le joueur " + j + " repose la carte : " + carte + " dans le sabot \u001B[0m");
			return true;
		}

		if (carte.appliquer(cible)) {
			j.getMain().jouer(carte);
			if(carte.getClass() == Parade.class || carte.getClass() == Botte.class || carte.getClass() == FinLimite.class || carte.getClass() == Borne.class) {
				System.out.println(" \u001B[33m le joueur " + j + " met dans son jeu la carte " + carte + "\u001B[0m");
			}
			else {
				System.out.println(" \u001B[32m le joueur " + j + " joue la carte : " + carte + " sur la cible " + cible + "\u001B[0m");
			}
			return true;
		}
		return false;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Coup) {
			Coup coup = (Coup) o;
			if((cible == null && coup.cible == null) || (cible != null && coup.cible != null)) {
				return  coup.carte.equals(carte);
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "" + carte + "/" + cible;
	}
	@Override 
	public int hashCode() {
		if(cible != null ) {
			return carte.hashCode() + cible.hashCode();
		}
		else return carte.hashCode();
	}
	
	
}
