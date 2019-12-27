package factorys;

import components.*;

/**
 * EnchantedMazeFactory
 */
public class EnchantedMazeFactory extends MazeFactory {

  public Room makeRoom(int roomNo) {
    return new EnchantedRoom(roomNo, castSpell());
  }

  public Door makeDoor(Room r1, Room r2){
    return new SpellNeedDoor(r1, r2);
  }

  protected String castSpell(){
    return "";
  }
}