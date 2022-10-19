package mediatheque.metier;

import java.time.LocalDate;

public class Adherent extends Personne{

    private LocalDate dateAdhesion;

    public LocalDate getDateAdhesion() {
        return dateAdhesion;
    }

    public void setDateAdhesion(LocalDate dateAdhesion) {
        this.dateAdhesion = dateAdhesion;
    }

    public Adherent(String nom, String prenom, String dateNaissance) {
        //appel constructeur parent
        super(nom, prenom, dateNaissance);
    }

    public Location louer(Ressource res)
    {
       // System.out.println("Location de " + res.getTitre() + " par " + this.getNom());
        System.out.println("Location plein tarif de " + res + " par " + this);
        return null;
    }
}
