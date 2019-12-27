import java.util.*;

public class LinkedListTest extends Test{
  public void go(){
    LinkedList<Sample> samples = new LinkedList<Sample>(Sample.getArrayList(5));
    System.out.println(samples);
    System.out.println("samples.getFirst(): " + samples.getFirst());
    System.out.println("samples.element(): " + samples.element());
    System.out.println("samples.peek(): " + samples.peek());
    System.out.println("samples.remove(): " + samples.remove());
    System.out.println("samples.removeFirst(): " + samples.removeFirst());
    System.out.println("samples.removeLast(): " + samples.removeLast());
    System.out.println("samples.poll(): " + samples.poll());

    System.out.println("\n" + samples);
    samples.addFirst(new Sample());
    System.out.println("After addFirst(): " + samples);
    samples.offer(new Sample());
    System.out.println("After offer(): " + samples);
    samples.add(new Sample());
    System.out.println("After add(): " + samples);
    samples.addLast(new Sample());
    System.out.println("After addLast(): " + samples);
  }
}