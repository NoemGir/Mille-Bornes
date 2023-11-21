package cartes;

import java.util.List;
import java.util.Set;

import jeu.Joueur;

public class Borne extends Carte implements Comparable<Borne>{
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
		if(!j.estBloque() && j.getKM()+ km <= 1000 && km <= j.getLimite()){
			j.getCollecBorne().add(this);
			return true;
		}
		return false;
	}



	@Override
	public int compareTo(Borne o) {
		int comparaison = km - o.km;
		if (comparaison == 0) {
			comparaison = 1;
		}
		return comparaison;
	}
}
