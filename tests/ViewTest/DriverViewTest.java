package ViewTest;

import Model.Hero;
import View.DriverView;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DriverViewTest {

    @Test
    public void getHero() throws SQLException {
        Hero myHero = new Hero("Warrior");
        StringBuilder stats = new StringBuilder();
        stats.append("hit points: ").append(myHero.getHIT_POINTS()).append("\n");
        stats.append("attack speed: ").append(myHero.getATTACK_SPEED()).append("\n");
        stats.append("chance to hit: ").append(myHero.getCHANCE_TO_HIT()).append("\n");
        stats.append("minimum damage: ").append(myHero.getMINIMUM_DAMAGE()).append("\n");
        stats.append("maximum damage: ").append(myHero.getMAXIMUM_DAMAGE()).append("\n");
        stats.append("chance to block: ").append(myHero.getCHANCE_TO_BLOCK_OR_HEAL()).append("\n");
        assertEquals(stats.toString(), DriverView.getHero("Warrior"));
    }
    @Test
    public void mapMakerTest(){
        String s = DriverView.mapMaker(5,5);
        int count = 100;
        while (count-- > 0) {
            assertEquals(132, s.length());
        }
    }
}