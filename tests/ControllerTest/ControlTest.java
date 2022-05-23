package ControllerTest;
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
        stats.append("hit points: ").append(myWarrior.getMyHitPoint()).append("\n");
        stats.append("attack speed: ").append(myWarrior.getMyAttackSpeed()).append("\n");
        stats.append("chance to hit: ").append(myWarrior.getMyChanceToHit()).append("\n");
        stats.append("minimum damage: ").append(myWarrior.getMyMinimumDamage()).append("\n");
        stats.append("maximum damage: ").append(myWarrior.getMyMaximumDamage()).append("\n");
        stats.append("chance to block: ").append(myWarrior.getMyChangesToBlockOrHeal()).append("\n");
        Driver.heroToScreen("Warrior");
        assertEquals(stats.toString(), Driver.heroToScreen("Warrior").toString());

    }
}
