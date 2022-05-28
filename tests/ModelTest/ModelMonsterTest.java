package ModelTest;
import Model.Monster;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class ModelMonsterTest {
    @Test
    void canGatherStatsOgre() throws SQLException {
        Monster myMonster = new Monster("Ogre");
        assertEquals(200, myMonster.getMyHitPoints());
        assertEquals(2, myMonster.getMyAttackSpeed());
        assertEquals(0.6, myMonster.getMyChanceToHit());
        assertEquals(30, myMonster.getMINIMUM_DAMAGE());
        assertEquals(60, myMonster.getMyMaximumDamage());
        assertEquals(0.1, myMonster.getMyChangesToBlockOrHeal());
        assertEquals(30, myMonster.getMINIMUM_HEAL_POINTS());
        assertEquals(60, myMonster.getMAXIMUM_HEAL_POINTS());
    }
    @Test
    void canGatherStatsGremlin() throws SQLException {
        Monster myMonster = new Monster("Gremlin");
        assertEquals(70, myMonster.getMyHitPoints());
        assertEquals(5, myMonster.getMyAttackSpeed());
        assertEquals(0.8, myMonster.getMyChanceToHit());
        assertEquals(15, myMonster.getMINIMUM_DAMAGE());
        assertEquals(30, myMonster.getMyMaximumDamage());
        assertEquals(0.4, myMonster.getMyChangesToBlockOrHeal());
        assertEquals(20, myMonster.getMINIMUM_HEAL_POINTS());
        assertEquals(40, myMonster.getMAXIMUM_HEAL_POINTS());
    }
    @Test
    void canGatherStatsSkeleton() throws SQLException {
        Monster myMonster = new Monster("Skeleton");
        assertEquals(100, myMonster.getMyHitPoints());
        assertEquals(3, myMonster.getMyAttackSpeed());
        assertEquals(0.8, myMonster.getMyChanceToHit());
        assertEquals(30, myMonster.getMINIMUM_DAMAGE());
        assertEquals(50, myMonster.getMyMaximumDamage());
        assertEquals(0.3, myMonster.getMyChangesToBlockOrHeal());
        assertEquals(30, myMonster.getMINIMUM_HEAL_POINTS());
        assertEquals(50, myMonster.getMAXIMUM_HEAL_POINTS());
    }
}
