package mediatheque.metier;

import util.ToolBox;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Adherent extends Personne{

    private LocalDate dateAdhesion;

    public LocalDate getDateAdhesion() {
        return dateAdhesion;
    }

    public void setDateAdhesion(LocalDate dateAdhesion) {
        this.dateAdhesion = dateAdhesion;
    }

    public Adherent(String nom, String prenom, String dateNaissance) throws Exception {
        //appel constructeur parent
        super(nom, prenom, dateNaissance);
    }

    public abstract Location louer(Ressource res);

    public static Adherent getAdherentAleatoire() throws Exception {
        LocalDate dateAleatoire  = ToolBox.getRandomLocalDate(1937,2021);
        String suffixe = dateAleatoire.toString().replace("-","");

        Adherent adh = new Actif("ACT"+suffixe,
                "prenom"+suffixe,
                dateAleatoire.toString(),
                new Entreprise("ent1"));
        return adh;
    }

    public  static ArrayList<Adherent> load() throws Exception {

        ArrayList<Adherent> annuaire = new ArrayList<>();
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
            annuaire.add(retraite);
        }

        // fermeture de la connexion
        db.close();
        return annuaire;
    }
}
