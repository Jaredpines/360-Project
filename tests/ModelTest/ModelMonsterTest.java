package ModelTest;

import Model.DungeonCharacter;
import Model.Hero;
import Model.Monster;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class ModelMonsterTest {
    @Test
    void canCreateMonsterTest() throws SQLException {

        Monster myMonster = new Monster("Ogre");
        boolean isItAMonster = false;
        isItAMonster = myMonster instanceof DungeonCharacter;
        assertTrue(isItAMonster);
    }
    @Test
    void canGatherStatsOgre() throws SQLException {
        Monster myMonster = new Monster("Ogre");
        assertEquals(200, myMonster.getHIT_POINTS());
        assertEquals(2, myMonster.getATTACK_SPEED());
        assertEquals(0.6, myMonster.getCHANCE_TO_HIT());
        assertEquals(30, myMonster.getMINIMUM_DAMAGE());
        assertEquals(60, myMonster.getMAXIMUM_DAMAGE());
        assertEquals(0.1, myMonster.getCHANCE_TO_BLOCK_OR_HEAL());
        assertEquals(30, myMonster.getMINIMUM_HEAL_POINTS());
        assertEquals(60, myMonster.getMAXIMUM_HEAL_POINTS());
    }
    @Test
    void canGatherStatsGremlin() throws SQLException {
        Monster myMonster = new Monster("Gremlin");
        assertEquals(70, myMonster.getHIT_POINTS());
        assertEquals(5, myMonster.getATTACK_SPEED());
        assertEquals(0.8, myMonster.getCHANCE_TO_HIT());
        assertEquals(15, myMonster.getMINIMUM_DAMAGE());
        assertEquals(30, myMonster.getMAXIMUM_DAMAGE());
        assertEquals(0.4, myMonster.getCHANCE_TO_BLOCK_OR_HEAL());
        assertEquals(20, myMonster.getMINIMUM_HEAL_POINTS());
        assertEquals(40, myMonster.getMAXIMUM_HEAL_POINTS());
    }
    @Test
    void canGatherStatsSkeleton() throws SQLException {
        Monster myMonster = new Monster("Skeleton");
        assertEquals(100, myMonster.getHIT_POINTS());
        assertEquals(3, myMonster.getATTACK_SPEED());
        assertEquals(0.8, myMonster.getCHANCE_TO_HIT());
        assertEquals(30, myMonster.getMINIMUM_DAMAGE());
        assertEquals(50, myMonster.getMAXIMUM_DAMAGE());
        assertEquals(0.3, myMonster.getCHANCE_TO_BLOCK_OR_HEAL());
        assertEquals(30, myMonster.getMINIMUM_HEAL_POINTS());
        assertEquals(50, myMonster.getMAXIMUM_HEAL_POINTS());
    }
}
