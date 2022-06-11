package Controller;

import java.util.Scanner;

/**
 * The class creates the intro text box
 */
public class Intro {

    private final Music MUSIC = new Music();
    private boolean myMusicON = false;

    /**
     * Intro of the game
     * @return player's options
     * @throws Exception errors
     */
    public String IntroChoice() throws Exception {
        if (!myMusicON) {
            MUSIC.playMusic();
            myMusicON = true;
        }
        final String BOX = "\u001B[51m";
        final String RESET = "\u001B[0m";
        System.out.println(BOX + " Welcome to the game!");
        System.out.println(" This is dungeon adventure game!");
        System.out.println(" Press 1) Start the game");
        System.out.println(" Press 2) Read the instruction of the game ");
        System.out.println(" Press 3) To exit the game                 " + RESET);
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }
}
