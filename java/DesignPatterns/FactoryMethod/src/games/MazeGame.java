package games;

import factorys.Factory;
import components.*;
import enums.Direction;
/**
 * MazeGame
 */
public class MazeGame implements Factory {

  public Maze createMaze(){
    Maze maze = makeMaze();
    Room r1 = makeRoom(1);
    Room r2 = makeRoom(2);
    Door door = makeDoor(r1, r2);
    
    maze.addRoom(r1);
    maze.addRoom(r2);

    r1.setSide(Direction.North, makeWall());
    r1.setSide(Direction.South, makeWall());
    r1.setSide(Direction.East, door);
    r1.setSide(Direction.West, makeWall());

    r2.setSide(Direction.North, makeWall());
    r2.setSide(Direction.South, makeWall());
    r2.setSide(Direction.East, makeWall());
    r2.setSide(Direction.West, door);

    return maze;
  }

  @Override
  public Maze makeMaze(){
    return new Maze();
  }

  @Override
  public Room makeRoom(int roomNo){
    return new Room(roomNo);
  }

  @Override
  public Wall makeWall(){
    return new Wall();
  }

  @Override
  public Door makeDoor(Room r1, Room r2){
    return new Door(r1, r2);
  }
}