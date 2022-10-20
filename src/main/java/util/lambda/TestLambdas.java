package util.lambda;

import sauvegarde.Recordable;
import sauvegarde.SystemeDeSauvegarde;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TestLambdas {

    public static void main(String[] args) throws Exception {


        //creation d'un runnable sous forme de classe anonyme
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(LocalTime.now().format(DateTimeFormatter.ISO_TIME));
            }
        };
        // meme run sous forme lambdas
        Runnable runnable2 = () -> System.out.println(LocalTime.now().format(DateTimeFormatter.ISO_TIME));

        Thread thread2 = new Thread(runnable2);
        thread2.start();

        // creer un recordable
        Recordable rec = new Recordable() {
            @Override
            public boolean save() throws Exception {
                System.out.println("Sauvegarde spécifique");
                SystemeDeSauvegarde.getInstance().addRecordable(this);
                return true;
            }
        };
        Recordable rec2 = ()-> {
            System.out.println("Sauvegarde spécifique");
            return true;
        };
        rec2.save();

        // gestionnaire de click avec un bouton
        ActionListener gestionnaire1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("hello world");
            }
        };
        ActionListener gestionnaire2 =  event -> System.out.println("hello world");

        // creation d'une IHM avec un bouton
        JButton bouton = new JButton("cliquer ici");

        JFrame fenetre = new JFrame();
        fenetre.setTitle("essai gestionnaire de clic");
        fenetre.setSize(600,200);
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // gestionnaire d'affichage
        fenetre.setLayout(new FlowLayout(FlowLayout.CENTER));

        fenetre.add(bouton);

        // abonnement d'un gestionnaire de clic
        bouton.addActionListener(gestionnaire2);
        fenetre.setVisible(true);



    }
}
