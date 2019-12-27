package games;

import components.*;
/**
 * EnchantedMazeGame
 */
public class EnchantedMazeGame extends MazeGame {

  public Room makeRoom(int roomNo){
    return new EnchantedRoom(roomNo, castSpell());
  }

  public Door makeDoor(Room r1, Room r2){
    return new SpellNeedDoor(r1, r2);
  }

  public String castSpell(){
    return "";
  }
}