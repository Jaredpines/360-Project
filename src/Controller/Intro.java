package Controller;

import java.util.Scanner;

public class Intro {
    private final Music MUSIC = new Music();
    public String IntroChoice() throws Exception {
        MUSIC.playMusic();
        final String BOX = "\u001B[51m";
        final String RESET = "\u001B[0m";
        System.out.println(BOX + " Welcome to the game!" );
        System.out.println(" This is dungeon adventure game!");
        System.out.println(" Press 1) Start the game");
        System.out.println(" Press 2) Read the instruction of the game ");
        System.out.println(" Press 3) To exit the game                 "+ RESET);
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }
}
