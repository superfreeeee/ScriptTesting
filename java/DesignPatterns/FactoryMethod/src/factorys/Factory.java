package factorys;

import components.*;
/**
 * Factory
 */
public interface Factory {

  public Maze makeMaze();
  public Room makeRoom(int roomNo);
  public Wall makeWall();
  public Door makeDoor(Room r1, Room r2);
}