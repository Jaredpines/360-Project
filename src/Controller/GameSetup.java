package Controller;

import View.*;

import java.sql.SQLException;
import java.util.Scanner;

public class GameSetup {
    public void Setup(Art theArt) throws InterruptedException, SQLException {
        String myStart = theArt.StartScreenArt();

        for (int i = 0; i < myStart.length(); i++){
            System.out.print(myStart.charAt(i));
            Thread.sleep(1);
        }

        Thread.sleep(1000);
        System.out.println("Thanks for choosing to play our game");
        System.out.println("You can always save the game if you need to run and do some errands");

        View myView = new View();
        System.out.println(myView.chooseHero());
        System.out.println("Please enter the size of your dungeon in X Y format.");

    }
}
