package mediatheque.metier;

public class Universite {
    private String campus;

    public Universite(String nom) {
        this.campus = nom;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }
}
