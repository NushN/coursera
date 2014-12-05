/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/

class Patient {
	private double masse = 0;
	private double hauteur = 0;
	
	public void init (double w, double h){
		this.masse = 0;
		this.hauteur = 0;
		if (w >= 0 && h >= 0){
			this.masse = w;
			this.hauteur = h;
		}
	}
	
	public void afficher (){
		System.out.printf("Patient : %.1f kg pour %.1f m\n",
				this.masse, this.hauteur);
	} 
	public double poids (){
		return this.masse;
	}
	public double taille (){
		return this.hauteur;
	}
	public double imc (){
		if (this.hauteur == 0) 
		{
			return 0;
		}
		return this.masse/Math.pow(this.hauteur, 2);
	}
}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
class Imc {
    public static void main(String[] args) {

        Patient quidam = new Patient();
        quidam.init(74.5, 1.75);
        quidam.afficher();
        System.out.println("IMC : " + quidam.imc());
        quidam.init( -2.0, 4.5);
        quidam.afficher();
    }
}
