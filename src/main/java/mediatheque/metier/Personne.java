package mediatheque.metier;

import java.time.LocalDate;
import java.time.Period;

public class Personne {
    //propriétés
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private Carte carte;

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }

    //methodes
    public Personne(String nom, String prenom) throws Exception {
        setNom(nom);
        setPrenom(prenom);
        // creation carte + ranger dans la poche de la personne
        setCarte(new Carte (this));
    }

    public Personne(String nom, String prenom, String dateNaissance) throws Exception {
        this(nom,prenom);
        setDateNaissance(LocalDate.parse(dateNaissance));
    }

    public boolean marcher()
    {
        System.out.println(getPrenom() + " "+ getNom() + " marche.");
        return true;
    }

    public String getNom() {
           return nom.toUpperCase();
    }



    public void setNom(String propositionNom) throws Exception {
        if(propositionNom.length() >=3 ){
            nom = propositionNom;
        }
        else{
            throw new Exception("le nom est invalide");

        }

    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public static int getNbAnnees(LocalDate date1,LocalDate date2)
    {
        Period periode  = Period.between(date1, date2);
        return periode.getYears();
    }
    public int getAge()
    {
       //return(Period.between(getDateNaissance(), LocalDate.now()).getYears());
        return getNbAnnees(getDateNaissance(), LocalDate.now());
    }

    public String toString() {
        // le comportement toString n'est pas correcte
        return getPrenom()+ " "+getNom();
    }
}
