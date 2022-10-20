package mediatheque.tests;

import util.ToolBox;

import java.time.LocalTime;
import java.time.Year;

public class TestSyntaxe {

     /**
     * ligne doc sur la methode
     */
    public static void saluer()
    {
        System.out.println("Bonjour");
        System.out.println("il est " + LocalTime.now());
    }

    /**
     * doc methode
     * @param rayon
     * @return
     */
    public static double calculerPerimetreCercle(double rayon)
    {
        return 2*Math.PI*rayon;

    }

    public static void saluer(String nom, int genre)
    {
        if(genre == 1 ) System.out.println("Bonjour Monsieur " + nom);
        else System.out.println("Bonjour Madame "+ nom);

    }
    public static void main(String[] args) {

        //Déclaration et valorisation d'une variable
        int compteur;

        compteur = 20;
        System.out.println("Le compteur vaut:" + compteur);

        //Declaration et valorisation d'une constante
        final boolean SUCCES = true;

        //realisation d'un test
        // Utilisation d'operateurs de comparaison
        if(compteur >= 100 && SUCCES == true)
        {
            System.out.println("Le compteur a une valeur importante");
        }
        else
        {
            System.out.println("Le compteur est faible");
        }

        for(int i = 1 ; i<=10; i++){
            // on ignore
            if(i ==5) continue;
            System.out.println(i +"x7=" + i*7);
        }
        //afficher les 4 premières années bissextiles aprés 1857
        Year annee = Year.of(1857);
        int nbAnneesBissextilesTrouvees = 0;

        while(nbAnneesBissextilesTrouvees < 4 )
        {
            if(annee.isLeap())
            {
                System.out.println( annee);
                nbAnneesBissextilesTrouvees++;
            }
            annee= annee.plusYears(1);
        }
        // on ne connait pas à l'avance le nombre d'itérations
        double valeur= 1234567.0;
        do {
            System.out.println(valeur);
            valeur = valeur / Math.PI;
        }
        while(valeur >= 3);

        //Traitement au cas par cas
        // Afficher le nbre de jour d'un mois
        int moisCourant = 10;
        switch ( moisCourant)
        {
            case 1:
                System.out.println("31 jours");
                break;
            case 4:
                System.out.println("30 jours");
                break;
            case 10:
                System.out.println("31 jours");
                break;
            default:
                System.out.println("inconnu");
        }

        // Tableaux
        String jourDeLaSemaine[] = {"lundi","mardi","mercredi"};
        System.out.println(jourDeLaSemaine[1]);

        String[] codesPostaux = new String[40000];
        for(int i = 0 ; i<40000; i++) {
            codesPostaux[i] = String.valueOf(10000+i);

            //codesPostaux[i] = i + 10000 + "";
        }
            System.out.println(codesPostaux[1]);

        //matrice
        String[][] annuaire = new String[21][4];
        annuaire[1][3]="2001-01-02";
        annuaire[20][0]="n21";

        System.out.println(annuaire[1][1]);

        // affichage de tous les jours de la semaine
        for (String unJour : jourDeLaSemaine) {
            System.out.println(unJour);
        }

        saluer();

        //calcul perime cercle
        System.out.println(calculerPerimetreCercle(12));

        saluer("ffff",1);
        saluer("rrrr",2);

        // tirer une valeur comprise entre 64 et 227
        System.out.println(ToolBox.getRandomValue(64,227));

        System.out.println(ToolBox.getRandomLocalDate(1937,2022));
    }
}
