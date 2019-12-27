/**
 * Point
 */
public class Point {

  private static int count = 0;
  private int id = count;
  Coord x;
  Coord y;
  
  public Point() {
    System.out.println("create point" + count++);
  }
  public void setPoint(Coord x, Coord y) {
    System.out.println("set point" + id);
    this.x = x;
    this.y = y;
  }
}