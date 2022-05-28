package Controller;

import java.io.Serializable;


public class DungeonAdventure implements Serializable {
        public static void main(String[] args) {
                ToScreen myToScreen = new ToScreen();
                System.out.println("Working");
                try {
                        myToScreen.Intro();
                } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Ooops, game has an issue in main: " + e.getMessage());
                }
        }


        public void Play() throws Exception {
                       //STILL NEED TO DO getCurrentRoom method
                       // Room current = myDungeon.getCurrentRoom();
        }




        }

