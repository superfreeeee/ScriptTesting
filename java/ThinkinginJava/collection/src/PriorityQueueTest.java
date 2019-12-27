import java.util.*;

public class PriorityQueueTest extends Test{
  public void go(){
    test1();
  }
  private void test1(){
    System.out.println("\ntest1:");
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
    Random rand = new Random(47);
    for(int i=0 ; i<8 ; i++)
      priorityQueue.offer(rand.nextInt(i + 10));
    printQ(priorityQueue);

    List<Integer> ints = Arrays.asList(25, 22, 20, 18, 14, 9, 1, 32, 33, 4, 64, 7, 4, 22);
    priorityQueue = new PriorityQueue<Integer>(ints);
    printQ(priorityQueue);

    priorityQueue = new PriorityQueue<Integer>(ints.size(), Collections.reverseOrder());
    priorityQueue.addAll(ints);
    printQ(priorityQueue);

    String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
    List<String> strings = Arrays.asList(fact.split(""));
    PriorityQueue<String> priorityQueue2 = new PriorityQueue<String>(strings);
    printQ(priorityQueue2);

    priorityQueue2 = new PriorityQueue<String>(ints.size(), Collections.reverseOrder());
    priorityQueue2.addAll(strings);
    printQ(priorityQueue2);

    Set<Character> charSet = new HashSet<Character>();
    for(char c : fact.toCharArray())
      charSet.add(c);
    PriorityQueue<Character> priorityQueue3 = new PriorityQueue<Character>(charSet);
    printQ(priorityQueue3);
  }

  private void printQ(Queue queue){
    while(queue.peek() != null)
      System.out.print(queue.remove() + " ");
    System.out.println();
  }
}