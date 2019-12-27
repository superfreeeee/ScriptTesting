import java.util.*;
/**
 * CrossContainerIteration
 */
public class CrossContainerIteration extends Test{
  public static void display(Iterator<Sample> iter){
    Sample s;
    while(iter.hasNext()){
      s = iter.next();
      System.out.print(s.getId() + ":" + s + " ");
    }
    System.out.println();
  }
  
  public void go(){
    ArrayList<Sample> samples = Sample.getArrayList(5);
    LinkedList<Sample> samplesLL = new LinkedList<Sample>(samples);
    HashSet<Sample> samplesHS = new HashSet<Sample>(samples);
    TreeSet<Sample> samplesTS = new TreeSet<Sample>(samples);
    Collection[] list = {samples, samplesLL, samplesHS, samplesTS};
    for(Collection c : list){
      display(c.iterator());
    }
  }
}