package factorys;

import components.*;

/**
 * BombedMazeFactory
 */
public class BombedMazeFactory extends MazeFactory {

  public Room makeRoom(int roomNo) {
    return new BombedRoom(roomNo);
  }

  public Wall makeWall() {
    return new BombedWall();
  }
}