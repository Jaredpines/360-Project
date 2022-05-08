package ModelTest;
import Model.Hero;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class ModelHeroTest {
    @Test
    void canGatherStatsWarrior() throws SQLException {
        Hero myHero = new Hero("Warrior");
        assertEquals(125, myHero.getHIT_POINTS());
        assertEquals(4, myHero.getATTACK_SPEED());
        assertEquals(0.8, myHero.getCHANCE_TO_HIT());
        assertEquals(35, myHero.getMINIMUM_DAMAGE());
        assertEquals(60, myHero.getMAXIMUM_DAMAGE());
        assertEquals(0.2, myHero.getCHANCE_TO_BLOCK_OR_HEAL());
    }
    @Test
    void canGatherStatsPriestess() throws SQLException {
        Hero myHero = new Hero("Priestess");
        assertEquals(75, myHero.getHIT_POINTS());
        assertEquals(5, myHero.getATTACK_SPEED());
        assertEquals(0.7, myHero.getCHANCE_TO_HIT());
        assertEquals(25, myHero.getMINIMUM_DAMAGE());
        assertEquals(45, myHero.getMAXIMUM_DAMAGE());
        assertEquals(0.3, myHero.getCHANCE_TO_BLOCK_OR_HEAL());
    }
    @Test
    void canGatherStatsThief() throws SQLException {
        Hero myHero = new Hero("Thief");
        assertEquals(75, myHero.getHIT_POINTS());
        assertEquals(6, myHero.getATTACK_SPEED());
        assertEquals(0.8, myHero.getCHANCE_TO_HIT());
        assertEquals(20, myHero.getMINIMUM_DAMAGE());
        assertEquals(40, myHero.getMAXIMUM_DAMAGE());
        assertEquals(0.4, myHero.getCHANCE_TO_BLOCK_OR_HEAL());
    }
}
