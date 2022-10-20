package mediatheque.metier;

import sauvegarde.Recordable;
import sauvegarde.SystemeDeSauvegarde;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Livre  extends Ressource implements Recordable {

    public Livre(String titre) {

        super(titre);
        SystemeDeSauvegarde.getInstance().addRecordable(this);

    }

    @Override
    public boolean save() throws Exception {
        System.out.println("sauvegarde du livre" + this + " dans livre.csv");

        // definir le fichier
        File fichier = new File("C:\\OXYGEN\\java\\livres.csv");

        //creer un outil d'ecriture
        FileWriter writer = new FileWriter( fichier, true);
        BufferedWriter bw = new BufferedWriter( writer);

        // placer dans le fichier
        String chaine = getTitre();
        bw.write(chaine);
        bw.newLine();

        //fermer le fichier
        bw.close();
        return true;
    }
}
