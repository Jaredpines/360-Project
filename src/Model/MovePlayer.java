package Model;

import static Model.Dungeon.*;
import static Model.Room.statusEffect;

public class MovePlayer {
    public static String move(final String theDirection){
        int myPreviousLocationX = getMyPlayerX();
        int myPreviousLocationY = getMyPlayerY();
        if(theDirection.equalsIgnoreCase("Up") && myPreviousLocationX-1 >= 0){
            setMyPlayerX(myPreviousLocationX-1);
        }else if(theDirection.equalsIgnoreCase("Down") && myPreviousLocationX+1 < getMyMaze().length){
            setMyPlayerX(myPreviousLocationX+1);
        }else if(theDirection.equalsIgnoreCase("Left") && myPreviousLocationY-1 >= 0){
            setMyPlayerY(myPreviousLocationY-1);
        }else if(theDirection.equalsIgnoreCase("Right") && myPreviousLocationY+1 < getMyMaze()[0].length){
            setMyPlayerY(myPreviousLocationY+1);
        }
        Room[][][] myMaze = getMyMaze();
        Room temp = myMaze[myPreviousLocationX][myPreviousLocationY][1];
        myMaze[myPreviousLocationX][myPreviousLocationY][1] = myMaze[getMyPlayerX()][getMyPlayerY()][1];
        myMaze[getMyPlayerX()][getMyPlayerY()][1] = temp;
        statusEffect(myMaze[getMyPlayerX()][getMyPlayerY()][0].getStatus());
        return myMaze[getMyPlayerX()][getMyPlayerY()][0].getStatus();
    }
}
