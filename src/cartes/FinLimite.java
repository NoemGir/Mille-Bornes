package cartes;

import java.util.List;
import java.util.Set;

import jeu.Joueur;

public class FinLimite extends Limite {

	public FinLimite(int nombre) {
		super(nombre);
	}
	
	@Override
	public String toString() {
		return "Fin de limitation de vitesse";
	}
	
	@Override
	public boolean equals(Object o) {
		return o instanceof FinLimite;
	} 
	
	@Override
	public boolean appliquer(Joueur j) {
		List<Limite> listeLimite = j.getPileLimite();
		Set<Botte> bottes = j.getBottes();
		if(listeLimite.isEmpty()) {
			return false;
		}
		Limite top = listeLimite.get(listeLimite.size()-1);
		if (top.getClass() ==  DebutLimite.class && !bottes.contains(new Botte(1,Type.FEU))) {
			listeLimite.add(this);
			return true;
		}
		return false;
	}
}
