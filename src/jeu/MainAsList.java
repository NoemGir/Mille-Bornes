package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import cartes.Carte;

public class MainAsList implements Main {
	
	private List<Carte> main;
	

	public MainAsList() {
		main = new ArrayList<>();
	}


	@Override
	public void prendre(Carte carte) {
		main.add(carte);
		assert(main.contains(carte));
	}

	@Override
	public void jouer(Carte carte) {
		assert(main.contains(carte));
		main.remove(carte);
	}
	
	@Override
	public String toString() {
		return main.toString();
	}

	@Override
	public Iterator<Carte> iterator() {
		return main.iterator();
	}
}
