/**
 * BoundingBox
 */
public class BoundingBox {

  Point bottomLeft;
  Point topRight;

  public BoundingBox(Point bottomLeft, Point topRight) {
    System.out.println("create boundingbox");
    this.bottomLeft = bottomLeft;
    this.topRight = topRight;
  }
}