package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Carte;

public class MainAsList implements Main {
	
	List<Carte> main;
	

	public MainAsList() {
		main = new ArrayList<>();
	}

	@Override
	public void prendre(Carte carte) {
		main.add(carte);
	}

	@Override
	public void jouer(Carte carte) {
		assert(main.contains(carte));
		main.remove(carte);
		
	}
}
