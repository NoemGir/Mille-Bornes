package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import cartes.Carte;

public class Utils {
	
	public static <T> T extraire(List<T> liste) {
		int i = (int) (Math.random() * liste.size());
		T element = liste.get(i);
		liste.remove(i);
		return element;
	}
	
	public static <T> T extraireV2(List<T> liste) {
		Iterator<T> it = liste.iterator();
		int i = (int) (Math.random() * liste.size());
		for(; i > 0; i--) {
			it.next();
		}
		T element = it.next();
		it.remove();
		return element;
	}
	
	public static <T> List<T> melanger(List<T> listeInitiale){
		List<T> nouvelleListe = new ArrayList<>();
		for (int i = listeInitiale.size(); i >0; i--) {
			nouvelleListe.add(extraire(listeInitiale));
		}
		return nouvelleListe;
	}
	
	public static <T> boolean verifierMelange(List<T> listeInitiale, List<T> nouvelleListe){
		for( T elt : listeInitiale) {
			if (Collections.frequency( listeInitiale, elt) != Collections.frequency(nouvelleListe, elt)) return false; 
		}
		return true;
	}
	
	
	public static <T> List<T> rassembler(List<T> listeInitiale){
		List<T> listeFinale = new ArrayList<>();
		for ( T elt : listeInitiale) {
			if (!listeFinale.contains(elt))
			for (int j = 1; j < Collections.frequency(listeInitiale, elt); j++) {
				listeFinale.add(elt);
			}
		}
		return listeFinale;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}



























