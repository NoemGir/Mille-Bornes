package testsFonctionnels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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
import utils.Utils;

public class test {
	public static void main(String[] args) {
		
		
		/* TP3 */
		
		miaou
		
		
		
		
		
		/*
		/* TP2 
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
		
		 Carte[] typesDeCartes = {new Botte(1, Type.FEU), new Botte(1, Type.ESSENCE), new Botte(1, Type.CREVAISON), new Botte(1, Type.ACCIDENT),
				new Attaque(5, Type.FEU), new DebutLimite(4), new Attaque(3, Type.ESSENCE), new Attaque(3, Type.CREVAISON), new Attaque(3, Type.ACCIDENT),
				new Parade(14, Type.FEU), new FinLimite(6), new Parade(6, Type.ESSENCE), new Parade(6, Type.CREVAISON), new Parade(6, Type.ACCIDENT),
				new Borne(10, 25), new Borne(10, 50), new Borne(10, 75), new Borne(12, 100), new Borne(4, 200)};
		
		 JeuDeCarte jeu = new JeuDeCarte(typesDeCartes);
		
		for (Carte carte : jeu.getListeCartes()) {
			System.out.println(carte.toString());
		}
		
		System.out.println("\n-- Test Classe Utils -- \n");
		
		System.out.println("La liste melangee : \n");
		
		List<Carte> listeInitiale = new ArrayList <Carte>(jeu.getListeCartes());
		
		List<Carte> listeMelangee = Utils.melanger(listeInitiale);
		
		for (Carte carte : listeMelangee) {
			System.out.println(carte.toString());
		}
		
		System.out.println("\nLa liste initiale : \n");
		
		for (Carte carte : listeInitiale) {
			System.out.println(carte.toString());
		}
		
		System.out.println("\nLa liste melangee a le meme nombre de cartes : " +  Utils.verifierMelange(listeMelangee, jeu.getListeCartes()) + " \n");
		
        List<Integer> l1 = Arrays.asList();
        List<Integer> l2 = Arrays.asList(1,1,2,1,3);
        List<Integer> l3= Arrays.asList(1,4,3,2);
        List<Integer> l4 = Arrays.asList(1,1,2,3,1);
        
        System.out.println("\n l1 rassemble : \n");
		
		for (Integer i : Utils.rassembler(l1)) {
			System.out.println(i);
		}
		
		 System.out.println("\n l2 rassemble : \n");
			
		for (Integer i : Utils.rassembler(l2)) {
			System.out.println(i);
		}
		
		System.out.println("\n l3 rassemble : \n");
		
		for (Integer i : Utils.rassembler(l3)) {
			System.out.println(i);
		}
		
		System.out.println("\n l4 rassemble : \n");
		
		for (Integer i : Utils.rassembler(l4)) {
			System.out.println(i);
		}

		System.out.println(" test rassemblement l1 : " +  Utils.verifierRassemblement(Utils.rassembler(l1)) + " ");
		System.out.println(" test rassemblement l2 : " +  Utils.verifierRassemblement(Utils.rassembler(l2)) + " ");
		System.out.println(" test rassemblement l3 : " +  Utils.verifierRassemblement(Utils.rassembler(l3)) + " ");
		System.out.println(" test rassemblement l4 : " +  Utils.verifierRassemblement(Utils.rassembler(l4)) + " \n");

		System.out.println(" Verification cartes jeu melange : " + jeu.checkCount());

        
			TP1 
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
