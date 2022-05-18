package ModelTest;
import Model.Hero;
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
        //Fix with new class
        /*Hero myHero = new Hero("Priestess");
        assertEquals(75, myHero.getHIT_POINTS());
        assertEquals(5, myHero.getATTACK_SPEED());
        assertEquals(0.7, myHero.getCHANCE_TO_HIT());
        assertEquals(25, myHero.getMINIMUM_DAMAGE());
        assertEquals(45, myHero.getMAXIMUM_DAMAGE());
        assertEquals(0.3, myHero.getCHANCE_TO_BLOCK_OR_HEAL());
         */
    }
    @Test
    void canGatherStatsThief() throws SQLException {
        //Fix with new class
        /*Hero myHero = new Hero("Thief");
        assertEquals(75, myHero.getHIT_POINTS());
        assertEquals(6, myHero.getATTACK_SPEED());
        assertEquals(0.8, myHero.getCHANCE_TO_HIT());
        assertEquals(20, myHero.getMINIMUM_DAMAGE());
        assertEquals(40, myHero.getMAXIMUM_DAMAGE());
        assertEquals(0.4, myHero.getCHANCE_TO_BLOCK_OR_HEAL());
         */
    }
}
