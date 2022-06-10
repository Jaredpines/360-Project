package Model;
import Controller.ToScreen;

/**
 * The class that contains the movement of a hero
 */
public class MovePlayer {
    /**
     * Identify the direction to move and updates the new location
     * @param theDirection a string indicates moving direction
     */
    public void move(final String theDirection) {
        ToScreen myToScreen = new ToScreen();
        int myPreviousLocationX = myToScreen.getMyMainDungeon().getMyPlayerX();
        int myPreviousLocationY = myToScreen.getMyMainDungeon().getMyPlayerY();
        if (theDirection.equalsIgnoreCase("Up") && myPreviousLocationX - 1 >= 0) {
            myToScreen.getMyMainDungeon().setMyPlayerX(myPreviousLocationX - 1);
        } else if (theDirection.equalsIgnoreCase("Down") && myPreviousLocationX + 1 < myToScreen.getMyMainDungeon().getMAZE().length) {
            myToScreen.getMyMainDungeon().setMyPlayerX(myPreviousLocationX + 1);
        } else if (theDirection.equalsIgnoreCase("Left") && myPreviousLocationY - 1 >= 0) {
            myToScreen.getMyMainDungeon().setMyPlayerY(myPreviousLocationY - 1);
        } else if (theDirection.equalsIgnoreCase("Right") && myPreviousLocationY + 1 < myToScreen.getMyMainDungeon().getMAZE()[0].length) {
            myToScreen.getMyMainDungeon().setMyPlayerY(myPreviousLocationY + 1);
        }
        Room[][][] myMaze = myToScreen.getMyMainDungeon().getMAZE();
        Room temp = myMaze[myPreviousLocationX][myPreviousLocationY][1];
        myMaze[myPreviousLocationX][myPreviousLocationY][1] = myMaze[myToScreen.getMyMainDungeon().getMyPlayerX()][myToScreen.getMyMainDungeon().getMyPlayerY()][1];
        myMaze[myToScreen.getMyMainDungeon().getMyPlayerX()][myToScreen.getMyMainDungeon().getMyPlayerY()][1] = temp;
        myToScreen.getRoom().statusEffect(myMaze[myToScreen.getMyMainDungeon().getMyPlayerX()][myToScreen.getMyMainDungeon().getMyPlayerY()][0].getStatus());
    }
}
