import components.*;
import enums.Direction;
import factorys.*;

public class MazeGame {

  public Maze createMazeGame(MazeFactory fact){
    Maze maze = fact.makeMaze();
    Room r1 = fact.makeRoom(1);
    Room r2 = fact.makeRoom(2);
    Door door = fact.makeDoor(r1, r2);
    // set maze
    maze.addRoom(r1);
    maze.addRoom(r2);
    // set r1
    r1.setSide(Direction.North, fact.makeWall());
    r1.setSide(Direction.South, fact.makeWall());
    r1.setSide(Direction.East, door);
    r1.setSide(Direction.West, fact.makeWall());
    // set r2
    r2.setSide(Direction.North, fact.makeWall());
    r2.setSide(Direction.South, fact.makeWall());
    r2.setSide(Direction.East, fact.makeWall());
    r2.setSide(Direction.West, door);

    return maze;
  }
  public static void main(String[] args) {
    MazeGame game = new MazeGame();
    Maze maze = game.createMazeGame(new MazeFactory());
    if(game!=null && maze!=null)
      System.out.println("maze game created succeed");

    Maze enchantedMaze = game.createMazeGame(new EnchantedMazeFactory());
    if(game!=null && enchantedMaze!=null)
      System.out.println("enchantedMaze game created succeed");

    Maze bombedMaze = game.createMazeGame(new BombedMazeFactory());
    if(game!=null && bombedMaze!=null)
      System.out.println("bombedMaze game created succeed");
  }
}