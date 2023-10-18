package jeu;

import java.util.List;

import cartes.Carte;

public class MainAsList implements Main {
	
	List<Carte> main;
	

	public MainAsList(List<Carte> main) {
		this.main = main;
	}

	@Override
	public void prendre(Carte carte) {
		main.add(carte);
	}

	@Override
	public void jouer(Carte carte) {
		main.remove(carte);
	}
}
