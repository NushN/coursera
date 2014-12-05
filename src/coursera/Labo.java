class Souris {

    public static final int ESPERANCE_VIE_DEFAUT = 36;

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
    private int poids;
    private int age;
    private String couleur;
    private int esperanceVie = ESPERANCE_VIE_DEFAUT;
    private boolean clonee;
    public Souris (int weight, String color){
    	poids = weight;
    	couleur = color;
    	age = 0;
    	System.out.println("Une nouvelle souris !");
    }
    
    public Souris (int weight, String color, int a){
    	poids = weight;
    	couleur = color;
    	age = a;
    	System.out.println("Une nouvelle souris !");
    }
    
    public Souris (int weight, String color, int a, int exp){
    	poids = weight;
    	couleur = color;
    	age = a;
    	esperanceVie = exp;
    	System.out.println("Une nouvelle souris !");
    }
    
    public Souris (Souris yaSouris){
    	poids = yaSouris.poids;
    	couleur = yaSouris.couleur;
    	age = yaSouris.age;
    	esperanceVie = (int)((yaSouris.esperanceVie) * (0.8));
    	clonee = true;
    	System.out.println("Clonage d'une souris !");
    }
    
    public String toString(){
    	String str = "Une souris " + couleur;
    	if (clonee) { str += ", clonee,"; }
    	str += " de " + age + " mois et pesant " + poids 
    			+ " grammes";
    	return str;
    }
    
    public void vieillir (){
    	age++;
    	if (clonee) { 
    		couleur = "verte";
    	}
    }
    
    public void evolue(){
    	while ( age < esperanceVie){
    		vieillir();
    	}
    }
}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/

public class Labo {

    public static void main(String[] args) {
        Souris s1 = new Souris(50, "blanche", 2);
        Souris s2 = new Souris(45, "grise");
        Souris s3 = new Souris(s2);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        s1.evolue();
        s2.evolue();
        s3.evolue();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
