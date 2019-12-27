import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ArrayListTest extends Test{
  public void go(){
    List<Sample> samples = Sample.getArrayList(7);
    System.out.println("1: " +  samples);
    System.out.println("Samples " + samples + "\n");
    
    Sample a = new Sample();
    samples.add(a);
    System.out.println("2: " + samples);
    System.out.println("3: " + samples.contains(a));
    System.out.println("Samples " + samples + "\n");

    samples.remove(a);
    Sample b = samples.get(2);
    System.out.println("4: " + b + " " + samples.indexOf(b));
    System.out.println("Samples " + samples + "\n");
    
    Sample c = new Sample(2);
    System.out.println("c " + c);
    System.out.println("5: " + samples.indexOf(c));
    System.out.println("6: " + samples.remove(c));
    System.out.println("Samples " + samples + "\n");

    System.out.println("7: " + samples.remove(b));
    System.out.println("Samples " + samples + "\n");

    samples.add(3, new Sample());
    System.out.println("8: " + samples);
    System.out.println("Samples " + samples + "\n");

    List<Sample> sub = samples.subList(1, 6);
    System.out.println("9: sub " + sub);
    System.out.println("10: " + samples.containsAll(sub));
    Collections.sort(sub);
    System.out.println("11: sorted sub " + sub);
    System.out.println("12: " + samples.containsAll(sub));
    System.out.println("Samples " + samples + "\n");

    List<Sample> copy = new ArrayList<Sample>(samples);
    System.out.println("copy " + copy);
    sub = Arrays.asList(samples.get(1), samples.get(4));
    System.out.println("13: sub " + sub);
    copy.retainAll(sub);
    System.out.println("14: copy " + copy);
    copy = new ArrayList<Sample>(samples);
    System.out.println("copy " + copy);
    copy.remove(2);
    System.out.println("15: copy " + copy);
    copy.removeAll(sub);
    System.out.println("16: copy " + copy);
    copy.set(1, new Sample());
    System.out.println("17: copy " + copy);
    copy.addAll(2, sub);
    System.out.println("18: copy " + copy);
    System.out.println("19: " + copy.isEmpty());
    copy.clear();
    System.out.println("20: copy " + copy);
    System.out.println("21: " + copy.isEmpty());
    System.out.println("copy: " + copy);
    System.out.println("samples: " + samples + "\n");

    samples.addAll(Sample.getArrayList(4));
    System.out.println("22: samples " + samples);
    Object[] o = samples.toArray();
    System.out.println("23: " + o[2]);
    Sample[] s = samples.toArray(new Sample[0]);
    System.out.println("24: " + s[2].getId());
  }
}