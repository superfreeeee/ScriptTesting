import java.util.*;

class IterableClass implements Iterable<String>{
  protected String[] words = "And that is how we know the Earth to be banana-shaped.".split(" ");
  public Iterator<String> iterator(){
    return new Iterator<String>(){
      private int index = 0;
      public boolean hasNext(){ return index < words.length; }
      public String next(){ return words[index++]; }
      public void remove(){ throw new UnsupportedOperationException(); }
    };
  }
}

class MultiIterableClass extends IterableClass{
  public Iterable<String> reversed(){
    return new Iterable<String>(){
      public Iterator<String> iterator(){
        return new Iterator<String>(){
          int current = words.length - 1;
          public boolean hasNext(){ return current > -1; }
          public String next(){ return words[current--]; }
          public void remove(){ throw new UnsupportedOperationException(); }
        };
      }
    };
  }
  public Iterable<String> randomized(){
    return new Iterable<String>(){
      public Iterator<String> iterator(){
        List<String> shuffled = new ArrayList<String>(Arrays.asList(words));
        Collections.shuffle(shuffled, new Random(47));
        return shuffled.iterator();
      }
    };
  }
  public Iterable<String> randomized2(){
    return new Iterable<String>(){
      public Iterator<String> iterator(){
        List<String> shuffled = Arrays.asList(words);
        Collections.shuffle(shuffled, new Random(47));
        return shuffled.iterator();
      }
    };
  }
}

public class MultiIterableClassTest extends Test{
  public void go(){
    System.out.println("\ntest:");
    MultiIterableClass mic = new MultiIterableClass();
    for(String s : mic.reversed())
      System.out.print(s + " ");
    System.out.println();

    for(String s : mic.randomized())
      System.out.print(s + " ");
    System.out.println();

    for(String s : mic)
      System.out.print(s + " ");
    System.out.println();

    for(String s : mic.randomized2())
      System.out.print(s + " ");
    System.out.println();

    for(String s : mic)
      System.out.print(s + " ");
    System.out.println();
  }
}

