package mediatheque.tests;

import mediatheque.metier.Actif;
import mediatheque.metier.Entreprise;
import mediatheque.metier.Livre;
import sauvegarde.SystemeDeSauvegarde;

import java.time.LocalDate;

public class ScenarioSauvegarde {
    public static void main(String[] args) throws Exception {

        // creer actif
        LocalDate dateDepart = LocalDate.parse("1983-06-20");
        for( int i = 1 ; i <=5; i++)
        {
                dateDepart = dateDepart.plusMonths(1);
                String dateNaissance = dateDepart.toString();

                Actif actif = new Actif("nomActif"+i, "p"+i,
                        dateNaissance, new Entreprise("a6"));



        }
        // creer livre
        for(int i=1 ; i<=5; i++)
        {
            Livre livre = new Livre( "titreLivre"+i);

        }

        //lancer la sauvegarde
        SystemeDeSauvegarde.getInstance().sauvegarder();
    }
}
