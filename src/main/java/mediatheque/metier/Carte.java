package mediatheque.metier;

public class Carte {
    private Personne proprietaire;
    private String identifiant;

    private static int cpt;

    public Carte(Personne p) {
        setProprietaire(p);
        // la carte en cours de creation est mise dans la poche
        getProprietaire().setCarte(this);
        // auto generation de l'ident
        cpt++;
        setIdentifiant("CART" + cpt);
    }

    public Personne getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Personne proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getIdentifiant() {

        return identifiant;
    }

    private void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }
}
