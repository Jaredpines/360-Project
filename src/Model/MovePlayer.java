package Model;


import Controller.ToScreen;
public class MovePlayer {
    public String move(final String theDirection){
        ToScreen myToScreen = new ToScreen();
        int myPreviousLocationX = myToScreen.getMyMainDungeon().getMyPlayerX();
        int myPreviousLocationY = myToScreen.getMyMainDungeon().getMyPlayerY();
        if(theDirection.equalsIgnoreCase("Up") && myPreviousLocationX-1 >= 0){
            myToScreen.getMyMainDungeon().setMyPlayerX(myPreviousLocationX-1);
        }else if(theDirection.equalsIgnoreCase("Down") && myPreviousLocationX+1 < myToScreen.getMyMainDungeon().getMyMaze().length){
            myToScreen.getMyMainDungeon().setMyPlayerX(myPreviousLocationX+1);
        }else if(theDirection.equalsIgnoreCase("Left") && myPreviousLocationY-1 >= 0){
            myToScreen.getMyMainDungeon().setMyPlayerY(myPreviousLocationY-1);
        }else if(theDirection.equalsIgnoreCase("Right") && myPreviousLocationY+1 < myToScreen.getMyMainDungeon().getMyMaze()[0].length){
            myToScreen.getMyMainDungeon().setMyPlayerY(myPreviousLocationY+1);
        }
        Room[][][] myMaze = myToScreen.getMyMainDungeon().getMyMaze();
        Room temp = myMaze[myPreviousLocationX][myPreviousLocationY][1];
        myMaze[myPreviousLocationX][myPreviousLocationY][1] = myMaze[myToScreen.getMyMainDungeon().getMyPlayerX()][myToScreen.getMyMainDungeon().getMyPlayerY()][1];
        myMaze[myToScreen.getMyMainDungeon().getMyPlayerX()][myToScreen.getMyMainDungeon().getMyPlayerY()][1] = temp;
        myToScreen.getRoom().statusEffect(myMaze[myToScreen.getMyMainDungeon().getMyPlayerX()][myToScreen.getMyMainDungeon().getMyPlayerY()][0].getStatus());
        return myMaze[myToScreen.getMyMainDungeon().getMyPlayerX()][myToScreen.getMyMainDungeon().getMyPlayerY()][0].getStatus();
    }
}
