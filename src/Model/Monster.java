package Model;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Random;

/**
 * The class extended from DungeonCharacter class creates a monster
 */
public class Monster extends DungeonCharacter implements Serializable {

    /**
     * Constructor of Monster class
     * @param theName the name of the monster
     * @throws SQLException database errors
     */
    public Monster(String theName) throws SQLException {
        super(theName);
    }

    /**
     * Perform attack of a monster with a randomly generated damage from a range of maximum damage and
     * minimum of damage
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

    /**
     * Generate the healing points of a monster
     * @return the healing points
     */
    public int heal() {
        Random myRand = new Random();
        if (myRand.nextInt(101) < getMyChangesToBlockOrHeal() * 100) {
            return myRand.nextInt(getMINIMUM_HEAL_POINTS(), getMINIMUM_HEAL_POINTS() + 1);
        } else {
            return 0;
        }
    }
}
