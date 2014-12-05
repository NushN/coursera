package coursera;
/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
class Piece {
    private String nom = "";
    public Piece (String nom) { this.nom = nom; }
    public String getNom() { return this.nom; }
    public String toString () { return this.nom; }
    
}

class Composant {
    private int num = 0;
    private Piece p = null;
    public Composant (Piece p, int num){
	this.num = num;
	this.p = p;
    }
    public Piece getPiece() { return this.p; }
    public int getQuantite() { return this.num; }
}

class Simple {
    private String nameSimple = "";
    private String orientation = "aucune";

    public Simple (String nameSimple, String orientation){
	this.nameSimple = nameSimple;
	this.orientation = orientation;
    }
    public Simple (String nameSimple){
	this.nameSimple = nameSimple;
    }
    
    public String getOrientation() { return this.orientation; }
    public String toString() {
	String res = this.nameSimple;
	if (!this.orientation.equals("aucune")) { res += " " + this.orientation; }
	return res;
    }
}

class Composee{
	
}
/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
/*******************************************
 * Ce qui suit est propose' pour vous aider
 * dans vos tests, mais votre programme sera
 * teste' avec d'autres donnees.
 *******************************************/

class Lego {

    public static void main(String[] args) {
        // declare un jeu de construction de 10 pieces
        Construction maison = new Construction(10);

        // ce jeu a pour premier composant: 59 briques standard
        // une brique standard a par defaut "aucune" comme orientation
        maison.ajouterComposant(new Simple("brique standard"), 59);

        // declare une piece dont le nom est "porte", composee de 2 autres pieces
        Composee porte = new Composee("porte", 2);

        // cette piece composee est constituee de deux pieces simples:
        // un cadran de porte orient'e a gauche
        // un battant orient'e a gauche
        porte.construire(new Simple("cadran porte", "gauche"));
        porte.construire(new Simple("battant", "gauche"));

        // le jeu a pour second composant: 1 porte
        maison.ajouterComposant(porte, 1);

        // déclare une piece composee de 3 autres pieces dont le nom est "fenetre"
        Composee fenetre = new Composee("fenetre", 3);

        // cette piece composee est constitu'ee des trois pieces simples:
        // un cadran de fenetre (aucune orientation)
        // un volet orient'e a gauche
        // un volet orient'e a droite
        fenetre.construire(new Simple("cadran fenetre"));
        fenetre.construire(new Simple("volet", "gauche"));
        fenetre.construire(new Simple("volet", "droit"));

        // le jeu a pour troisieme composant: 2 fenetres
        maison.ajouterComposant(fenetre, 2);

        // affiche tous les composants composants (nom de la piece et quantit'e)
        // pour les pieces compos'ees : affiche aussi chaque piece les constituant
        System.out.println("Affichage du jeu de construction : ");
        System.out.println(maison);
    }
}
