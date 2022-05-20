package ModelTest;
import Model.Hero;
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
        assertEquals(125, myWarrior.getHIT_POINTS());
        assertEquals(4, myWarrior.getATTACK_SPEED());
        assertEquals(0.8, myWarrior.getCHANCE_TO_HIT());
        assertEquals(35, myWarrior.getMINIMUM_DAMAGE());
        assertEquals(60, myWarrior.getMAXIMUM_DAMAGE());
        assertEquals(0.2, myWarrior.getCHANCE_TO_BLOCK_OR_HEAL());
    }
    @Test
    void canGatherStatsPriestess() throws SQLException {
        Priestess myPriestess = new Priestess("Priestess");
        assertEquals(75, myPriestess.getHIT_POINTS());
        assertEquals(5, myPriestess.getATTACK_SPEED());
        assertEquals(0.7, myPriestess.getCHANCE_TO_HIT());
        assertEquals(25, myPriestess.getMINIMUM_DAMAGE());
        assertEquals(45, myPriestess.getMAXIMUM_DAMAGE());
        assertEquals(0.3, myPriestess.getCHANCE_TO_BLOCK_OR_HEAL());
    }
    @Test
    void canGatherStatsThief() throws SQLException {
        Thief myThief = new Thief("Thief");
        assertEquals(75, myThief.getHIT_POINTS());
        assertEquals(6, myThief.getATTACK_SPEED());
        assertEquals(0.8, myThief.getCHANCE_TO_HIT());
        assertEquals(20, myThief.getMINIMUM_DAMAGE());
        assertEquals(40, myThief.getMAXIMUM_DAMAGE());
        assertEquals(0.4, myThief.getCHANCE_TO_BLOCK_OR_HEAL());
    }
}
