import java.util.*;
import java.util.Iterator;

class SampleSequence{
  protected Sample[] samples;
}

public class NonCollectionSequence extends SampleSequence {
  public Iterator<Sample> iterator(){
    return new Iterator<Sample>(){
      private int index = 0;
      public boolean hasNext(){ return index < samples.length; }
      public Sample next(){ return samples[index++]; }
      public void remove(){ throw new UnsupportedOperationException(); }
    };
  }
  public static void display(Iterator<Sample> iter){
    Sample s;
    while(iter.hasNext()){
      s = iter.next();
      System.out.print(s.getId() + ":" + s + " ");
    }
    System.out.println();
  }
  public class NonCollectionSequenceTest extends Test{
    public void go(){
      test();
    }
  }
  private void test(){
    System.out.println("\ntest:");
    samples = Sample.getArray(8);
    display(this.iterator());
  }
}