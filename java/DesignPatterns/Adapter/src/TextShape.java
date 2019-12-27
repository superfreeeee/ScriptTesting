/**
 * TextShape
 */
public class TextShape extends Shape {
  private TextView textView;

  public TextShape(TextView tv) {
    System.out.println("create textshape");
    this.textView = tv;
  }
  public void boundingBox(Point bottomLeft, Point topRight) {
    Coord bottom = new Coord(),
      left = new Coord(),
      width = new Coord(),
      height = new Coord();

    textView.getOrigin(bottom, left);
    textView.getExtent(width, height);

    bottomLeft.setPoint(bottom, left);
    topRight.setPoint(width, height);
  }

  public boolean isEmpty() {
    return textView.isEmpty();
  }

  public Manipulator createManipulator() {
    return new TextManipulator(this);
  }
}