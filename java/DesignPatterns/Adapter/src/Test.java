/**
 * Test
 */
public class Test {

  public static void main(String[] args) {
    TextView tv = new TextView();
    Shape shape = new TextShape(tv);
    Point bottomLeft = new Point();
    Point topRight = new Point();
    shape.boundingBox(bottomLeft, topRight);
    Manipulator textManipulator = shape.createManipulator();
    boolean b = ((TextShape)shape).isEmpty();
    if(tv != null)
      System.out.println("\nTextView created");
    if(shape != null)
      System.out.println("TextShape created");
    if(bottomLeft != null)
      System.out.println("bottomLeft created");
    if(topRight != null)
      System.out.println("topRight created");
    if(textManipulator != null)
      System.out.println("textManipulator created");
    if(b)
      System.out.println("boolean created");
    
  }
}