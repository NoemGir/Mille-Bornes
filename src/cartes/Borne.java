package cartes;

import java.util.List;
import java.util.Set;

import jeu.Joueur;

public class Borne extends Carte {
private int km;

	public Borne(int nombre, int km) {
		super(nombre);
		this.km = km;
	}
	
	

	public int getKm() {
		return km;
	}

	@Override
	public String toString() {
		switch (km) {
		case 25 : return "Borne 25 km";
		case 50 : return "Borne 50 km";
		case 75 : return "Borne 75 km";
		case 100 : return "Borne 100 km";
		case 200 : return "Borne 200 km";
		default : return "";
		}
	}


	@Override
	public boolean equals(Object o) {
		if (o instanceof Borne ) {
			Borne objetBorne = (Borne) o;
			return objetBorne.km == km;
		}
		return false;
	} 

	@Override
	public boolean appliquer(Joueur j) {
		Set<Botte> bottes = j.getBottes();
		List<Limite> limites = j.getPileLimite();
		if (bottes.contains(new Botte(1,this.getType()))) {
			return false;
		}
		List<Bataille> listeBataille = j.getPileBataille();
		listeBataille.add(this);
		return true;
	}

}
