package Model;

import java.sql.SQLException;
import java.util.Random;

public class Thief extends Hero {
    public Thief(String theName) throws SQLException {
        super(theName);
    }

    // TODO: Make attack
    @Override
    public int specialAttack() {
        Random myRand = new Random();
        int mySpecialAttack = myRand.nextInt(101);
        if (mySpecialAttack < 40) {
            return myRand.nextInt(getMINIMUM_DAMAGE(), getMyMaximumDamage() + 1) + myRand.nextInt(getMINIMUM_DAMAGE(), getMyMaximumDamage() + 1);
        } else if (mySpecialAttack <= 60) {
            return myRand.nextInt(getMINIMUM_DAMAGE(), getMyMaximumDamage() + 1);
        } else {
            return 0;
        }
    }

    // TODO: Make attack
    @Override
    public int attack() {
        Random myRand = new Random();
        boolean myMissHit = myRand.nextInt(101) > getMyChanceToHit() * 100;
        if (myMissHit) {
            return 0;
        } else {
            return myRand.nextInt(getMINIMUM_DAMAGE(), getMyMaximumDamage() + 1);
        }
    }
}
