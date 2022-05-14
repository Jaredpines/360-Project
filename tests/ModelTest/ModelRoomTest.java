package ModelTest;

import Model.Room;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ModelRoomTest {
    @Test
    public void createEntranceRoomTest(){
        Room Entrance = new Room(0);
        assertEquals("entrance",Entrance.getStatus());
    }
    @Test
    public void createExitRoomTest(){
        Room Exit = new Room(1);
        assertEquals("exit",Exit.getStatus());
    }
    @Test
    public void createPillarARoomTest(){
        Room Pillar = new Room("pillarA");
        assertTrue(Pillar.getStatus().equals("A") || Pillar.getStatus().equals("I") || Pillar.getStatus().equals("E") || Pillar.getStatus().equals("P") );
    }
    @Test
    public void createPillarERoomTest(){
        Room Pillar = new Room("pillarE");
        assertTrue(Pillar.getStatus().equals("A") || Pillar.getStatus().equals("I") || Pillar.getStatus().equals("E") || Pillar.getStatus().equals("P") );
    }
    @Test
    public void createPillarIRoomTest(){
        Room Pillar = new Room("pillarI");
        assertTrue(Pillar.getStatus().equals("A") || Pillar.getStatus().equals("I") || Pillar.getStatus().equals("E") || Pillar.getStatus().equals("P") );
    }
    @Test
    public void createPillarPRoomTest(){
        Room Pillar = new Room("pillarP");
        assertTrue(Pillar.getStatus().equals("A") || Pillar.getStatus().equals("I") || Pillar.getStatus().equals("E") || Pillar.getStatus().equals("P") );
    }
    @Test
    public void createItemRoomTest(){
        Room Items = new Room("items");
        String[] Split = Items.getStatus().split(" ");
        String output = "HP VP Pit";
        int count = 0;
        int i = 1000;
        while (i-- >= 0){
            Items = new Room("items");
            if(Items.getStatus().equals(output)){
                count++;
            }
        }
        System.out.println(count);
        assertTrue(Split[0].equals("empty") || Split[0].equals("Pit") || Split[0].equals("HP") || Split[0].equals("VP"));

    }
}
