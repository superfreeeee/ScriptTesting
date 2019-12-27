package factorys;

import components.*;

/**
 * BombedMazeFactory
 */
public class BombedMazeFactory extends MazeFactory {

  public Wall makeWall(){
    return new BombedWall();
  }

  public Room makeRoom(int roomNo){
    return new BombedRoom(roomNo);
  }
}