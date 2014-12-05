import java.util.ArrayList;

class Auteur {

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
	// Completer la classe Auteur ici
    private String name = "";
    private boolean awarded = false;
    public Auteur (String nm, boolean awrd)
    {
	this.name = nm;
	this.awarded = awrd;
    }
    public String  getNom  () { return this.name;    }
    public boolean getPrix () { return this.awarded; }
}

class Oeuvre
{
    // Completer la classe Oeuvre ici
    private String title = "";
    private String language  = "";
    private Auteur autor;
    
    public Oeuvre (String title, Auteur autor, String language){
	if ( language == "" ) { this.language = "francais"; }
	else { this.language = language; }
	this.title = title;
	this.autor = autor;
    }
    
    public Oeuvre (String title, Auteur autor){
	this.language = "francais";
	this.title = title;
	this.autor = autor;
    } 
    
    public String getTitre  (){ return this.title;    }
    public Auteur getAuteur (){ return this.autor;    }
    public String getLangue (){ return this.language; }
    public void afficher (){
	System.out.println(this.title + ", " 
		+ this.autor.getNom() + ", en "
		+ this.language);
    }
    //@Override
    public boolean equals (Oeuvre book) {
	if (this.autor.getNom().equals(book.autor.getNom()) &&
	    this.language.equals(book.language) &&
	    this.title.equals(book.title))
	{
	    return true; 
	}
	else {
	    return false;
	}
	
    }
}

// completer les autres classes ici

class Exemplaire {
    private Oeuvre book;
    public Exemplaire (Oeuvre book){
	this.book = book;
	System.out.println("Nouvel exemplaire -> "
		+ this.book.getTitre() + ", "
		+ this.book.getAuteur().getNom() + ", en "
		+ this.book.getLangue());
    }
    
    public Exemplaire (Exemplaire ex){
	this.book = ex.book;
	System.out.println("Copie d'un exemplaire de ->"
		+ this.book.getTitre() + ", "
		+ this.book.getAuteur().getNom() + ", en "
		+ this.book.getLangue());
    }
    public Oeuvre getOeuvre () {return this.book;} 
    public void afficher () {
	System.out.print("Un exemplaire de "
		+ this.book.getTitre() + ", "
		+ this.book.getAuteur().getNom() + ", en "
		+ this.book.getLangue());
    }
}

class Bibliotheque {
    private String bibName = "";
    private ArrayList <Exemplaire> exemplaires = new ArrayList<Exemplaire>();
    
    public Bibliotheque (String nm) {
	this.bibName = nm;
	System.out.println("La bibliothèque " + this.bibName 
		+ " est ouverte !");
    }
    
    public String getNom () { return this.bibName; }
    public void stocker (Oeuvre book, int n){
	for (int i = 0; i < n; i++){
	    Exemplaire ex = new Exemplaire (book);
	    this.exemplaires.add(ex);
	}
	
    }
    public void stocker (Oeuvre book){
	this.stocker(book, 1);
    }
    
    public ArrayList <Exemplaire> listerExemplaires (String lang){
	ArrayList <Exemplaire> exLang = new ArrayList <Exemplaire>();
	for( int i = 0; i < this.exemplaires.size(); i++){
	    Exemplaire exIn = (Exemplaire) this.exemplaires.get(i);
	    String inLang = exIn.getOeuvre().getLangue();
	    if (lang.equals(inLang)){
		exLang.add(exIn);
	    }
	}
	return exLang;
    }
    
    public ArrayList <Exemplaire> listerExemplaires (){
	//return this.listerExemplaires("francais");
	return this.exemplaires;
    }
    
    public int compterExemplaires ( Oeuvre book ){
	int num = 0;
	for( int i = 0; i < this.exemplaires.size(); i++){
	    Exemplaire exIn = (Exemplaire) this.exemplaires.get(i);
	    Oeuvre bookIn = exIn.getOeuvre();
	    if (bookIn.equals(book)){
		num++;
	    }
	}
	return num;
    }
    
    public void afficherAuteur (boolean aw){
	for( int i = 0; i < this.exemplaires.size(); i++){
	    Exemplaire exIn = (Exemplaire) this.exemplaires.get(i);
	    boolean award = exIn.getOeuvre().getAuteur().getPrix();
	    if (aw == award){
		System.out.println(exIn.getOeuvre().getAuteur().getNom());
	    }
	}
    }
    
    public void afficherAuteur (){
	afficherAuteur (true);
    }
}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
/*******************************************
 * Ce qui suit est propose' pour vous aider
 * dans vos tests, mais votre programme sera
 * teste' avec d'autres donnees.
 *******************************************/

public class Biblio {

    public static void afficherExemplaires(ArrayList<Exemplaire> exemplaires) {
        for (Exemplaire exemplaire : exemplaires) {
            System.out.print("\t");
            exemplaire.afficher();
        }
    }

    public static void main(String[] args) {
        // create and store all the exemplaries
        Auteur a1 = new Auteur("Victor Hugo", false);
        Auteur a2 = new Auteur("Alexandre Dumas", false);
        Auteur a3 = new Auteur("Raymond Queneau", true);

        Oeuvre o1 = new Oeuvre("Les Miserables", a1, "francais");
        Oeuvre o2 = new Oeuvre("L\'Homme qui rit", a1, "francais");
        Oeuvre o3 = new Oeuvre("Le Comte de Monte-Cristo", a2, "francais");
        Oeuvre o4 = new Oeuvre("Zazie dans le metro", a3, "francais");
        Oeuvre o5 = new Oeuvre("The count of Monte-Cristo", a2, "anglais");

        Bibliotheque biblio = new Bibliotheque("municipale");
        biblio.stocker(o1, 2);
        biblio.stocker(o2);
        biblio.stocker(o3, 3);
        biblio.stocker(o4);
        biblio.stocker(o5);

        // ...
        System.out.println("La bibliotheque " + biblio.getNom() + " offre ");
        afficherExemplaires(biblio.listerExemplaires());
        String langue = "anglais";
        System.out.println("Les exemplaires en " + langue + " sont  ");
        afficherExemplaires(biblio.listerExemplaires(langue));
        System.out.println("Les auteurs a succes sont  ");
        biblio.afficherAuteur();
        System.out.print("Il y a " + biblio.compterExemplaires(o3) + " exemplaires");
        System.out.println(" de  " + o3.getTitre());
    }
}

