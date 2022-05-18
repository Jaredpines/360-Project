package ControllerTest;
import Model.Hero;
import Model.Warrior;
import org.junit.jupiter.api.Test;
import Controller.Driver;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
public class ControlTest {
    @Test
    void heroToScreenTest() throws SQLException {
        Warrior myWarrior = new Warrior("Warrior");
        StringBuilder stats = new StringBuilder();
        stats.append("hit points: ").append(myWarrior.getHIT_POINTS()).append("\n");
        stats.append("attack speed: ").append(myWarrior.getATTACK_SPEED()).append("\n");
        stats.append("chance to hit: ").append(myWarrior.getCHANCE_TO_HIT()).append("\n");
        stats.append("minimum damage: ").append(myWarrior.getMINIMUM_DAMAGE()).append("\n");
        stats.append("maximum damage: ").append(myWarrior.getMAXIMUM_DAMAGE()).append("\n");
        stats.append("chance to block: ").append(myWarrior.getCHANCE_TO_BLOCK_OR_HEAL()).append("\n");
        Driver.heroToScreen("Warrior");
        assertEquals(stats.toString(), Driver.heroToScreen("Warrior").toString());

    }
}
