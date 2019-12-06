/**
 * ConstructionTest
 */
public class ConstructionTest {

    private static String action;

    public static void main(String[] args) {
        f2();
    }

    public static void f1() {
        d1("f1: A a = new A();");
        A a = new A();
        d2();
    }

    public static void f2() {
        d1("f2: A.staticString;");
        String s = A.staticString;
        d2();
    }

    public static void d1(String action) {
        ConstructionTest.action = action;
        System.out.println("\n<----- " + action + " -----");
    }

    public static void d2() {
        System.out.println("----- " + action + " ----->\n");
    }
}

class A {

    static String staticString = "static string";
    static String staticString2;
    static String staticString3 = createStaticString();

    String string = "string";
    String string2;

    static {
        System.out.println("call static init");
        staticString2 = "static string 2";
    }

    {
        System.out.println("call init");
        string2 = "string 2";
    }

    public static String createStaticString() {
        System.out.println("call createStaticString");
        return "static string 3";
    }

    public String createString() {
        System.out.println("call createString");
        return "string 3";
    }

}