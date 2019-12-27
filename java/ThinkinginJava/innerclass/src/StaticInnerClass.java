public class StaticInnerClass{
  // static Destination s;
  private static class StaticInnerClassContents implements Contents{
    private int i = 11;
    public int value(){ return i; }
  }
  protected static class StaticInnerClassDestination implements Destination{
    // status
    private String label;
    // constuctor
    private StaticInnerClassDestination(String whereTo){
      label = whereTo;
    }
    //method
    public String readLabel(){ return label; }

    public static void f(){}
    static int x = 10;
    static class AnotherLevel{
      public static void f(){}
      static int x = 10;
    }
  }
  public static Destination destination(String s){
    return new StaticInnerClassDestination(s);
  }
  public static Contents contents(){
    return new StaticInnerClassContents();
  }
  public static void main(String[] args) {
    Contents c = contents();
    System.out.println(c.value());
    Destination d = destination("go");
    System.out.println(d.readLabel());
    // Destination s;
    // System.out.println(s.readLabel());
  }
}