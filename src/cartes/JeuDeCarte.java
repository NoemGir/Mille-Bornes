package cartes;

import java.util.ArrayList;
import java.util.List;

import utils.Utils;

public class JeuDeCarte {
	
	 	private Carte[] typesDeCartes;

		private List<Carte> listeCartes;
		
		public JeuDeCarte(Carte[] typesDeCartes) {
		
			this.typesDeCartes = typesDeCartes;
			List<Carte> listeCartesOrdre = new ArrayList<Carte>();
			
			for(int i = 0;  i < typesDeCartes.length; i++) {
				Carte carte = typesDeCartes[i];
				for(int j = 0; j < carte.getNombre(); j++ ) {
					listeCartesOrdre.add(carte);
				}
			}
			listeCartes = new ArrayList<Carte>(Utils.melanger(listeCartesOrdre));
		}

		public Carte[] getTypesDeCartes() {
			return typesDeCartes;
		}
		
		
		
		public List<Carte> getListeCartes() {
			return listeCartes;
		}

		public boolean checkCount(){
			int comptPrioritaire = 0;
			int comptCiterne = 0;
			int comptIncrevable = 0;
			int comptAsVolant = 0;
			int comptFeuRouge = 0;
			int comptFeuVert = 0;
			int comptLimite = 0;
			int comptPanne= 0;
			int comptCrevaison = 0;
			int comptAccident = 0;
			int comptFinLimite = 0;
			int comptEssence = 0;
			int comptRoueSecours = 0;
			int comptReparation = 0;
			int comptBorne25 = 0;
			int comptBorne50 = 0;
			int comptBorne75 = 0;
			int comptBorne100 = 0;
			int comptBorne200 = 0;

			for (Carte carte : listeCartes) {
				if (carte instanceof Attaque) {
					switch( ((Attaque) carte).getType()) {
						case FEU : comptFeuRouge++;
							break;
						case ESSENCE : comptPanne++;
							break;
						case CREVAISON : comptCrevaison++;
							break;
						case ACCIDENT : comptAccident++;
					}
					
				}
				else if (carte instanceof Parade) {
					switch( ((Parade) carte).getType()) {
						case FEU : comptFeuVert++;
							break;
						case ESSENCE : comptEssence++;
							break;
						case CREVAISON : comptRoueSecours++;
							break;
						case ACCIDENT : comptReparation++;
					}
				}
				else if (carte instanceof Botte) {
					switch( ((Botte) carte).getType()) {
						case FEU : comptPrioritaire++;
							break;
						case ESSENCE : comptCiterne++;
							break;
						case CREVAISON : comptIncrevable++;
							break;
						case ACCIDENT : comptAsVolant++;
					}
				}
				else if (carte instanceof DebutLimite) {
					comptLimite++;
				}
				else if (carte instanceof FinLimite) {
					comptFinLimite++;
				}
				else {
					switch( ((Borne) carte).getKm()) {
						case 25 : comptBorne25++;
							break;
						case 50 : comptBorne50++;
							break;
						case 75 : comptBorne75++;
							break;
						case 100 : comptBorne100++;
							break;
						case 200 : comptBorne200++;
							break;
						default : return false;
					}
				}
			}
			return 
			 comptPrioritaire == 1 &&
			 comptCiterne == 1 &&
			 comptIncrevable == 1 &&
			 comptAsVolant == 1 &&
			 comptFeuRouge == 5 &&
			 comptFeuVert == 14 &&
			 comptLimite == 4 &&
			 comptPanne == 3 &&
			 comptCrevaison == 3 &&
			 comptAccident == 3 &&
			 comptFinLimite == 6 &&
			 comptEssence == 6 &&
			 comptRoueSecours == 6 &&
			 comptReparation == 6 &&
			 comptBorne25 == 10 &&
			 comptBorne50 == 10 &&
			 comptBorne75 == 10 &&
			 comptBorne100 == 12 &&
			 comptBorne200 == 4;
		}	
		
}
