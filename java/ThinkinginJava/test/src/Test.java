import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class Test{

  // 測試標籤
  public void testLabel(){
    // label 1
    System.out.println("\nlabel 1");
    outer1:
    for(int i=0 ; i<5 ; i++){
      System.out.println("outer start : i = " + i);
      inner1:
      for(int j=0 ; j<5 ; j++){
        System.out.println("inner start : j = " + j);
        if(i+j == 4){
          System.out.println("now : i = " + i + ", j = " + j);
          System.out.println("continue");
          continue;
        }
      }
      System.out.println("inner reach end");
    }
    // label 2
    System.out.println("\nlabel 2");
    outer2:
    for(int i=0 ; i<5 ; i++){
      System.out.println("outer start : i = " + i);
      inner2:
      for(int j=0 ; j<5 ; j++){
        System.out.println("inner start : j = " + j);
        if(i+j == 4){
          System.out.println("now : i = " + i + ", j = " + j);
          System.out.println("break");
          break;
        }
      }
      System.out.println("inner reach end");
    }
    // label 3
    System.out.println("\nlabel 3");
    outer3:
    for(int i=0 ; i<5 ; i++){
      System.out.println("outer start : i = " + i);
      inner3:
      for(int j=0 ; j<5 ; j++){
        System.out.println("inner start : j = " + j);
        if(i+j == 4){
          System.out.println("now : i = " + i + ", j = " + j);
          System.out.println("continue inner");
          continue inner3;
        }
      }
      System.out.println("inner reach end");
    }
    // label 4
    System.out.println("\nlabel 4");
    outer4:
    for(int i=0 ; i<5 ; i++){
      System.out.println("outer start : i = " + i);
      inner4:
      for(int j=0 ; j<5 ; j++){
        System.out.println("inner start : j = " + j);
        if(i+j == 4){
          System.out.println("now : i = " + i + ", j = " + j);
          System.out.println("break inner");
          break inner4;
        }
      }
      System.out.println("inner reach end");
    }
    // label 5
    System.out.println("\nlabel 5");
    outer5:
    for(int i=0 ; i<5 ; i++){
      System.out.println("outer start : i = " + i);
      inner5:
      for(int j=0 ; j<5 ; j++){
        System.out.println("inner start : j = " + j);
        if(i+j == 4){
          System.out.println("now : i = " + i + ", j = " + j);
          System.out.println("continue outer");
          continue outer5;
        }
      }
      System.out.println("inner reach end");
    }
    // label 6
    System.out.println("\nlabel 6");
    outer6:
    for(int i=0 ; i<5 ; i++){
      System.out.println("outer start : i = " + i);
      inner6:
      for(int j=0 ; j<5 ; j++){
        System.out.println("inner start : j = " + j);
        if(i+j == 4){
          System.out.println("now : i = " + i + ", j = " + j);
          System.out.println("break outer");
          break outer6;
        }
      }
      System.out.println("inner reach end");
    }
  }

  // 測試枚舉
  public void testEnum(){
    Name name = Name.TOP;
    System.out.println("Name.TOP:" + name);

    for(Name oneName : Name.values()){
      System.out.println("Name:" + oneName + ", ordinal:" + oneName.ordinal());
      new People(oneName).tell();
    }
  }

  // 測試訪問修飾符
  public void testAccess(){
    Launch test = new Launch();
    test.testPrivateSoup();
    test.testPublicSoup();
  }

  // 測試Scanner
  public void testScanner(){
    Scanner in = new Scanner(System.in);
    int a = in.nextInt();
    in.nextLine();
    String b = in.nextLine();
    System.out.println(a);
    System.out.println(b);
    in.close();
  }
  public static void main(String[] args) {
    Test test = new Test();
    // test.testAccess();
    // test.testLabel();
    // test.testEnum();
    // test.testScanner();
  }

}

enum Name{
  TOP, BOTTOM, LEFT, RIGHT
}

class People{
  Name name;
  public People(Name name){
    this.name = name;
  }
  public void tell(){
    // System.out.println("I would like to tell you...");
    switch(this.name){
      case TOP:
        System.out.println("this.name = top");
        break;
      case BOTTOM:
        System.out.println("this.name = bottom");
        break;
      case LEFT:
        System.out.println("this.name = left");
        break;
      case RIGHT:
        System.out.println("this.name = right");
        break;
    }
  }
}

class Launch{
  public void testPublicSoup(){
    PublicSoup test = new PublicSoup();
  }
  public void testPrivateSoup(){
    // PrivateSoup test = new PrivateSoup();
    // PrivateSoup is not visible
    System.out.println("PrivateSoup is not visible");
  }
}

class PublicSoup{
  public PublicSoup(){
    System.out.println("PublicSoup create");
  }
}

class PrivateSoup{
  private PrivateSoup(){
    System.out.println("PrivateSoup create");
  }
}