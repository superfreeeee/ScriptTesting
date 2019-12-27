/**
 * Shape
 */
public abstract class Shape {

  public Shape() {
    System.out.println("create shape");
  }

  public abstract void boundingBox(Point bottomLeft, Point topRight);

  public abstract Manipulator createManipulator();
}