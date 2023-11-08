package jeu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;
import cartes.Type;

public class Joueur {
	private String nom;
	private List<Limite> pileLimite;
	private List<Bataille> pileBataille;
	private List<Borne> collecBorne;
	private Set<Botte> bottes;
	private MainAsList main;
	
	
	public Joueur(String nom) {
		this.nom = nom;
		main = new MainAsList();
		pileLimite = new ArrayList<>();
		pileBataille = new ArrayList<>();
		collecBorne = new ArrayList<>();
		bottes = new HashSet<>();
	}
	
	public void jouer(Carte carte) {
		main.jouer(carte);
		if (carte instanceof Bataille) {
			pileBataille.add((Bataille) carte);
		}
		else if (carte instanceof Limite) {
			pileLimite.add((Limite) carte);
		}
		else if (carte instanceof Borne) {
			collecBorne.add((Borne) carte);
		}
		else if (carte instanceof Botte) {
			bottes.add((Botte) carte);
		}
	}
	
	public void donner(Carte carte) {
		main.prendre(carte);
	}
	
	public Carte prendreCarte(List<Carte> sabot) {
		if(sabot.isEmpty()) return null;
		Carte carte = sabot.get(sabot.size()-1);
		sabot.remove(carte);
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
		boolean prioritaire = false;
		boolean protege_botte = false;

		for (Botte botte : bottes) {
			if(botte.equals(new Botte(1, Type.FEU))){
				prioritaire = true;
			}
		}
		
		Bataille sommetBataille = pileBataille.get(pileBataille.size()-1);
	    if(sommetBataille.equals(new Parade(1, Type.FEU))) {
			return false;
		}
		else if(prioritaire) {
			
			if(pileBataille.isEmpty()) {
				return false;
			}
			else if(sommetBataille instanceof Parade ) {
				return false;
			}
			else if(sommetBataille.equals(new Attaque(1, Type.FEU))) {
				return false;
			}
		}
	    for (Botte botte : bottes) {
			if(botte.getType().equals(sommetBataille.getType())){
				protege_botte = true;
			}
		}
	    return !protege_botte;
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

	public HashSet<Coup> coupsPossibles(List<Joueur> participants) {
		HashSet<Coup> coupsPossibles = new HashSet<>();
		for(Joueur participant : participants) {
			Iterator<Carte> it = main.iterateur();
			for(;it.hasNext();) {
				Coup coupPotentiel = new Coup(it.next(), participant);
				if(coupPotentiel.estValide(this)) {
					coupsPossibles.add(coupPotentiel);
				}
			}
		}
		return coupsPossibles;
	}
	
	public HashSet<Coup> coupsParDefault(){
		HashSet<Coup> coupsDefaults= new HashSet<>();
		Iterator<Carte> it = main.iterateur();
		for(;it.hasNext();) {
			Carte carte = it.next();
			if(carte instanceof Parade || carte instanceof Botte || carte instanceof Borne) {
				Coup coup = new Coup(carte, null);
				coupsDefaults.add(coup);
			}
		}
		return coupsDefaults;
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
	
	

}
