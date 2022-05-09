package Model;

import java.io.Serializable;
import java.util.Scanner;

public class DungeonAdventure implements Serializable {
        static Dungeon myDungeon;
        static Hero myHero;

        public static Dungeon getDungeon(){
                return myDungeon;
        }

        public static void main(String[] args) {
                System.out.println("Working");
                try {
                        Intro();
                } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Ooops, game has an issue in main: " + e.getMessage());
                }
        }
        public static void Intro () throws Exception {
                System.out.println("Welcome to the game!");
                System.out.println("This is dungeon adventure game!");
                System.out.println("Press 1) Start the game");
                System.out.println("Press 2) Read the instruction of the game");
                System.out.println("Press 3) To exit the game");

                Scanner sc = new Scanner(System.in);
                int myChoice = sc.nextInt();

                switch (myChoice) {
                        case 1:
                                System.out.println("Thanks for choosing to play our game");
                                System.out.println("You can always save the game if you need to run and do some errands");
                                Play();

                        case 2:
                                System.out.println("Game is under construction \n" +
                                        "Instructions will be added soon!");
                                break;
                        case 3:
                                System.out.println("It was nice having you here!");
                }
        }

                public static void Play() throws Exception {
                        //STILL NEED TO DO getCurrentRoom method
                       // Room current = myDungeon.getCurrentRoom();
                }




        }

