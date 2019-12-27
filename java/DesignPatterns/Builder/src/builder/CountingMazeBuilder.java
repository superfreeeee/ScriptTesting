package builder;

/**
 * CountingMazeBuilder
 */
public class CountingMazeBuilder extends MazeBuilder {
  private int doors;
  private int rooms;

  public CountingMazeBuilder(){

  }
  
  public void buildRoom(int n){ rooms++; }
  public void buildDoor(int n1, int n2){ doors++; }
  public int[] getCounts(){ return new int[]{rooms, doors}; }
}