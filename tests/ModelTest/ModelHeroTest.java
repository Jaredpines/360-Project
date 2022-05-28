package ModelTest;
import Model.Priestess;
import Model.Thief;
import Model.Warrior;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class ModelHeroTest {
    @Test
    void canGatherStatsWarrior() throws SQLException {
        Warrior myWarrior = new Warrior("Warrior");
        assertEquals(125, myWarrior.getMyHitPoint());
        assertEquals(4, myWarrior.getMyAttackSpeed());
        assertEquals(0.8, myWarrior.getMyChanceToHit());
        assertEquals(35, myWarrior.getMINIMUM_DAMAGE());
        assertEquals(60, myWarrior.getMyMaximumDamage());
        assertEquals(0.2, myWarrior.getMyChangesToBlockOrHeal());
    }
    @Test
    void canGatherStatsPriestess() throws SQLException {
        Priestess myPriestess = new Priestess("Priestess");
        assertEquals(75, myPriestess.getMyHitPoint());
        assertEquals(5, myPriestess.getMyAttackSpeed());
        assertEquals(0.7, myPriestess.getMyChanceToHit());
        assertEquals(25, myPriestess.getMINIMUM_DAMAGE());
        assertEquals(45, myPriestess.getMyMaximumDamage());
        assertEquals(0.3, myPriestess.getMyChangesToBlockOrHeal());
    }
    @Test
    void canGatherStatsThief() throws SQLException {
        Thief myThief = new Thief("Thief");
        assertEquals(75, myThief.getMyHitPoint());
        assertEquals(6, myThief.getMyAttackSpeed());
        assertEquals(0.8, myThief.getMyChanceToHit());
        assertEquals(20, myThief.getMINIMUM_DAMAGE());
        assertEquals(40, myThief.getMyMaximumDamage());
        assertEquals(0.4, myThief.getMyChangesToBlockOrHeal());
    }
}
