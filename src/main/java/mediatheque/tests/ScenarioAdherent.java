package mediatheque.tests;

import mediatheque.metier.*;
import sauvegarde.SystemeDeSauvegarde;

import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

public class ScenarioAdherent {

    public static void main(String[] args) throws Exception {
        try {
            //creer un adherent
            Adherent adh = new Etudiant("nom1", "Alain", "1988-01-10", new Universite("campus2"));


            //numero de sa carte
            if (adh.getCarte() != null) {
                System.out.println(adh.getCarte().getIdentifiant());
            }

            try {
                // supp la date ==> plantage
               // adh.setDateNaissance(null);
                // jour de sa naissance
                System.out.println(adh.getDateNaissance().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault()));
            } catch (NullPointerException npe) {
                System.out.println("l'adherent n'a pas de date de naissance");
            }
            //louer
            adh.louer(new Ressource("Harry Potter"));

            //etudiant
            Etudiant etu1 = new Etudiant("Dup", "Leo", "2000-01-01", new Universite("campus1"));

            System.out.println(etu1.getUniversite().getCampus());
            // Carte c1 = new Carte(etu1);
            //  etu1.setCarte(c1);
            System.out.println(etu1.getCarte().getIdentifiant());
            etu1.louer(new Ressource("Tintin"));

            System.out.println(etu1);
            //actif
            Entreprise ent1 = new Entreprise("A6");
            Actif ac1 = new Actif("nnnn", "lea", "1979-01-08", ent1);
            System.out.println(ac1.getEmployeur().getRaisonSociale());
            ac1.louer(new Ressource("toto"));
            System.out.println(ac1.getCarte().getIdentifiant());

            // tableau d'adherents
            Adherent[] annuaire = new Adherent[10];
            annuaire[0] = adh;
            annuaire[1] = ac1;
            annuaire[2] = etu1;

            Adherent adherentRang2 = annuaire[2];
            adherentRang2.louer(null);
            System.out.println(((Etudiant) adherentRang2).getUniversite().getCampus());

            System.out.println(adherentRang2.equals(etu1));

            if (adherentRang2.getClass().getSimpleName().equals("Etudiant")) {
                Etudiant etudiantRang2 = (Etudiant) adherentRang2;
                System.out.println(etudiantRang2.getUniversite().getCampus());
            }

            Object[] elements = new Object[10];
            elements[1] = ac1;
            elements[2] = ac1.getEmployeur();

            if (elements[1] instanceof Personne) {
                Personne pers1 = (Personne) elements[1];
                System.out.println(pers1.getNom() + pers1.getPrenom());
            }
            Object obj1 = new Retraite("retraite1", "p2", "1982-02-02");

            //transformer un actif en entreprise
            TransformateurActifEntreprise transfo1 = new TransformateurActifEntreprise();
            Entreprise entreprise = transfo1.transformer(ac1);
            System.out.println(entreprise.getRaisonSociale());

            Adherent adhAleatoire = Adherent.getAdherentAleatoire();
            System.out.println("adherent aleatoire"+adhAleatoire);

            //SystemeDeSauvegarde.getInstance().sauvegarder();

            // creer un objet runnable en utilisant une classe anonyme
            // enregistrer 10000 adh
            Runnable runnable1 = new Runnable() {
                @Override
                public void run() {
                    for(int i=1; i<10000;i++)
                    {
                        try {
                            Actif act = (Actif) Adherent.getAdherentAleatoire();
                            act.save();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                    }
                }
            };
            Thread thread1 = new Thread(runnable1);
            thread1.start();

            // creation d'un adh spec pour Noel
            Adherent adhNoel2022 = new Adherent("abcd","prenom","1999-01-01") {
                @Override
                public Location louer(Ressource res) {
                    System.out.println("Quart du tarif pour "+ this);
                    return null;
                }
            };
            adhNoel2022.louer(null);

             System.out.println("prog terminé");

        } catch (Exception npe) {
            System.out.println( npe.getMessage());

        }
    }
}
