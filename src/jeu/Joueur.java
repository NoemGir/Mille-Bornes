package jeu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;
import cartes.Type;

public class Joueur implements Comparable<Joueur>{
	private String nom;
	private List<Limite> pileLimite;
	private List<Bataille> pileBataille;
	private List<Borne> collecBorne;
	private Set<Botte> bottes;
	private MainAsList main;
	private Jeu jeu;
	
	
	public Joueur(String nom) {
		this.nom = nom;
		main = new MainAsList();
		pileLimite = new ArrayList<>();
		pileBataille = new ArrayList<>();
		collecBorne = new ArrayList<>();
		bottes = new HashSet<>();
	}
	
	public void donner(Carte carte) {
		main.prendre(carte);
	}
	
	public Carte prendreCarte(List<Carte> sabot) {
		if(sabot.isEmpty()) return null;
		Carte carte = sabot.get(sabot.size()-1);
		sabot.remove(sabot.size()-1);
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
	
	public int getLimite() {
		if(pileLimite.isEmpty() || pileLimite.get(pileLimite.size()-1) instanceof FinLimite) {
			return 200;
		}
		for (Botte botte : bottes) {
			if(botte.equals(new Botte(1, Type.FEU))){
				return 200;
			}
		}
		return 50;
	} 
	
	public boolean estBloque() {
		
		if(pileBataille.isEmpty()) {
			return false;
		}
		Bataille sommetBataille = pileBataille.get(pileBataille.size()-1);
	    if(sommetBataille.getClass() == Parade.class) {
			return false;
		}
		return !bottes.contains(new Botte(0, sommetBataille.getType()));

	}
	
	public MainAsList getMain() {
		return main;
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof Joueur && ((Joueur) o).nom.equals(nom);
	}
	
	@Override
	public int hashCode() {
		return nom.hashCode();
	}
	
	
	@Override
	public String toString() {
		return nom;
	}

	public Set<Coup> coupsPossibles(Set<Joueur> participants) {
		Set<Coup> coupsPossibles = new HashSet<>();
		for(Joueur participant : participants) {
			for(Carte carte : main) {
				Coup coupPotentiel = new Coup(carte, participant);
				if(coupPotentiel.estValide(this)) {
					coupsPossibles.add(coupPotentiel);
				}
			}
		}
		return coupsPossibles;
	}
	
	public Set<Coup> coupsParDefault(){
		Set<Coup> coupsDefaults = new HashSet<>();
		for(Carte carte : main)
			coupsDefaults.add(new Coup(carte, null));
		return coupsDefaults;
	}
	
	public Coup selectionner() {
		Set<Coup> coupsPossibles = this.coupsPossibles(jeu.getJoueurs());
		Iterator<Coup> it = coupsPossibles.iterator();
		for (; it.hasNext();) {
			Coup next = it.next();
			if (next.jouer(this)) {
				return next;
			}
		}
		return null;
	}
	
	public Coup rendreCarte() {
		Set<Coup> coupsdefaults = this.coupsParDefault();
		for(Coup coup : coupsdefaults) {
			if (coup.jouer(this)) {
				main.jouer(coup.getCarte());
				return coup;
			}
		}
		return null;
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

	public void setPileLimite(List<Limite> pileLimite) {
		this.pileLimite = pileLimite;
	}

	public void setPileBataille(List<Bataille> pileBataille) {
		this.pileBataille = pileBataille;
	}

	public void setCollecBorne(List<Borne> collecBorne) {
		this.collecBorne = collecBorne;
	}

	public void setBottes(Set<Botte> bottes) {
		this.bottes = bottes;
	}

	public Jeu getJeu() {
		return jeu;
	}

	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public int compareTo(Joueur o) {
		int comparaison = this.getKM() - o.getKM();
		if(comparaison == 0) {
			comparaison = 1;
		}
		return comparaison;
	}
}
