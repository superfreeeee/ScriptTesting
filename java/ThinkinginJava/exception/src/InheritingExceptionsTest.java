class SimpleException extends Exception{}

public class InheritingExceptionsTest extends Test{
  public void go(){
    test();
  }
  public void test(){
    InheritingExceptionsTest sed = new InheritingExceptionsTest();
    try{
      sed.f();
    }catch(Exception e){
      System.out.println("Caught it!");
    }
  }
  public void f() throws SimpleException{
    System.out.println("\ntest:");
    System.out.println("Throw SimpleException from f()");
    throw new SimpleException();
  }
}