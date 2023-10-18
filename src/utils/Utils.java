package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
			if (!listeFinale.contains(elt)) {
				for (int j = 0; j < Collections.frequency(listeInitiale, elt); j++) {
					listeFinale.add(elt);
				}
			}
		}
		return listeFinale;
	}
	
	public static <T> boolean verifierRassemblement(List<T> liste){
		ListIterator<T> itListe = liste.listIterator();
		if(itListe.hasNext()) {
			T elt = itListe.next();
			if (itListe.hasNext()) {
				T next = itListe.next();
				for (; itListe.hasNext(); ){
					for(; next == elt && itListe.hasNext();) {
						next = itListe.next();
					}
						
					for ( ListIterator<T> itFin = liste.listIterator(liste.size()); itFin.previousIndex() != itListe.previousIndex();) {
						if (itFin.previous().equals(elt)) {
							return false;
						}
					}
					elt = next;
				}
			}
			
		}
		return true;	
	}
	
}



























