package Model;

import java.sql.SQLException;
import java.util.Random;


/**
 * Class for Thief
 */
public class Thief extends Hero {

    /**
     * Constructor for Thief class
     * @param theName name of Thief
     * @throws SQLException database exception
     */
    public Thief(String theName) throws SQLException {
        super(theName);
    }


    /**
     * Perform thief's special attack. A thief has 40 percent chance to get an extra attack. Another 40 percent
     * chance do a normal attack, and a 20 percent chance to get caught (no damage).
     * @return the damage to monster caused by the special attack
     */
    @Override
    public int specialAttack() {
        Random myRand = new Random();
        int mySpecialAttack = myRand.nextInt(101);
        if (mySpecialAttack < 40) {
            return myRand.nextInt(getMINIMUM_DAMAGE(), getMyMaximumDamage() + 1) + myRand.nextInt(getMINIMUM_DAMAGE(), getMyMaximumDamage() + 1);
        } else if (mySpecialAttack <= 80) {
            return myRand.nextInt(getMINIMUM_DAMAGE(), getMyMaximumDamage() + 1);
        } else {
            return 0;
        }
    }

    /**
     * Regular attack of a thief. The damage amount is randomly generated from the minimum damage (20) to
     * maximum damage (40), but it also has 20 percent change miss the damage.
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
