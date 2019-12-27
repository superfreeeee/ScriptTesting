import java.util.*;

public class IteratorTest extends Test{
  public void go(){
    List<Sample> samples = Sample.getArrayList(12);
    Iterator<Sample> iter = samples.iterator();
    Sample s;
    while(iter.hasNext()){
      s = iter.next();
      System.out.print(s.getId() + ":" + s + " ");
    }
    System.out.println();

    for(Sample s2 : samples){
      System.out.print(s2.getId() + ":" + s2 + " ");
    }
    System.out.println();
    
    iter = samples.iterator();
    for(int i=0 ; i<6 ; i++){
      iter.next();
      iter.remove();
    }
    System.out.println(samples);
  }
}