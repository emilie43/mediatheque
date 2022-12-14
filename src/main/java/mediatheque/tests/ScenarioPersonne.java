package mediatheque.tests;

import mediatheque.metier.Carte;
import mediatheque.metier.Personne;
import mediatheque.metier.Ressource;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class ScenarioPersonne {
    public static void main(String[] args) {
        try {
            //declarer et instancier une personne
            Personne p1 = new Personne("Durand", "paul");


            p1.marcher();

            // atribuer une identité

            p1.setNom("Dupond");

            p1.setPrenom("Marie");
            p1.setDateNaissance(LocalDate.parse("1985-12-25"));
            p1.marcher();

            Personne p2 = new Personne("martin", "jacques", "1980-06-18");

            System.out.println("date de naissance " + p2.getDateNaissance());

            Ressource r1 = new Ressource("toto");
            System.out.println("ressource 1 " + r1.getTitre());

            boolean erreur;
            do {
                erreur = false;
                try {
                    System.out.println("veuillez saisir la date de l'armistice 1918");
                    Scanner scanner = new Scanner(System.in);
                    String saisie = scanner.nextLine();

                    LocalDate dateArmistice1918 = LocalDate.parse(saisie);
                } catch (DateTimeException dte) {
                    System.out.println("erreur saisie date");
                    erreur = true;
                }
            } while (erreur);

            //     System.out.println(Personne.getNbAnnees(dateArmistice1918, LocalDate.now()));

            System.out.println(p1.getAge() + " ans");
            System.out.println(p2.getAge());

            Carte c1 = new Carte(p1);
            // on met la carte dans la poche de p1
            //p1.setCarte(c1);

            // afficher le mois de naissance du proprietaire de la carte
            System.out.println(c1.getProprietaire().getDateNaissance().getMonth());

            //ident
            System.out.println(c1.getIdentifiant());

            for (int i = 1; i < 100; i++) {
                Carte c = new Carte(p1);
                System.out.println(c.getIdentifiant());
            }
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }
}
