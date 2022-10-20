package util;

import java.time.DateTimeException;
import java.time.LocalDate;

public class ToolBox {

    public static int getRandomValue(int limiteBasse, int limiteHaute)
    {

        if (limiteBasse > limiteHaute)
        {
            int tmp = limiteBasse;
            limiteBasse = limiteHaute;
            limiteHaute = tmp;
        }
        int nbValeursPossibles = limiteHaute-limiteBasse+1;

        int tirageAleatoire = (int) (Math.random()* nbValeursPossibles);
        return tirageAleatoire+limiteBasse;
    }
    public static LocalDate getRandomLocalDate(int anneeBasse, int anneeHaute)
    {
        int jour = getRandomValue(1,31);
        int mois = getRandomValue(1,12);
        int annee = getRandomValue(anneeBasse,anneeHaute);
        LocalDate date;
        try {
             date = LocalDate.of(annee, mois, jour);
        }
        catch (DateTimeException dte)
        {
        date = getRandomLocalDate(anneeBasse,anneeHaute);
        }

return date;
    }
}
