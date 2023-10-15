package cartes;

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
}
