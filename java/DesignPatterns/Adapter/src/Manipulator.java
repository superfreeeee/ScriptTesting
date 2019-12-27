/**
 * Manipulator
 */
public abstract class Manipulator {
  private Shape shape;
  
  public Manipulator(Shape shape) {
    System.out.println("create manipulator");
    this.shape = shape;
  }
}