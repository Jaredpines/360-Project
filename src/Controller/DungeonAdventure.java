package Controller;

import java.io.Serializable;

public class DungeonAdventure implements Serializable {
    public static void main(String[] args) {
        ToScreen myToScreen = new ToScreen();


        try {
            myToScreen.Intro();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, game has an issue in main: " + e.getMessage());
        }
    }
}

