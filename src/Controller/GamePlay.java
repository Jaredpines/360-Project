package Controller;

import Model.Monster;
import Model.MovePlayer;
import View.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class GamePlay {
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static View VIEW = new View();
    private ToScreen myToScreen = new ToScreen();
    private final MovePlayer MOVE_PLAYER = new MovePlayer();
    private String myChoice = "";
    private boolean myPillar1 = false;
    private boolean myPillar2 = false;
    private boolean myPillar3 = false;
    private boolean myPillar4 = false;
    private int myPillarCount;
    public void Game(Art ART) throws SQLException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        int myX = SCANNER.nextInt();
        int myY = SCANNER.nextInt();
        Random myRand = new Random();
        System.out.println(VIEW.potionsToScreen(myToScreen.getMyHero().getMyHPTotal(), myToScreen.getMyHero().getMyVPTotal()));
        System.out.println(VIEW.roomMap(myX,myY));
        while (!myChoice.equalsIgnoreCase("Stop")) {
            System.out.println("Type Left, Right, Up, or Down to move.");
            if(myToScreen.getMyHero().getMyHPTotal()>0 || myToScreen.getMyHero().getMyVPTotal()>0){
                System.out.println("Type HP or VP to use potions");
            }
            myChoice = SCANNER.next();
            if(myChoice.equalsIgnoreCase("m")){
                System.out.println(VIEW.mapMaker(myX,myY));
            }else if(myChoice.equalsIgnoreCase("HP") && myToScreen.getMyHero().getMyHPTotal()>0) {
                myToScreen.getMyHero().setMyHPTotal(myToScreen.getMyHero().getMyHPTotal()-1);
                int myRandHP = myRand.nextInt(11) + 5;
                myToScreen.getMyHero().setMyHitPoint(myToScreen.getMyHero().getMyHitPoints() + myRandHP);
                System.out.println(VIEW.roomMap(myX,myY));
            }else if(myChoice.equalsIgnoreCase("VP") && myToScreen.getMyHero().getMyVPTotal()>0){
                myToScreen.getMyHero().setMyVPTotal(myToScreen.getMyHero().getMyVPTotal()-1);
                myToScreen.setMyVPUsed(true);
                System.out.println(VIEW.roomMap(myX,myY));
            }else if(myChoice.equalsIgnoreCase("left")||myChoice.equalsIgnoreCase("right")||myChoice.equalsIgnoreCase("up")||myChoice.equalsIgnoreCase("down")) {
                MOVE_PLAYER.move(myChoice);
                System.out.println(VIEW.roomMap(myX,myY));
                if(myToScreen.getMyMainDungeon().getMyMaze()[myToScreen.getMyMainDungeon().getMyPlayerX()][myToScreen.getMyMainDungeon().getMyPlayerY()][0].getStatus().equalsIgnoreCase("A")){
                    SpecialBattle();
                    myPillar1 = true;
                    myPillarCount++;
                }else if(myToScreen.getMyMainDungeon().getMyMaze()[myToScreen.getMyMainDungeon().getMyPlayerX()][myToScreen.getMyMainDungeon().getMyPlayerY()][0].getStatus().equalsIgnoreCase("E")){
                    SpecialBattle();
                    myPillar2 = true;
                    myPillarCount++;
                }else if(myToScreen.getMyMainDungeon().getMyMaze()[myToScreen.getMyMainDungeon().getMyPlayerX()][myToScreen.getMyMainDungeon().getMyPlayerY()][0].getStatus().equalsIgnoreCase("I")){
                    SpecialBattle();
                    myPillar3 = true;
                    myPillarCount++;
                }else if(myToScreen.getMyMainDungeon().getMyMaze()[myToScreen.getMyMainDungeon().getMyPlayerX()][myToScreen.getMyMainDungeon().getMyPlayerY()][0].getStatus().equalsIgnoreCase("P")){
                    SpecialBattle();
                    myPillar4 = true;
                    myPillarCount++;
                }else if(myRand.nextInt(101) >75 && !myToScreen.getMyMainDungeon().getMyMaze()[myToScreen.getMyMainDungeon().getMyPlayerX()][myToScreen.getMyMainDungeon().getMyPlayerY()][0].getStatus().equalsIgnoreCase("entrance")
                        && !myToScreen.getMyMainDungeon().getMyMaze()[myToScreen.getMyMainDungeon().getMyPlayerX()][myToScreen.getMyMainDungeon().getMyPlayerY()][0].getStatus().equalsIgnoreCase("exit")){
                    RandomMonster(myRand);
                    myToScreen.battleToScreen(myToScreen.getMyMonster(), myToScreen.getMyHero());
                }
            }

            if(myToScreen.getMyMainDungeon().getMyMaze()[myToScreen.getMyMainDungeon().getMyPlayerX()][myToScreen.getMyMainDungeon().getMyPlayerY()][0].getStatus().equalsIgnoreCase("Pit")){
                System.out.println("You fell in a pit and took damage!");
                System.out.println("HP: "+myToScreen.getMyHero().getMyHitPoints());
            }
            if(!myToScreen.getMyMainDungeon().getMyMaze()[myToScreen.getMyMainDungeon().getMyPlayerX()][myToScreen.getMyMainDungeon().getMyPlayerY()][0].getStatus().equalsIgnoreCase("entrance")
                    && !myToScreen.getMyMainDungeon().getMyMaze()[myToScreen.getMyMainDungeon().getMyPlayerX()][myToScreen.getMyMainDungeon().getMyPlayerY()][0].getStatus().equalsIgnoreCase("exit")) {
                myToScreen.getMyMainDungeon().getMyMaze()[myToScreen.getMyMainDungeon().getMyPlayerX()][myToScreen.getMyMainDungeon().getMyPlayerY()][0].setStatus("empty");
            }else if(myToScreen.getMyMainDungeon().getMyMaze()[myToScreen.getMyMainDungeon().getMyPlayerX()][myToScreen.getMyMainDungeon().getMyPlayerY()][0].getStatus().equalsIgnoreCase("exit")
                    && myPillar1 && myPillar2 && myPillar3 && myPillar4){
                System.out.println(ART.YouWinArt());;
                System.exit(0);
            }else if(myToScreen.getMyMainDungeon().getMyMaze()[myToScreen.getMyMainDungeon().getMyPlayerX()][myToScreen.getMyMainDungeon().getMyPlayerY()][0].getStatus().equalsIgnoreCase("exit")){
                System.out.println("You need to collect all the pillars of OO to exit you only have " + myPillarCount + " pillars.");
            }

            System.out.println(VIEW.potionsToScreen(myToScreen.getMyHero().getMyHPTotal(), myToScreen.getMyHero().getMyVPTotal()));
        }
    }
    public void SpecialBattle() throws SQLException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        Random myRand = new Random();
        RandomMonster(myRand);
        int myWhichMonster;
        myToScreen.getMyMonster().setMyHitPoint(myToScreen.getMyMonster().getMyHitPoints() + (myToScreen.getMyMonster().getMyHitPoints()/2));
        myWhichMonster = myRand.nextInt(11);
        final String BLUE = "\u001B[38;5;4m ";
        final String GREEN = "\u001B[38;5;2m ";
        final String RED = "\u001B[38;5;1m ";
        final String YELLOW = "\u001B[38;5;11m ";
        final String PURPLE = "\u001B[38;5;129m ";
        final String VIOLET = "\u001B[38;5;5m ";
        final String ORANGE = "\u001B[38;5;208m ";
        final String BLACK = "\u001B[38;5;0m ";
        final String MAGENTA = "\u001B[38;5;201m ";
        final String CRIMSON = "\u001B[38;2;157;34;53m ";
        final String BACKGROUND = "\u001B[48;5;244m";
        final String RESET = " \u001B[0m";
        switch (myWhichMonster) {
            case 0 -> myToScreen.getMyMonster().setMyName(BLUE+"Blue "+ myToScreen.getMyMonster().getMyName()+RESET);
            case 1 -> myToScreen.getMyMonster().setMyName(GREEN+ "Green "+ myToScreen.getMyMonster().getMyName()+RESET);
            case 2 -> myToScreen.getMyMonster().setMyName(RED + "Red "+ myToScreen.getMyMonster().getMyName() + RESET);
            case 3 -> myToScreen.getMyMonster().setMyName(YELLOW + "Yellow "+ myToScreen.getMyMonster().getMyName() + RESET);
            case 4 -> myToScreen.getMyMonster().setMyName("White "+ myToScreen.getMyMonster().getMyName());
            case 5 -> myToScreen.getMyMonster().setMyName(PURPLE + "Purple "+ myToScreen.getMyMonster().getMyName() + RESET);
            case 6 -> myToScreen.getMyMonster().setMyName(VIOLET + "Violet "+ myToScreen.getMyMonster().getMyName() +RESET);
            case 7 -> myToScreen.getMyMonster().setMyName(ORANGE + "Orange "+ myToScreen.getMyMonster().getMyName() +RESET);
            case 8 -> myToScreen.getMyMonster().setMyName(BACKGROUND+BLACK+"Black "+ myToScreen.getMyMonster().getMyName()+RESET);
            case 9 -> myToScreen.getMyMonster().setMyName(MAGENTA + "Magenta "+ myToScreen.getMyMonster().getMyName() +RESET);
            case 10 -> myToScreen.getMyMonster().setMyName(CRIMSON + "Crimson "+ myToScreen.getMyMonster().getMyName() + RESET);
        }
        myToScreen.battleToScreen(myToScreen.getMyMonster(), myToScreen.getMyHero());
    }

    private void RandomMonster(Random myRand) throws SQLException {
        int myWhichMonster = myRand.nextInt(3);
        switch (myWhichMonster) {
            case 0 -> myToScreen.setMyMonster(new Monster("Ogre"));
            case 1 -> myToScreen.setMyMonster(new Monster("Skeleton"));
            case 2 -> myToScreen.setMyMonster(new Monster("Gremlin"));
        }
    }
}
