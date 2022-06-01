package Controller;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.io.Serializable;

public class DungeonAdventure implements Serializable {
        public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {

                Music myMusic = new Music();
                myMusic.playMusic();

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

