package mediatheque.tests;

import mediatheque.metier.Adherent;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class testStream {

    public static void main(String[] args) throws Exception {
        // recuperation des adh de la base
        ArrayList<Adherent> annuaire = Adherent.load();

        System.out.println("nombre adherents "+annuaire.size());

        //Afficher le nbre d'adh en utilisant un stream
        long nbTotal = annuaire.stream().count();
        System.out.println(nbTotal);
        // afficher le nbre adh nés en 1985

        Predicate<Adherent> predicat1 = unAdherent-> unAdherent.getDateNaissance().getYear()==1985;

        long nbNes1985 = annuaire.stream().filter(predicat1).count();
        System.out.println(nbNes1985 + " sont nés en 1985");

        //afficher l'adh le plus agé
        Comparator <Adherent> comparator1 = new Comparator<Adherent>() {
            @Override
            public int compare(Adherent adh1, Adherent adh2) {
                if(adh1.getDateNaissance().isBefore(adh2.getDateNaissance())) return 1;
                if(adh2.getDateNaissance().isBefore(adh1.getDateNaissance())) return -1;
                return 0;
            }
        };


        Optional<Adherent> optional1 = annuaire.stream().max(comparator1);
        System.out.println("L'adh le plus agé est "+ optional1.get());

        // afficher tous les adh nes en 1985 par ordre de date naissance
      //  annuaire.stream().filter(predicat1).sorted(comparator1.reversed()).forEach(adh -> System.out.println(adh));

        // limite à 15
        annuaire.stream()
                .filter(predicat1)
                .sorted(comparator1.reversed())
                .limit(15)
                .forEach(adh -> System.out.println(adh));
        // un adh né  en 8/5/45
        Predicate<Adherent> predicat2 = unAdherent-> unAdherent.getDateNaissance().isEqual(LocalDate.parse("1985-01-31"));

        Optional<Adherent> optional2 = annuaire.stream().filter(predicat2).findFirst();

     //   System.out.println(annuaire.stream().filter(predicat2).findFirst());
        
        if (optional2.isPresent()) {
            System.out.println(" ttt " + optional2.get());
        }
        else
            System.out.println("pas d'adh");

    }
}