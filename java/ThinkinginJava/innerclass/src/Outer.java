/**
 * Outer
 */
public class Outer {
  public String name = "Outer";

  private class Inner {
    String name = "Inner";
    void showNamee(){
      System.out.println(name);
    }
  }

  public static void main(String[] args) {
    Inner i = new Outer().new Inner();
    i.showNamee();
  }
}