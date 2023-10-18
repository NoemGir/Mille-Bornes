package jeu;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.Limite;

public class Joueur {
	private String nom;
	private List<Limite> pileLimite;
	private List<Bataille> pileBataille;
	private Collection<Borne> collecBorne;
	private Set<Botte> bottes;
	private MainAsList main;
	
	
	public Joueur(String nom,List<Limite> pileLimite, List<Bataille> pileBataille, Collection<Borne> collecBorne,
			Set<Botte> bottes) {
		this.nom = nom;
		this.pileLimite = pileLimite;
		this.pileBataille = pileBataille;
		this.collecBorne = collecBorne;
		this.bottes = bottes;
	}
	
	public void donner(Carte carte) {
		main.prendre(carte);
	}
	
	public Carte prendreCarte(List<Carte> sabot) {
		if(sabot.isEmpty()) return null;
		Carte carte = sabot.get(sabot.size()-1);
		main.prendre(carte);
		return carte;
	}
	
	public int getKM() {
		int km = 0;
		for (Borne borne : collecBorne) {
			km = km+borne.getKm();
		} 
		return km;
	} 
	
	public MainAsList getMain() {
		return main;
	}



	@Override
	public boolean equals(Object o) {
		return o instanceof Joueur && ((Joueur) o).nom.equals(nom);
	}
	
	@Override
	public String toString() {
		return nom;
	}

	
	
	public List<Limite> getPileLimite() {
		return pileLimite;
	}
	public List<Bataille> getPileBataille() {
		return pileBataille;
	}
	public Collection<Borne> getCollecBorne() {
		return collecBorne;
	}
	public Set<Botte> getBottes() {
		return bottes;
	}
	


}
