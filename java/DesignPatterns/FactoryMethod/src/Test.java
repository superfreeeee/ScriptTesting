import components.Maze;
import games.*;

/**
 * Test
 */
public class Test {

  public static void main(String[] args) {
    Maze maze = new MazeGame().createMaze();
    if(maze != null)
      System.out.println("maze created");
    Maze bombedMaze = new BombedMazeGame().createMaze();
    if(bombedMaze != null)
      System.out.println("bombedMaze created");
    Maze enchantedMaze = new EnchantedMazeGame().createMaze();
    if(enchantedMaze != null)
      System.out.println("enchantedMaze created");

  }
}