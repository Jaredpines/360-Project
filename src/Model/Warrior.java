package Model;

import java.sql.SQLException;
import java.util.Random;

public class Warrior extends Hero {
    public Warrior(String theName) throws SQLException {
        super(theName);
    }

    // TODO: Make attack
    @Override
    public int specialAttack() {
        Random myRand = new Random();
        boolean mySpecialAttack = myRand.nextInt(101) < 40;
        if (mySpecialAttack) {
            return myRand.nextInt(75, 175 + 1);
        }
        return 0;
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
