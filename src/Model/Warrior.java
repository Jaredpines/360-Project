package Model;

import java.sql.SQLException;
import java.util.Random;

/**
 * Class for Warrior
 */
public class Warrior extends Hero {

    /**
     * Constructor for Warrior class
     * @param theName name of Warrior
     * @throws SQLException database exception
     */
    public Warrior(String theName) throws SQLException {
        super(theName);
    }


    /**
     * Perform warrior's special attack. A warrior has 40 percent chance to land their special attack successfully.
     * Otherwise, do no damage. Each successful special damage can cause damage amount from 75 to 175 points.
     * @return the damage to monster caused by the special attack
     */
    @Override
    public int specialAttack() {
        Random myRand = new Random();
        boolean mySpecialAttack = myRand.nextInt(101) < 40;
        if (mySpecialAttack) {
            return myRand.nextInt(75, 175 + 1);
        }
        return 0;
    }


    /**
     * Regular attack of a warrior. The damage amount is from the minimum damage (35) to maximum damage(60), but it
     * also has 20 percent change miss the damage.
     * @return the amount of damage
     */
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
