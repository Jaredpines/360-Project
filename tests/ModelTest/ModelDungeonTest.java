package ModelTest;

import Model.Dungeon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ModelDungeonTest {
    @Test
    public void createDungeonPillarTest(){
       Dungeon First = new Dungeon(5,5);
        long containsCount = 100;
        while (containsCount-- >= 0) {
            assertTrue(First.toString().contains("A") && First.toString().contains("I") && First.toString().contains("E") && First.toString().contains("P"));
        }
    }
    @Test
    public void createDungeonEntranceExitTest(){
        Dungeon First = new Dungeon(5,5);
        long containsCount = 100;
        System.out.println(First);
        while (containsCount-- >= 0) {
            assertTrue(First.toString().contains("entrance") && First.toString().contains("exit"));
        }

    }
    @Test
    public void doesPlayerStartAtEntrance(){
        Dungeon First = new Dungeon(5,5);
        System.out.println(First);
        System.out.println(First.toString().indexOf("entrance"));
        long containsCount = 100;
        while (containsCount-- >= 0) {
            assertEquals("player", First.getMAZE()[First.getMyPlayerX()][First.getMyPlayerY()][1].getStatus());
        }
        System.out.println(First.getMAZE()[First.getMyPlayerX()][First.getMyPlayerY()][1].getStatus());
    }
}



