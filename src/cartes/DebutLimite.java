package cartes;

import java.util.List;
import java.util.Set;

import jeu.Joueur;

public class DebutLimite extends Limite {

	public DebutLimite(int nombre) {
		super(nombre);
	}
	
	@Override
	public String toString() {
		return "Debut de limitation de vitesse";
	}
	
	@Override
	public boolean equals(Object o) {
		return o instanceof DebutLimite;
	} 
	
	@Override
	public boolean appliquer(Joueur j) {
		List<Limite> listeLimite = j.getPileLimite();
		Set<Botte> bottes = j.getBottes();
		if(!bottes.contains(new Botte(1,Type.FEU))) {
			if(listeLimite.isEmpty()) {
				listeLimite.add(this);
				return true;
			}
			Limite top = listeLimite.get(listeLimite.size()-1);
			if (top.getClass() == FinLimite.class) {
				listeLimite.add(this);
				return true;
			}
		}
		return false;
	}
}
