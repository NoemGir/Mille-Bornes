package testsFonctionnels;

import java.util.Iterator;

import cartes.Attaque;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.JeuDeCarte;
import cartes.Parade;
import cartes.Type;
import jeu.Sabot;

public class test {
	public static void main(String[] args) {

		/* TP2 */
		Attaque attaque1 = new Attaque(3, Type.ACCIDENT);
		Attaque attaque2 = new Attaque(7, Type.ACCIDENT);
		Attaque attaque3 = new Attaque(9, Type.FEU);
		Botte botte1 = new Botte(2, Type.ACCIDENT);
		Botte botte2 = new Botte(4, Type.CREVAISON);
		Borne borne1 = new Borne(5, 25);
		Borne borne2 = new Borne(5, 50);
		
		System.out.println("-- Test fonction equals -- \n");
		
		System.out.println("Attaque1 == attaque2 : " + attaque1.equals(attaque2));
		System.out.println("Attaque1 == attaque3 : " + attaque1.equals(attaque3));
		System.out.println("Attaque1 == borne2 : " + attaque1.equals(borne2));
		System.out.println("botte1 == botte2 : " + botte1.equals(botte2));
		System.out.println("borne1 == borne2 : " + borne1.equals(borne2)); 
		
		System.out.println("\n-- Test Classe JeuDeCarte -- \n");
		
		
		JeuDeCarte jeu = new JeuDeCarte();
		
		for (Carte carte : jeu.getListeCartes()) {
			System.out.println(carte.toString());
		}
		
		System.out.println("\nfin\n");
		
		/*	TP1 
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
		} */
	} 

}
