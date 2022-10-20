package util.interfacesFonctionnelles;

import mediatheque.metier.Livre;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestInterfacesFonctionnelles {

    public static void main(String[] args) {
        // creer une fct qui, a partir d'un code postal , renvoie un nom de ville
        Function<String,String> fonction1 = codePostal -> {
            if(codePostal.equals("42000")) return "saint etienne";
            if(codePostal.equals("75000")) return "paris";
            return null;
        };
        // utiliser la fct
        String nomVille = fonction1.apply("42001");
        System.out.println(nomVille);

        String[] tableau = {"69000","42000","13000","59000","75000","79000"};
        List<String> listeCodesPostaux = Arrays.asList(tableau);

        // on soumet la liste à la fct, il faut la transformer en Stream
        Consumer<String> consumer1 = chaine -> {
            if (chaine != null)
            System.out.println(chaine.toUpperCase());
            else
                System.out.println("nom ville inconnu pour le code postal " + chaine);
        };
        listeCodesPostaux.stream().map(fonction1).forEach(consumer1);

        // creer un predicat qui affirme qu'une date correspond à un lundi
        Predicate<LocalDate> predicat1 = uneDateQuelconque -> uneDateQuelconque.getDayOfWeek().equals(DayOfWeek.MONDAY);

        System.out.println(predicat1.test(LocalDate.parse("2022-10-17")));

        // creer un fournisseur de livre
        Supplier<Livre> supplier1 = () ->new Livre("titre livre par défaut");
        Livre unLivre = supplier1.get();
        System.out.println(unLivre);


    }
}
