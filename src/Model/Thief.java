package Model;

import java.sql.SQLException;
import java.util.Random;

public class Thief extends Hero{
    public Thief(String theName) throws SQLException {
        super(theName);
    }

    @Override
    int specialAttack() {
        return 0;
    }
    // TODO: Make attack
    @Override
    int specialAttack(int theMin, int theMax) {
        Random myRand = new Random();
        int mySpecialAttack = myRand.nextInt(101);
        if (mySpecialAttack < 40) {
            return myRand.nextInt(theMin, theMax+1) + myRand.nextInt(theMin, theMax+1);
        }else if(mySpecialAttack <= 60){
            return  myRand.nextInt(theMin, theMax+1);
        }else{
            return 0;
        }
    }

    // TODO: Make attack
    @Override
    public int attack(int theMin, int theMax) {
        Random myRand = new Random();
        boolean myMissHit = myRand.nextInt(101) > getMyChanceToHit()*100;
        if (myMissHit) {
            return 0;
        } else {
            return myRand.nextInt(theMin, theMax+1);
        }
    }
}
