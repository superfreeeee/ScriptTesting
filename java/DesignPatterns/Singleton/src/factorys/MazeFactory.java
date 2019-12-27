package factorys;

import components.*;
/**
 * MazeFactory
 */
public class MazeFactory {
  private static MazeFactory mazeFactory;

  static {
    mazeFactory = new MazeFactory();
  }

  public static MazeFactory instance(String type) {
    switch (type) {
      case "bombed":  mazeFactory = new BombedMazeFactory();  break;
      case "enchanted":  mazeFactory = new EnchantedMazeFactory();  break;
      default:  mazeFactory = new MazeFactory();
    }
    String name = mazeFactory.getClass().getSimpleName();
    System.out.println("fact: " + name);
    return mazeFactory;
  }

  protected MazeFactory() {

  }

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
    return new Door(r1, r1);
  }
}