package Model;

import java.sql.SQLException;
import java.util.Random;

/**
 * Class of Priestess
 */
public class Priestess extends Hero {

    /**
     * Constructor for Priestess class
     * @param theName name of Priestess
     * @throws SQLException database exception
     */
    public Priestess(String theName) throws SQLException {
        super(theName);
    }


    /**
     * Special attack of a priestess is healing. It heals health points by 50.
     * @return 50 heal points
     */
    @Override
    public int specialAttack() {
        return 50;
    }


    /**
     * Regular attack of a priestess. The damage amount is randomly generated from the minimum damage (25) to
     * maximum damage(45), but it also has 30 percent change miss the damage.
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
