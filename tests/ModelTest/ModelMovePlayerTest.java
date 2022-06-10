package ModelTest;
import Controller.ToScreen;
import Model.Dungeon;
import Model.MovePlayer;
import Model.Warrior;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class ModelMovePlayerTest {
    private MovePlayer myMovePlayer = new MovePlayer();
    private ToScreen myToScreen = new ToScreen();
    @Test
    public void moveTestLeft() throws SQLException {
        Dungeon myDungeon = new Dungeon(5,5);
        myToScreen.setMyMainDungeon(myDungeon);
        myToScreen.setMyHero(new Warrior("Warrior"));
        myToScreen.setMyVPUsed(false);
        int count = 100;
        while (count-- > 0) {
            assertDoesNotThrow(() -> {
                myMovePlayer.move("Left");
            }, "Out of Bounds");
        }
    }
    @Test
    public void moveTestRight() throws SQLException {
        Dungeon myDungeon = new Dungeon(15,5);
        myToScreen.setMyMainDungeon(myDungeon);
        myToScreen.setMyHero(new Warrior("Warrior"));
        myToScreen.setMyVPUsed(false);
        int count = 100;
        while (count-- > 0) {
            assertDoesNotThrow(() -> {
                myMovePlayer.move("Right");
            }, "Out of Bounds");
        }
    }
    @Test
    public void moveTestUp() throws SQLException {
        Dungeon myDungeon = new Dungeon(5,5);
        myToScreen.setMyMainDungeon(myDungeon);
        myToScreen.setMyHero(new Warrior("Warrior"));
        myToScreen.setMyVPUsed(false);
        int count = 100;
        while (count-- > 0) {
            assertDoesNotThrow(() -> {
                myMovePlayer.move("Up");
            }, "Out of Bounds");
        }
    }
    @Test
    public void moveTestDown() throws SQLException {
        Dungeon myDungeon = new Dungeon(5,5);
        myToScreen.setMyMainDungeon(myDungeon);
        myToScreen.setMyHero(new Warrior("Warrior"));
        myToScreen.setMyVPUsed(false);
        int count = 100;
        while (count-- > 0) {
            assertDoesNotThrow(() -> {
                myMovePlayer.move("Down");
            }, "Out of Bounds");
        }
    }
}
