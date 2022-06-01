package Controller;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Music {
    public void playMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        Scanner myScanner = new Scanner(System.in);
        File myFile = new File("Vandals.wav");
        AudioInputStream myAudioStream = AudioSystem.getAudioInputStream(myFile);
        Clip myClip = AudioSystem.getClip();
        myClip.open(myAudioStream);
        myClip.loop(100);
        System.out.println("You can turn off music pressing 'S' ");
        System.out.println("Q to exit menu and start game");

        String myResponse = "";

        while (!myResponse.equals("Q")){
            myResponse = myScanner.next();
            myResponse = myResponse.toUpperCase();
            switch (myResponse){
                case ("S"): myClip.close();
                case ("Q"): break;

                default:
                    System.out.println("Not a valid response");
            }

        }



    }

}
