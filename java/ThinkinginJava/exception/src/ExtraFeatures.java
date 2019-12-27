class MyException extends Exception{
  private int x;
  public MyException(){}
  public MyException(String msg){ super(msg); }
  public MyException(String msg, int x){ 
    super(msg); 
    this.x = x;
  }
  public int val(){ return x;}
  public String getMessage(){
    return "Detail Message: " + x + " " + super.getMessage();
  }
}

public class ExtraFeatures extends Test{
  public static void f() throws MyException{
    System.out.println("Throwing MyException from f()");
    throw new MyException();
  }
  public static void g() throws MyException{
    System.out.println("Throwing MyException from g()");
    throw new MyException("Originated in g()");
  }
  public static void h() throws MyException{
    System.out.println("Throwing MyException from h()");
    throw new MyException("Originated in h()", 47);
  }
  public void go(){
    System.out.println("\ntest:");
    try{
      ExtraFeatures.f();      
    }catch(MyException e){
      e.printStackTrace(System.out);
    }
    try{
      ExtraFeatures.g();      
    }catch(MyException e){
      e.printStackTrace(System.out);
    }
    try{
      ExtraFeatures.h();      
    }catch(MyException e){
      e.printStackTrace(System.out);
      System.out.println("e.val() = " + e.val());
    }
  }
}