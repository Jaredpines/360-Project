package Model;

import java.io.Serializable;
import java.util.Random;

public class Dungeon implements Serializable {
    private int myPlayerX;
    private int myPlayerY;
    final private int Dungeon_X;
    final private int Dungeon_Y;
    private int myEntExi;
    /**
     * 2D room inside of this class
     */
    private Room[][][] myMaze;
    /**
     * 2D array that holds coordinates
     */

    public Dungeon(final int theDungeon_X, final int theDungeon_Y) {
        myEntExi = 0;
        Dungeon_X = theDungeon_X;
        Dungeon_Y = theDungeon_Y;


        myMaze = new Room[theDungeon_X][theDungeon_Y][2];
        createEntranceExit();
        creatPillars();
        creatItemRooms();

        //TODO Wrong too



    }
    public void createEntranceExit(){
        Random myRand = new Random();
        int myRanNumEntranceX = myRand.nextInt(getDungeon_X());
        int myRanNumEntranceY = myRand.nextInt(getDungeon_Y());
        myMaze[myRanNumEntranceX][myRanNumEntranceY][1] = new Room("player");
        //TODO SHOWS weird coordinates
        myPlayerX = myRanNumEntranceX;
        myPlayerY = myRanNumEntranceY;
        int myRanNumExitX;
        int myRanNumExitY;
        do{
            myRanNumExitX = myRand.nextInt(getDungeon_X());
            myRanNumExitY = myRand.nextInt(getDungeon_Y());
            //it works here
            //System.out.println("ExitCorX " + myRanNumExitX + "ExitCorY " + myRanNumExitY);
        }while (myRanNumEntranceX == myRanNumExitX || myRanNumEntranceY == myRanNumExitY);
        myMaze[myRanNumEntranceX][myRanNumEntranceY][0] = new Room(myEntExi);
        myEntExi++;
        myMaze[myRanNumExitX][myRanNumExitY][0]= new Room(myEntExi);
       // System.out.println("ExitCorX " + myRanNumExitX + "ExitCorY " + myRanNumExitY);
        //System.out.println("corX " + myRanNumEntranceX + "corY " + myRanNumEntranceY);
    }
    public void creatPillars(){
        Random myRand = new Random();
        int myX;
        int myY;
        boolean existenceCheck1 = false;
        boolean existenceCheck2 = false;
        boolean existenceCheck3 = false;
        boolean existenceCheck4 = false;
        while (!existenceCheck1||!existenceCheck2||!existenceCheck3||!existenceCheck4) {
            if (myMaze[myX = myRand.nextInt(getDungeon_X())][myY = myRand.nextInt(getDungeon_Y())][0] == null && !existenceCheck1) {
                myMaze[myX][myY][0] = new Room("pillarA");
                existenceCheck1 = true;
            }
            if (myMaze[myX = myRand.nextInt(getDungeon_X())][myY = myRand.nextInt(getDungeon_Y())][0] == null && !existenceCheck2) {
                myMaze[myX][myY][0] = new Room("pillarE");
                existenceCheck2 = true;
            }
            if (myMaze[myX = myRand.nextInt(getDungeon_X())][myY = myRand.nextInt(getDungeon_Y())][0] == null && !existenceCheck3) {
                myMaze[myX][myY][0] = new Room("pillarI");
                existenceCheck3 = true;
            }
            if (myMaze[myX = myRand.nextInt(getDungeon_X())][myY = myRand.nextInt(getDungeon_Y())][0] == null && !existenceCheck4) {
                myMaze[myX][myY][0] = new Room("pillarP");
                existenceCheck4 = true;
            }
        }
    }
    public void creatItemRooms(){
        for (int i = 0; i < myMaze.length; i++){
            for (int j = 0; j < myMaze[0].length; j++) {
                if(myMaze[i][j][0] == null){
                    myMaze[i][j][0] = new Room("items");
                }
            }
        }
    }
    public int getDungeon_X() {
        return Dungeon_X;
    }

    public int getDungeon_Y() {
        return Dungeon_Y;
    }

    public int getMyPlayerX() {
        return myPlayerX;
    }

    public int getMyPlayerY() {
        return myPlayerY;
    }

    public void setMyPlayerX(int thePlayerX) {
        myPlayerX = thePlayerX;
    }

    public void setMyPlayerY(int thePlayerY) {
        myPlayerY = thePlayerY;
    }

    public Room[][][] getMyMaze() {
        return myMaze;
    }
    public void setMyMaze(Room[][][] theMaze) {
        myMaze = theMaze;
    }

    @Override

    /*
   TODO STILL NEED TO BE FINISHED
     */
    public String toString() {
        StringBuilder mySB = new StringBuilder();
        for (int i = 0; i < myMaze.length; i++){
            for (int j = 0; j < myMaze[i].length; j++) {
                mySB.append(myMaze[i][j][0].getStatus());
                mySB.append(" ");
            }
        }
        return mySB.toString();
    }



}




