package builder;

import components.Maze;
/**
 * MazeBuilder
 */
public class MazeBuilder {

  protected MazeBuilder(){}

  public void buildMaze(){}
  public void buildRoom(int roomNo){}
  public void buildDoor(int roomFrom, int roomTo){}
  public Maze getMaze(){ return null; }
}