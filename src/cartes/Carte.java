package cartes;

import jeu.Joueur;

public abstract class Carte {
	private int nombre;
	
	public Carte(int nombre) {
		this.nombre = nombre;
		
	}
	
	public int getNombre() {
		return nombre;
	}
	
	public abstract boolean appliquer(Joueur j);


}
