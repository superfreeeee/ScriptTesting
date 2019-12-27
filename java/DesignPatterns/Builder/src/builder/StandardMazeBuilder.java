package builder;

import components.*;
import enums.Direction;

/**
 * StandardMazeBuilder
 */
public class StandardMazeBuilder extends MazeBuilder {

  private Maze current;

  public StandardMazeBuilder(){

  }

  public void buildMaze(){
    current = new Maze();
  }

  public void buildRoom(int roomNo){
    if(current == null)  return;
    Room room = new Room(roomNo);
    current.addRoom(room);

    room.setSide(Direction.North, new Wall());
    room.setSide(Direction.South, new Wall());
    room.setSide(Direction.East, new Wall());
    room.setSide(Direction.West, new Wall());
  }

  public void buildDoor(int n1, int n2){
    Room r1 = current.getRoom(n1);
    Room r2 = current.getRoom(n2);
    Door door = new Door(r1, r2);

    r1.setSide(commonWall(r1, r2), door);
    r2.setSide(commonWall(r2, r1), door);
  }

  private Direction commonWall(Room r1, Room r2){
    int d = r2.getRoomNo() - r1.getRoomNo();
    switch(d) {
      case 3: return Direction.South;
      case -3: return Direction.North;
      case 1: return Direction.East;
      case -1: return Direction.West;
    }
    return null;
  }
  public Maze getMaze(){
    return current;
  }
}