package Model;

import java.sql.SQLException;
import java.util.Random;

public class Priestess extends Hero{
    public Priestess(String theName) throws SQLException {
        super(theName);
    }
    // TODO: Make special attack
    @Override
    int specialAttack() {
        return 50;
    }

    @Override
    int specialAttack(int theMin, int theMax) {
        return 0;
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
