import java.util.Arrays;

import builder.*;
import components.*;
/**
 * MazeGame
 */
public class MazeGame {

  // Director
  public Maze createMaze(MazeBuilder builder){
    builder.buildMaze();
    builder.buildRoom(1);
    builder.buildRoom(2);
    builder.buildDoor(1, 2);

    return builder.getMaze();
  }

  public Maze createComplexMaze(MazeBuilder builder){
    builder.buildMaze();
    for(int i=1 ; i<=100 ; i++)
      builder.buildRoom(i);
    for(int i=1 ; i<100 ; i++)
      builder.buildDoor(i, i+1);
    
    return builder.getMaze();
  }

  public int[] countingComplexMaze(MazeBuilder builder){
    createComplexMaze(builder);
    return ((CountingMazeBuilder)builder).getCounts();
  }
  public static void main(String[] args) {
    MazeGame game = new MazeGame();
    if(game!=null)
      System.out.println("game created");
    Maze standardMaze = game.createMaze(new StandardMazeBuilder());
    if(standardMaze!=null)
      System.out.println("standardMaze created");
    Maze complexMaze = game.createComplexMaze(new StandardMazeBuilder());
    if(complexMaze!=null)
      System.out.println("complexMaze created");

    int[] countingComplexMaze = game.countingComplexMaze(new CountingMazeBuilder());
    if(countingComplexMaze != null){
      System.out.println("countingComplexMaze created");
      System.out.println("[rooms, doors]: " + Arrays.toString(countingComplexMaze));
    }
  }
}