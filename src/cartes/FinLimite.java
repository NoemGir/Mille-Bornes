package cartes;

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
}
