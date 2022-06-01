package Controller;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Music {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        playMusic();
    }
    public static void playMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        Scanner myScanner = new Scanner(System.in);
        File myFile = new File("Vandals.wav");
        AudioInputStream myAudioStream = AudioSystem.getAudioInputStream(myFile);
        Clip myClip = AudioSystem.getClip();
        myClip.open(myAudioStream);
        myClip.start();
        System.out.println("You can turn off music pressing 'S' ");

        String myResponse = "";

        while (!myResponse.equals("Q")){
            myResponse = myScanner.next();
            myResponse = myResponse.toUpperCase();
            switch (myResponse){
                case ("S"): myClip.close();
                    break;

                default:
                    System.out.println("Not a valid response");
            }
        }



    }

}
