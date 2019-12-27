import java.util.*;

// 接口-策略模式
public class StrategyMode{

  public static void process(Processor p, Object s){
    System.out.println("Using Processor " + p.name());
    System.out.println(p.process(s));
  }

  public static int num = 4;
  public static String s = "Disagreement with beliefs is by definition incorrect";

  public static void count(Arithmetic way, Object num){
    System.out.println("Arithmetic:" + way.name());
    System.out.println(way.count(num));
  }
  public static void main(String[] args) {
    process(new Upcase(), s);
    process(new Downcase(), s);
    process(new Splitter(), s);

    count(new plus(), num);
    count(new minus(), num);
    count(new square(), num);
    count(new root(), num);
  }
}

class Processor{
  public String name(){
    return getClass().getSimpleName();
  };
  Object process(Object input){
    return input;
  };
}

class Upcase extends Processor{
  String process(Object input){
    return ((String)input).toUpperCase();
  }
}

class Downcase extends Processor{
  String process(Object input){
    return ((String)input).toLowerCase();
  }
}

class Splitter extends Processor{
  String process(Object input){
    return Arrays.toString(((String)input).split(" "));
  }
}

abstract class Arithmetic{
  String name(){
    return getClass().getSimpleName();
  };
  abstract Object count(Object num);
}

class plus extends Arithmetic{
  public Object count(Object num){
    return ((int)num)+1;
  }
}

class minus extends Arithmetic{
  public Object count(Object num){
    return ((int)num)-1;
  }
}

class square extends Arithmetic{
  public Object count(Object num){
    return ((int)num)*((int)num);
  }
}

class root extends Arithmetic{
  public Object count(Object num){
    return Math.sqrt((int)num);
  }
}