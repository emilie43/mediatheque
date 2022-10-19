package mediatheque.metier;

public class Ressource {
    public String titre;

    public Ressource(String titre) {
        setTitre(titre);
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }


    public String toString() {
        return titre ;
    }
}
