import factorys.*;
import components.*;
import enums.*;

/**
 * MazeGame
 */
public class MazeGame {

  public Maze createMaze(MazeFactory fact){
    Maze maze = fact.makeMaze();
    Room r1 = fact.makeRoom(1);
    Room r2 = fact.makeRoom(2);
    Door door = fact.makeDoor(r1, r2);

    maze.addRoom(r1);
    maze.addRoom(r2);

    r1.setSide(Direction.North, fact.makeWall());
    r1.setSide(Direction.South, fact.makeWall());
    r1.setSide(Direction.East, door);
    r1.setSide(Direction.West, fact.makeWall());
    r2.setSide(Direction.North, fact.makeWall());
    r2.setSide(Direction.South, fact.makeWall());
    r2.setSide(Direction.East, fact.makeWall());
    r2.setSide(Direction.West, door);

    return maze;
  }
  public static void main(String[] args) {
    MazeGame game = new MazeGame();
    Maze maze = game.createMaze(MazeFactory.instance(""));
    if(game != null && maze != null)
      System.out.println("maze created");
    Maze bombedMaze = game.createMaze(MazeFactory.instance("bombed"));
    if(game != null && bombedMaze != null)
      System.out.println("bombedmaze created");
    Maze enchantedMaze = game.createMaze(MazeFactory.instance("enchanted"));
    if(game != null && enchantedMaze != null)
      System.out.println("enchantedmaze created");
  }
}