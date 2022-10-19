package mediatheque.metier;

public class Etudiant extends Adherent{
    private Universite universite;


    public Etudiant(String nom, String prenom, String dateNaissance, Universite uni) {
        super(nom, prenom, dateNaissance);
        setUniversite(uni);
    }

    public Universite getUniversite() {
        return universite;
    }

    public void setUniversite(Universite universite) {
        this.universite = universite;
    }


    public String toString() {
        return super.toString() + " " + getAge()+" " + getUniversite().getCampus();
    }

    public Location louer(Ressource res) {
        System.out.println("location gratuite de " + res + " par "+ this);
        return null;
    }
}
