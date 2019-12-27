import java.util.Iterator;
import java.util.Scanner;

public abstract class Test{
  public abstract void go();
  public static void start(Test test){
    test.go();
  }
  public static void main(String[] args) {
    Test[] option = {
      new ArrayListTest(),
      new LinkedListTest(),
      new StackTest(),
      new IteratorTest(),
      new CrossContainerIteration(),
      new ListIteratorTest(),
      new HashSetTest(),
      new TreeSetTest(),
      new HashMapTest(),
      new QueueTest(),
      new PriorityQueueTest(),
      new NonCollectionSequence().new NonCollectionSequenceTest(),
      new AdapterMethodIdiom(),
      new MultiIterableClassTest()
    };
    System.out.print("0: ArrayListTest()\n"+
      "1: LinkedListTest()\n"+
      "2: StackTest()\n"+
      "3: IteratorTest()\n"+
      "4: CorssContainerIterationTest()\n"+
      "5: ListIteratorTest()\n"+
      "6: HashSetTest()\n"+
      "7: TreeSetTest()\n"+
      "8: HashMapTest()\n"+
      "9: QueueTest()\n"+
      "10: PriorityQueueTest()\n"+
      "11: NonCollectionSequenceTest()\n"+
      "12: AdapterMethodIdiom()\n"+
      "13: MultiIterableClassTest()\n"
      );
    System.out.print("Enter your choice: ");
    Scanner in = new Scanner(System.in);
    int choice = in.nextInt();
    Test.start(option[choice]);
    System.out.println();
  }
}