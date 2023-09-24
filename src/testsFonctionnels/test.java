package testsFonctionnels;

import java.util.Iterator;

import cartes.Attaque;
import cartes.Botte;
import cartes.Carte;
import cartes.Parade;
import cartes.Type;
import jeu.Sabot;

public class test {
	public static void main(String[] args) {
		Attaque attaque = new Attaque(3, Type.ACCIDENT);
		Parade parade = new Parade(3, Type.ACCIDENT);
		Botte botte = new Botte(1, Type.ACCIDENT);
		Sabot<Carte> sabot = new Sabot<>(7, new Carte[7]);
		sabot.ajouterFamilleCarte( attaque, parade, botte );
		
		System.out.println(" Utilisation de la fonction piocher : \n");
		
		for(int i = 0; i < 7; i++) {
			sabot.piocher();
		}
		
		System.out.println("\n Utilisation de l'itérateur et remove : \n");
		
		sabot.ajouterFamilleCarte( attaque, parade, botte );
		Iterator<Carte> it = sabot.iterator();
		Carte[] pioche = sabot.getPioche();
		
		for(int i = 0; i < 7; i++) {
			Carte next = it.next();
			it.remove();
			System.out.println("Je pioche " + next.toString());	
		}
		
		System.out.println("\n Ajout appel a piocher et carte : \n");

		sabot.ajouterFamilleCarte( attaque, parade, botte );
		it = sabot.iterator();
		pioche = sabot.getPioche();
		
		for(int i = 0; i < 7; i++) {
			Carte next = it.next();
			it.remove();
			System.out.println("Je pioche " + next.toString());	
			sabot.piocher();
			sabot.ajouterFamilleCarte(botte);
		}
	}

}
