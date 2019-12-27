package factorys;

import components.*;
/**
 * MazePrototypeFactory
 */
public class MazePrototypeFactory {
  private Maze prototypeMaze;
  private Wall prototypeWall;
  private Room prototypeRoom;
  private Door prototypeDoor;

  public MazePrototypeFactory(Maze maze, Wall wall, Room room, Door door){
    this.prototypeMaze = maze;
    this.prototypeWall = wall;
    this.prototypeRoom = room;
    this.prototypeDoor = door;
  }

  public Maze makeMaze(){
    return prototypeMaze.clone();
  }

  public Wall makeWall(){
    return prototypeWall.clone();
  }

  public Room makeRoom(int roomNo){
    Room room = prototypeRoom.clone();
    room.init(roomNo);
    return room;
  }

  public Door makeDoor(Room r1, Room r2){
    Door door = prototypeDoor.clone();
    door.init(r1, r2);
    return door;
  }
}