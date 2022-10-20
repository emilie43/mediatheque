package mediatheque.metier;

import sauvegarde.Recordable;
import sauvegarde.SystemeDeSauvegarde;

import java.sql.*;
import java.time.LocalDate;

public class Actif extends Adherent implements Recordable {
    private Entreprise employeur;

    public Actif(String nom, String prenom, String dateNaissance, Entreprise emp) throws Exception {
        super(nom, prenom, dateNaissance);
        setEmployeur(emp);
        // auto abonnement
        SystemeDeSauvegarde.getInstance().addRecordable(this);
    }

    public Entreprise getEmployeur() {
        return employeur;
    }

    public void setEmployeur(Entreprise employeur) {
        this.employeur = employeur;
    }

    public Location louer(Ressource res) {
        System.out.println("location plein tarif " + res + " par "+ this);

        return null;
    }

    @Override
    public boolean save() throws Exception {
     //   System.out.println("sauvegarde de l'actif "+ this + "dans la base de données");
        // charger pilote SGBD en mémoire vive
        Class.forName("org.postgresql.Driver");
        // obtenir une connection
        String url = "jdbc:postgresql://localhost:5432/mediatheque";

        Connection db = DriverManager.getConnection(url, "postgres", "kis");

        // creation d'un statement objet pour lancer les requetes
        Statement stmt = db.createStatement();
        // execution d'une requete
        String requete = "insert into adherent values ('"+getNom()+"','"+getPrenom()+"','"+getDateNaissance().toString()+"');";
        System.out.println(requete);
        Boolean jeu = stmt.execute(requete);

        // fermeture de la connexion
        db.close();
        return true;
    }
}
