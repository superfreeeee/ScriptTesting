import java.util.*;

public class ListIteratorTest extends Test{
  public void go(){
    List<Sample> samples = Sample.getArrayList(8);
    ListIterator<Sample> liter = samples.listIterator();
    while(liter.hasNext())
      System.out.print("(" + liter.next() + ", current:" + liter.previousIndex() + ", ready:" + liter.nextIndex() + ") ");
    System.out.println();

    while(liter.hasPrevious())
      System.out.print(liter.previous().getId() + " ");
    System.out.println();

    System.out.println(samples);
    liter = samples.listIterator(3);
    while(liter.hasNext()){
      liter.next();
      liter.set(new Sample());
    }
    System.out.println(samples);
  }
}