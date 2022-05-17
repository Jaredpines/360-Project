package Model;

import java.io.Serializable;
import java.util.Random;

public class Dungeon implements Serializable {
    final private int X;
    final private int Y;
    private int entExi;
    private int myRanNumEntranceX;
    private int myRanNumEntranceY;
    private int myRanNumExitX;
    private int myRanNumExitY;
    private int playerX;
    private int playerY;
    /**
     * 2D room inside of this class
     */
    private Room[][][] myMaze;
    /**
     * 2D array that holds coordinates
     */

    public Dungeon(final int X, final int Y) {
        this.entExi = 0;
        this.X = X;
        this.Y = Y;


        myMaze = new Room[X][Y][2];
        createEntranceExit();
        creatPillars();
        creatItemRooms();

        //TODO Wrong too



    }
    public void createEntranceExit(){
        Random myRand = new Random();
        myRanNumEntranceX = myRand.nextInt(getX());
        myRanNumEntranceY = myRand.nextInt(getY());
        myMaze[myRanNumEntranceX][myRanNumEntranceY][1] = new Room("player");
        //TODO SHOWS weird coordinates
        playerX = (myRanNumEntranceX);
        playerY = (myRanNumEntranceY);
        do{
            myRanNumExitX = myRand.nextInt(getX());
            myRanNumExitY = myRand.nextInt(getY());
            //it works here
            //System.out.println("ExitCorX " + myRanNumExitX + "ExitCorY " + myRanNumExitY);
        }while (myRanNumEntranceX == myRanNumExitX || myRanNumEntranceY == myRanNumExitY);
        myMaze[myRanNumEntranceX][myRanNumEntranceY][0] = new Room(entExi);
        entExi++;
        myMaze[myRanNumExitX][myRanNumExitY][0]= new Room(entExi);
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
            if (myMaze[myX = myRand.nextInt(getX())][myY = myRand.nextInt(getY())][0] == null && !existenceCheck1) {
                myMaze[myX][myY][0] = new Room("pillarA");
                existenceCheck1 = true;
            }
            if (myMaze[myX = myRand.nextInt(getX())][myY = myRand.nextInt(getY())][0] == null && !existenceCheck2) {
                myMaze[myX][myY][0] = new Room("pillarE");
                existenceCheck2 = true;
            }
            if (myMaze[myX = myRand.nextInt(getX())][myY = myRand.nextInt(getY())][0] == null && !existenceCheck3) {
                myMaze[myX][myY][0] = new Room("pillarI");
                existenceCheck3 = true;
            }
            if (myMaze[myX = myRand.nextInt(getX())][myY = myRand.nextInt(getY())][0] == null && !existenceCheck4) {
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
    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }


    public Room[][][] getMyMaze() {
        return myMaze;
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




