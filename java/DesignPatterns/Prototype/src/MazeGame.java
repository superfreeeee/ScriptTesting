import factorys.MazePrototypeFactory;
import components.*;
import enums.*;
/**
 * MazeGame
 */
public class MazeGame {

  public Maze createMaze(MazePrototypeFactory fact){
    Maze maze = fact.makeMaze();
    Room r1 = fact.makeRoom(1);
    Room r2 = fact.makeRoom(2);
    Door door = fact.makeDoor(r1, r2);

    maze.addRoom(r1);
    maze.addRoom(r2);

    r1.setSide(Direction.North, fact.makeWall());
    r1.setSide(Direction.South, fact.makeWall());
    r1.setSide(Direction.West, fact.makeWall());
    r1.setSide(Direction.East, door);

    r2.setSide(Direction.North, fact.makeWall());
    r2.setSide(Direction.South, fact.makeWall());
    r2.setSide(Direction.West, door);
    r2.setSide(Direction.East, fact.makeWall());

    System.out.println("build");
    return maze;
  }
  public static void main(String[] args) {
    MazePrototypeFactory simpleFact = new MazePrototypeFactory(new Maze(), new Wall(), new Room(), new Door());
    MazeGame game = new MazeGame();
    Maze maze = game.createMaze(simpleFact);
    if(simpleFact != null && game != null && maze != null)
      System.out.println("built succeed");
  }
}