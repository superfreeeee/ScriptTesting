import java.util.Scanner;

public abstract class Test{
  public abstract void go();
  public static void main(String[] args) {
    Test[] tests = {
      new InheritingExceptionsTest(),
      new LoggingException(),
      new ExtraFeatures()
    };
    System.out.print(
      "0: InheritingExceptionsTest()\n"+
      "1: LoggingException()\n"+
      "2: ExtraFeatures()\n"
    );
    Scanner in = new Scanner(System.in);
    System.out.print("Enter your choice: ");
    tests[in.nextInt()].go();
    System.out.println();
  }
}