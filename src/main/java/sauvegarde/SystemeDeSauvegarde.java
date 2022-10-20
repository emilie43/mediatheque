package sauvegarde;

import java.util.ArrayList;

public class SystemeDeSauvegarde {

    private ArrayList<Recordable> liste;
    private static SystemeDeSauvegarde instance;

    private SystemeDeSauvegarde() {
        // init la liste
        liste = new ArrayList<>();
    }

    public boolean sauvegarder() throws Exception
    {
        // on parcourt la liste des elements enregistrables
        for( Recordable rec: liste)
        {
            rec.save();
        }
        return true;
    }

    public boolean addRecordable ( Recordable recordable)
    {
        return liste.add( recordable);
    }
    public static SystemeDeSauvegarde getInstance()
    {
        // creation sys s'il n'a pas été creer sinon on le renvoie
        if (instance == null)
        {
            instance = new SystemeDeSauvegarde();
        }
        return instance;
    }
}
