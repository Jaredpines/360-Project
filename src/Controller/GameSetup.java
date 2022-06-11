package Controller;

import View.Art;
import View.View;

import java.sql.SQLException;


/**
 * Set up the game
 */
public class GameSetup {

    /**
     * Set up the game and start the thread
     * @param theArt the ascii display
     * @throws InterruptedException interrupted exception
     * @throws SQLException databased exception
     */
    public void Setup(Art theArt) throws InterruptedException, SQLException {
        String myStart = theArt.StartScreenArt();

        for (int i = 0; i < myStart.length(); i++) {
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
