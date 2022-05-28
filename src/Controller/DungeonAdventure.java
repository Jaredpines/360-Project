package Controller;

import java.io.Serializable;

import static Controller.Driver.Intro;

public class DungeonAdventure implements Serializable {
        public static void main(String[] args) {
                System.out.println("Working");
                try {
                        Intro();
                } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Ooops, game has an issue in main: " + e.getMessage());
                }
        }


        public static void Play() throws Exception {
                       //STILL NEED TO DO getCurrentRoom method
                       // Room current = myDungeon.getCurrentRoom();
        }




        }

