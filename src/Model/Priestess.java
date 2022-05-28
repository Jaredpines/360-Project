package Model;

import java.sql.SQLException;
import java.util.Random;

public class Priestess extends Hero{
    public Priestess(String theName) throws SQLException {
        super(theName);
    }
    // TODO: Make special attack
    @Override
    public int specialAttack() {
        return 50;
    }

    // TODO: Make attack
    @Override
    public int attack() {
        Random myRand = new Random();
        boolean myMissHit = myRand.nextInt(101) > getMyChanceToHit()*100;
        if (myMissHit) {
            return 0;
        } else {
            return myRand.nextInt(getMINIMUM_DAMAGE(), getMyMaximumDamage()+1);
        }
    }
}
