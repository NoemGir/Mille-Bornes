package jeu;

import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot<T extends Carte> implements Iterable<T>{
	private T[] pioche;
	private int nbCartePioche = 0;
	private int nbCarteMax;
	


	public Iterator<T> iterator(){
		return new Iterateur();
	}
	
	private class Iterateur implements Iterator<T>{
		private int indiceIt = 0;
		private boolean hasNext = false;
		private boolean nextEffectue = false;
		
		public boolean hasNext() {
			return indiceIt < nbCarteMax;
		}

		@Override
		public T next() {
			if (hasNext()) {
				T elt = pioche[indiceIt];
				indiceIt++;
				nextEffectue = true;
				return elt;
			}
			else throw new NoSuchElementException();
		}
		
		@Override
		public void remove() {
			if (nbCartePioche < 1 || !nextEffectue) {
				throw new IllegalStateException();
			}
			for(int i = indiceIt -1 ; i < nbCarteMax-1; i++ ) {
				pioche[i] = pioche[i+1];
			}
			nextEffectue = false;
			indiceIt--;
			nbCartePioche--;
		}
	}

	public Sabot(int nbCarteMax, T[] pioche) {
		this.nbCarteMax = nbCarteMax;
		this.pioche = pioche;
	}
	
	public boolean estVide() {
		return nbCartePioche == 0;
	}
	
	private void ajouterCarte(T carte) {
		if (nbCartePioche < nbCarteMax) {
			pioche[nbCartePioche] = carte;
			nbCartePioche++;
		}
		else throw new ArrayIndexOutOfBoundsException(" Ajout d'une carte dans une pioche max\n");
	}
	
	public void ajouterFamilleCarte(T carte) {
		int i = 0;
		while( i < carte.getNombre()) {
			ajouterCarte(carte);
			i++;
			
		}

	}
	
	
	public void ajouterFamilleCarte(T...cartes) {
		int i = 0;
		while( i < cartes.length) {
			ajouterFamilleCarte(cartes[i]);
			i++;
		}
	}
	
	public T piocher() {
		Iterator<T> it = iterator();
		T next = it.next();
		it.remove();
		System.out.println("Je pioche " + next.toString());
		return next;
	}
	
	public T[] getPioche() {
		return pioche;
	}
}
