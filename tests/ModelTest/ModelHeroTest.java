package ModelTest;
import Model.Hero;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class ModelHeroTest {
    @Test
    void canCreateHeroTest() throws SQLException {

        Hero myHero = new Hero("Warrior");
        boolean isItAHero = false;
        isItAHero = myHero instanceof Hero;
        assertTrue(isItAHero);
    }
    @Test
    void canGatherStatsWarrior() throws SQLException {
        Hero myHero = new Hero("Warrior");
        assertEquals(125, myHero.getHitPoints());
        assertEquals(4, myHero.getAttackSpeed());
        assertEquals(0.8, myHero.getChanceToHit());
        assertEquals(35, myHero.getMinimumDamage());
        assertEquals(60, myHero.getMaximumDamage());
        assertEquals(0.2, myHero.getChanceToBlock());
    }
    @Test
    void canGatherStatsPriestess() throws SQLException {
        Hero myHero = new Hero("Priestess");
        assertEquals(75, myHero.getHitPoints());
        assertEquals(5, myHero.getAttackSpeed());
        assertEquals(0.7, myHero.getChanceToHit());
        assertEquals(25, myHero.getMinimumDamage());
        assertEquals(45, myHero.getMaximumDamage());
        assertEquals(0.3, myHero.getChanceToBlock());
    }
    @Test
    void canGatherStatsThief() throws SQLException {
        Hero myHero = new Hero("Thief");
        assertEquals(75, myHero.getHitPoints());
        assertEquals(6, myHero.getAttackSpeed());
        assertEquals(0.8, myHero.getChanceToHit());
        assertEquals(20, myHero.getMinimumDamage());
        assertEquals(40, myHero.getMaximumDamage());
        assertEquals(0.4, myHero.getChanceToBlock());
    }
}
