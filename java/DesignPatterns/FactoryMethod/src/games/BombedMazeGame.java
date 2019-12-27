package games;

import components.*;
/**
 * BombedMazeGame
 */
public class BombedMazeGame extends MazeGame {

  public Wall makeWall(){
    return new BombedWall();
  }

  public Room makeRoom(int roomNo){
    return new BombedRoom(roomNo);
  }
}