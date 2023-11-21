package jeu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

import cartes.Carte;
import cartes.JeuDeCarte;
import utils.Utils;

public class Jeu implements Iterable<Carte>{
	
	private Set<Joueur> joueurs;
	private JeuDeCarte jeu;
	private List<Carte> sabot;
	
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
		sabot = new ArrayList<>(cartes);
	}
	
	public void inscrire(Joueur joueur) {
		joueurs.add(joueur);
		joueur.setJeu(this);
	}
	
	public void lancer() {
		boolean termine = false;
		distribuerCartes();
		for (Joueur joueur : joueurs) {
			System.out.println(joueur + ":" + joueur.getMain().toString());
		}
		
		while(!(termine || sabot.isEmpty())){
			
			for(Joueur joueur : joueurs) {

				Carte carte = joueur.prendreCarte(sabot);
				System.out.println("Le joueur " +  joueur + " prend la carte " + carte);

				System.out.println("sa main : " +  joueur.getMain().toString());
				System.out.println("ses coups : " + joueur.coupsPossibles(joueurs));
				Coup coup = joueur.selectionner();
				if(coup == null) {
					joueur.rendreCarte();
				}
				else {
					if (joueur.getKM() == 1000) {
						termine = true;
						break;
					}
				}
			}
		}
		if(sabot.isEmpty()) {
			System.out.println("Le sabot est vide");
		}
		NavigableSet<Joueur> resultat = obtenir_resultat();
		Iterator<Joueur> it = resultat.iterator();
		Joueur gagnant = it.next();
		System.out.println("Le jeu est termine. " + gagnant + " a gagne en parcourant "+ gagnant.getKM()+ " km ! ");
		
		System.out.println("Classement des autres joueurs : ");
		for(;it.hasNext();) {
			Joueur suivant = it.next();
			System.out.println(suivant + " avec " + suivant.getKM()+ " km");
		}
		
	}
	
	public NavigableSet<Joueur> obtenir_resultat(){
		NavigableSet<Joueur> joueurTries =
				new TreeSet<>(
						new Comparator<Joueur>() {
							public int compare(Joueur j1, Joueur j2) {
								Integer kmJ1 = j1.getKM();
								Integer kmJ2 = j2.getKM();
								int comparaison = -kmJ1.compareTo(kmJ2);
								if(comparaison == 0) {
									comparaison = j1.getNom().compareTo(j2.getNom());
								}
								return comparaison;
							}
						}
					);
		joueurTries.addAll(joueurs);
		return joueurTries;
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

	@Override
	public Iterator<Carte> iterator() {
		return sabot.iterator();
	}
}
