/**
 * Test2
 */
public class Test2 {

  public static void main(String[] args) {
    int result1 = test();
    System.out.println(result1);
  }

  public static int test(){
    int result = 1;
    try{
      throw new Exception();
      // System.out.println("test go");
      // result = 2;
      // return result;
    }catch(Exception ex){
      System.out.println("catch");
      result = 3;
      // return result;
    }finally{
      System.out.println("finally");
      result = 4;
      return result;
    }
  }
}