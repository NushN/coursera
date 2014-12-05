import java.util.ArrayList;

class Timbre {

    public static final int ANNEE_COURANTE = 2014;
    public static final int VALEUR_TIMBRE_DEFAUT = 1;
    public static final String PAYS_DEFAUT = "Suisse";
    public static final String CODE_DEFAUT = "lambda";

    public static final int BASE_1_EXEMPLAIRES = 100;
    public static final int BASE_2_EXEMPLAIRES = 1000;
    public static final double PRIX_BASE_1 = 600;
    public static final double PRIX_BASE_2 = 400;
    public static final double PRIX_BASE_3 = 50;

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
    protected String code = CODE_DEFAUT ;
    protected int issueYear = ANNEE_COURANTE; // année d'émission
    protected String countryOfOrigin = PAYS_DEFAUT ; // pays d'origine
    protected double denominationValue =  VALEUR_TIMBRE_DEFAUT; // valeur faciale
    
    public Timbre (String code, int issueYear, String countryOfOrigin, double denominationValue){
	this.code = code;
	this.issueYear = issueYear;
	this.countryOfOrigin = countryOfOrigin;
	this.denominationValue = denominationValue;
    }
    
    public Timbre (String code, int issueYear, String countryOfOrigin){
	this.code = code;
	this.issueYear = issueYear;
	this.countryOfOrigin = countryOfOrigin;
    }
    
    public Timbre (String code, int issueYear){
	this.code = code;
	this.issueYear = issueYear;
    }

    public Timbre (String code){
	this.code = code;
    }    

    public Timbre (){}
    
    public double vente (){
	int age = age();
	if (age < 5 ) { return denominationValue; }
	else {
	   return denominationValue*age*2.5;
	}
    }
    
    public String toString () {
	return "Timbre de code " + this.code
		+ " datant de " + this.issueYear 
		+ " (provenance " + this.countryOfOrigin 
		+ ") ayant pour valeur faciale " + this.denominationValue
		+ " francs";
    }
    
    public int    age ()             { return ANNEE_COURANTE - issueYear; }
    public String getCode()          { return this.code;                  }
    public int    getAnnee()         { return this.issueYear;             }
    public String getPays()          { return this.countryOfOrigin;       } 
    public double getValeurFaciale() { return this.denominationValue;     }
}

class Rare extends Timbre {
    private int num = 0;
    
    public Rare (String code, int issueYear, String countryOfOrigin, double denominationValue, int num){
	super(code, issueYear, countryOfOrigin, denominationValue);
	this.num = num;
    }
    
    public Rare (String code, int issueYear, String countryOfOrigin, int num){
	super(code, issueYear, countryOfOrigin);
	this.num = num;
    }
    
    public Rare (String code, int issueYear, int num){
	super(code, issueYear);
	this.num = num;
    }

    public Rare (String code, int num){
	super(code);
	this.num = num;
    }    

    public Rare ( int num ){
	super();
	this.num = num; 
    }
    
    public double vente (){
	double prix = 0;
	if (num < 100 ) { prix = PRIX_BASE_1; }
	else if (num > 100 && num < 1000 ) { prix = PRIX_BASE_2; }
	else { prix = PRIX_BASE_3; }
	return prix*(this.age()/10.);
    }
    
    public int getExemplaires () { return this.num; }
    
    public String toString () {
	return super.toString()
		+ "\nNombre d'exemplaires -> " + this.num;
    }
}

class Commemoratif extends Timbre {
    
    public Commemoratif (String code, int issueYear, String countryOfOrigin, double denominationValue){
	super(code, issueYear, countryOfOrigin, denominationValue);
    }
    
    public Commemoratif (String code, int issueYear, String countryOfOrigin){
	super(code, issueYear, countryOfOrigin);
    }
    
    public Commemoratif (String code, int issueYear){
	super(code, issueYear);
    }

    public Commemoratif (String code){
	super(code);
    }    

    public Commemoratif (){
	super();
    }
    
    public double vente (){
	return super.vente()*2;
    }
    
    public String toString () {
	return super.toString()
		+ "\nTimbre celebrant un evenement";
    }
}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/

class Philatelie {

    public static void main(String[] args) {

        // ordre des parametres: nom, annee d'emission, pays, valeur faciale,
        // nombre d'exemplaires
        Rare t1 = new Rare("Guarana-4574", 1960, "Mexique", 0.2, 98);

        // ordre des parametres: nom, annee d'emission, pays, valeur faciale
        Commemoratif t2 = new Commemoratif("700eme-501", 2002, "Suisse", 1.5);
        Timbre t3 = new Timbre("Setchuan-302", 2004, "Chine", 0.2);

        Rare t4 = new Rare("Yoddle-201", 1916, "Suisse", 0.8, 3);


        ArrayList<Timbre> collection = new ArrayList<Timbre>();

        collection.add(t1);
        collection.add(t2);
        collection.add(t3);
        collection.add(t4);

        for (Timbre timbre : collection) {
            System.out.println(timbre);
            System.out.println("Prix vente : " + timbre.vente() + " francs");
            System.out.println();
        }
    }
}

