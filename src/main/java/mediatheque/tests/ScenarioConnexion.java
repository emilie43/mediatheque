package mediatheque.tests;

import mediatheque.metier.Retraite;

import java.sql.*;
import java.time.LocalDate;

public class ScenarioConnexion {

    public static void main(String[] args) throws Exception {
       // charger pilote SGBD en mémoire vive
        Class.forName("org.postgresql.Driver");
        // obtenir une connection
        String url = "jdbc:postgresql://localhost:5432/mediatheque";

        Connection db = DriverManager.getConnection(url, "postgres", "kis");

        // creation d'un statement objet pour lancer les requetes
        Statement stmt = db.createStatement();
        // execution d'une requete
        String requete = "select * from adherent;";
        ResultSet jeu = stmt.executeQuery(requete);

        while (jeu.next())
        {
            String nom = jeu.getString("nom");
            String prenom = jeu.getString("prenom");
            Date dateNaissanceBDD = jeu.getDate("datenaissance");
            LocalDate dateNaissance = dateNaissanceBDD.toLocalDate();

            Retraite retraite = new Retraite(nom, prenom, dateNaissance.toString());
            System.out.println(retraite);
        }

        // fermeture de la connexion
        db.close();
        stmt.close();
        jeu.close();
    }
}
