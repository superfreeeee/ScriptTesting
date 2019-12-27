import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class HashMapTest extends Test{
  public void go(){
    test1();
    test2();
    test3();
  }
  private void test1(){
    System.out.println("\nTest 1 start:");
    Random rand = new Random(47);
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    Integer freq;
    for(int i=0, r ; i<1000 ; i++){
      r = rand.nextInt(20);
      freq = map.get(r);
      map.put(r, freq == null ? 1 : freq + 1 );
    }
    System.out.println(map);
  }
  private void test2(){
    System.out.println("\nTest 2 start:");
    Map<String, Sample> samplesMap = new HashMap<String, Sample>();
    samplesMap.put("s1", new Sample(1));
    samplesMap.put("s10", new Sample(10));
    samplesMap.put("s100", new Sample(100));
    samplesMap.put("s1000", new Sample(1000));
    System.out.println(samplesMap);
    Sample s = samplesMap.get("s100");
    System.out.println(s);
    System.out.println(samplesMap.containsKey("s100"));
    System.out.println(samplesMap.containsValue(s));
  }
  private void test3(){
    Random rand = new Random();
    System.out.println("\nTest 3 start(Map of List):");
    Map<String, List<Sample>> stringSample = new HashMap<String, List<Sample>>();
    stringSample.put("Player1", Arrays.asList(new Sample(rand.nextInt(20)), new Sample(rand.nextInt(20))));
    stringSample.put("Player2", Arrays.asList(new Sample(rand.nextInt(20)), new Sample(rand.nextInt(20)), new Sample(rand.nextInt(20))));
    stringSample.put("Player3", Arrays.asList(new Sample(rand.nextInt(20)), new Sample(rand.nextInt(20)), new Sample(rand.nextInt(20)) ,new Sample(rand.nextInt(20)), new Sample(rand.nextInt(20))));
    stringSample.put("Player4", Arrays.asList(new Sample(rand.nextInt(20))));
    stringSample.put("Player5", Arrays.asList(new Sample(rand.nextInt(20)), new Sample(rand.nextInt(20)), new Sample(rand.nextInt(20)), new Sample(rand.nextInt(20))));
    System.out.println("Players: " + stringSample.keySet());
    System.out.println("Sapmles: " + stringSample.values());
    // System.out.println(stringSample.values().getClass());
    for(String s : stringSample.keySet()){
      System.out.println(s + " has: ");
      for(Sample sample : stringSample.get(s))
        System.out.println("    " + sample);
    }
  }
}