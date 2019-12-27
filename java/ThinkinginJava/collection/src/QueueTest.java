import java.util.Random;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTest extends Test{
  public void go(){
    test1();
  }
  private void test1(){
    System.out.println("\ntest1:");
    Queue<Integer> queue = new LinkedList<Integer>();
    Random rand = new Random(47);
    for(int i=0 ; i<10 ; i++)
      queue.offer(rand.nextInt(i + 10));
    printQ(queue);
    Queue<Character> queueC = new LinkedList<Character>();
    for(char c : "Apple".toCharArray())
      queueC.offer(c);
    printQ(queueC);
  }
  
  private void printQ(Queue queue){
    while(queue.peek() != null)
      System.out.print(queue.remove() + " ");
    System.out.println();
  }
}