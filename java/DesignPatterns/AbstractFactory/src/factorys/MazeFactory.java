package factorys;

import components.*;

public class MazeFactory{

  public Maze makeMaze(){
    return new Maze();
  }

  public Wall makeWall(){
    return new Wall();
  }

  public Room makeRoom(int roomNo){
    return new Room(roomNo);
  }

  public Door makeDoor(Room r1, Room r2){
    return new Door(r1, r2);
  }
}