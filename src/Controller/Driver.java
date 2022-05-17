package Controller;

import Model.Dungeon;
import Model.Hero;

import java.io.*;
import java.sql.SQLException;
import java.util.Scanner;

import static Model.DungeonAdventure.Play;
import static View.DriverView.chooseHero;
import static View.DriverView.mapMaker;

public class Driver implements Serializable {


    public static void main(String[] args) throws SQLException {
        System.out.println("Working");
        try {
            Intro();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ooops, game has an issue in main: " + e.getMessage());
        }

    }
    public static StringBuilder heroToScreen(String theName) throws SQLException {
        Hero myHero = new Hero(theName);
        StringBuilder stats = new StringBuilder();
        stats.append("hit points: ").append(myHero.getHIT_POINTS()).append("\n");
        stats.append("attack speed: ").append(myHero.getATTACK_SPEED()).append("\n");
        stats.append("chance to hit: ").append(myHero.getCHANCE_TO_HIT()).append("\n");
        stats.append("minimum damage: ").append(myHero.getMINIMUM_DAMAGE()).append("\n");
        stats.append("maximum damage: ").append(myHero.getMAXIMUM_DAMAGE()).append("\n");
        stats.append("chance to block: ").append(myHero.getCHANCE_TO_BLOCK_OR_HEAL()).append("\n");
        return stats;
    }
    public static StringBuilder dungeonToScreen(final int theX, final int theY){
        StringBuilder mySB = new StringBuilder();
        //make Dungeon 3D array
        int myCoordinates = 0;
        Dungeon myDungeon = new Dungeon(theX,theY, myCoordinates);
        String[] mySplit = myDungeon.toString().split(" ");
        for (int i = 0; i < mySplit.length; i++) {
            switch (mySplit[i]) {
                case "entrance" -> mySB.append("i");
                case "exit" -> mySB.append("O");
                case "A" -> mySB.append("A");
                case "E" -> mySB.append("E");
                case "I" -> mySB.append("I");
                case "P" -> mySB.append("P");
                case "Pit" -> mySB.append("X");
                case "HP" -> mySB.append("H");
                case "VP" -> mySB.append("V");
                case "empty" -> mySB.append(" ");
            }
            String[] mySplitLoop = mySplit[i].split("-");
            if(mySplitLoop.length > 1){
                mySB.append("M");
            }
        }
        return mySB;
    }
    public static void Intro () throws Exception {
        System.out.println("Welcome to the game!");
        System.out.println("This is dungeon adventure game!");
        System.out.println("Press 1) Start the game");
        System.out.println("Press 2) Read the instruction of the game");
        System.out.println("Press 3) To exit the game");

        Scanner sc = new Scanner(System.in);
        String myChoice = sc.next();

        switch (myChoice) {

            case "1":
                String art = """ 
          d8888b. db    db d8b   db  d888b  d88888b  .d88b.  d8b   db 
          88  `8D 88    88 888o  88 88' Y8b 88'     .8P  Y8. 888o  88 
          88   88 88    88 88V8o 88 88      88ooooo 88    88 88V8o 88 
          88   88 88    88 88 V8o88 88  ooo 88~~~~~ 88    88 88 V8o88 
          88  .8D 88b  d88 88  V888 88. ~8~ 88.     `8b  d8' 88  V888 
          Y8888D' ~Y8888P' VP   V8P  Y888P  Y88888P  `Y88P'  VP   V8P 
                                                                      
                                                                      
   .d8b.  d8888b. db    db d88888b d8b   db d888888b db    db d8888b. d88888b 
  d8' `8b 88  `8D 88    88 88'     888o  88 `~~88~~' 88    88 88  `8D 88'     
  88ooo88 88   88 Y8    8P 88ooooo 88V8o 88    88    88    88 88oobY' 88ooooo 
  88~~~88 88   88 `8b  d8' 88~~~~~ 88 V8o88    88    88    88 88`8b   88~~~~~ 
  88   88 88  .8D  `8bd8'  88.     88  V888    88    88b  d88 88 `88. 88.     
  YP   YP Y8888D'    YP    Y88888P VP   V8P    YP    ~Y8888P' 88   YD Y88888P 
                                                                              
                                                                              
                       .d888b.  .d88b.  .d888b. .d888b. 
                       VP  `8D .8P  88. VP  `8D VP  `8D 
                          odD' 88  d'88    odD'    odD' 
                        .88'   88 d' 88  .88'    .88'   
                       j88.    `88  d8' j88.    j88.    
                       888888D  `Y88P'  888888D 888888D 
                                                        
                        """;

                for (int i = 0; i < art.length(); i++){
                    System.out.print(art.charAt(i));
                    Thread.sleep(1);
                }


                System.out.println("Thanks for choosing to play our game");
                System.out.println("You can always save the game if you need to run and do some errands");
                System.out.println(chooseHero());
                Play();
                System.out.println("Please enter the size of your dungeon in X Y format.");
                int myX = sc.nextInt();
                int myY = sc.nextInt();
                System.out.println("Type M to see the map");
                myChoice = sc.next();
                if(myChoice.equalsIgnoreCase("M")){
                    System.out.println(mapMaker(myX,myY));
                }

                //HOPEFULLY WHAT WE NEED TO MAKE SERIALIZATION WORK
                FileOutputStream myFileOut = new FileOutputStream("UserInfo.ser");
                ObjectOutputStream myOut = new ObjectOutputStream(myFileOut);
                //This 5 and 5 are just random, still need to figure out what to pass there
                myOut.writeObject(dungeonToScreen(5,5));
                myOut.close();
                myFileOut.close();

                System.out.println("The game info saved");


                //This is deserialization
                Dungeon myDungeon1 = null;

                // Reading the object from a file
                FileInputStream myFileIn = new FileInputStream("UserInfo.ser");
                ObjectInputStream myIn = new ObjectInputStream(myFileIn);

                //TODO Serialization works but Deserialization shows an error
                // (Will ask prof on code review what is wrong)
                /*
                // Method for deserialization of object
                myDungeon1 = (Dungeon) myIn.readObject();

                myIn.close();
                myFileIn.close();

                System.out.println("Object has been deserialized ");
                System.out.println("a = " + myDungeon1.getX());
                System.out.println("b = " + myDungeon1.getY());




                 */


            case "2":
                System.out.println("Game is under construction \n" +
                        "Instructions will be added soon!");
                break;
            case "3":
                System.out.println("It was nice having you here!");
        }
    }
}
