import java.util.concurrent.*;
import java.util.*;

/**
 * TestThread
 */
public class TestThread {

  static void test(){
    RunnableMission rm = new RunnableMission();
    rm.run();
  }

  static void test1(){
    Thread t = new Thread(new RunnableMission());
    t.start();
    System.out.println("Thread Over");
  }

  static void test2(){
    for(int i=0 ; i<3 ; i++){
      new Thread(new RunnableMission(3)).start();
    }
    System.out.println("Thread Over");
  }

  static void test3(){
    ExecutorService exec = Executors.newCachedThreadPool();
    for(int i=0 ; i<5 ; i++)
      exec.execute(new RunnableMission(5));
    exec.shutdown();
  }

  static void test4(){
    ExecutorService exec = Executors.newFixedThreadPool(5);
    for(int i=0 ; i<5 ; i++)
      exec.execute(new RunnableMission(5));
    exec.shutdown();
  }
  
  static void test5(){
    ExecutorService exec = Executors.newSingleThreadExecutor();
    for(int i=0 ; i<5 ; i++)
      exec.execute(new RunnableMission(5));
    exec.shutdown();
  }

  static void test6(){
    ExecutorService exec = Executors.newCachedThreadPool();
    ArrayList<Future<String>> results = new ArrayList<Future<String>>();
    for(int i=0 ; i<10 ; i++)
      results.add(exec.submit(new CallableMission()));
    for(Future<String> fs : results){
      try{
        System.out.println(fs.get());
      }catch(Exception ex){
        ex.printStackTrace();
      }finally{
        exec.shutdown();
      }
    }
  }

  static void test7(){
    ExecutorService exec = Executors.newCachedThreadPool();
    for(int i=0 ; i<5 ; i++)
      exec.execute(new Sleep());
    exec.shutdown();
  }

  static void test8() {
    ExecutorService exec = Executors.newCachedThreadPool();
    for(int i=0 ; i<5 ; i++)
      exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
    exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
    exec.shutdown();
  }

  static void test9() throws Exception {
    new ResponsiveUI();
    TimeUnit.SECONDS.sleep(1);
    System.out.println(ResponsiveUI.getD());
  }
  public static void main(String[] args) throws Exception {
    test9();
  }
}

class RunnableMission implements Runnable {
  protected int countDown = 10;
  private static int taskCount = 0;
  private final int id = taskCount++;
  
  public RunnableMission(){}
  public RunnableMission(int countDown){
    this.countDown = countDown;
  }

  public String print(){
    return "#" + id + "(" + (countDown > 0 ? countDown : "Lift") + "), ";
  }

  public void run(){
    while(countDown-- > 0){
      System.out.print(print());
      Thread.yield();
    }
  }
}

class CallableMission implements Callable<String> {
  static int count = 0;
  private final int id = count++;
  
  public CallableMission(){}

  public String call(){
    return "result(" + id + ")";
  }
}

class Sleep extends RunnableMission {
  public void run() {
    try{
      while(countDown-- > 0) {
        System.out.println(print());
        TimeUnit.MILLISECONDS.sleep(100);
      }
    }catch(Exception ex){
      System.err.println("Interrupted");
    }
  }
}

class SimplePriorities implements Runnable {
  private int countDown = 5;
  private volatile double d;
  private int priority;
  public SimplePriorities(int priority){
    this.priority = priority;
  }
  public String toString(){
    return "#" + Thread.currentThread() + ": " + countDown;
  }
  public void run() {
    Thread.currentThread().setPriority(priority);
    while(true) {
      for(int i=1 ; i<10000 ; i++) {
        d += (Math.PI + Math.E) / (double)i;
        if(i % 1000 == 0)
          Thread.yield();
      }
      System.out.println(this);
      if(--countDown == 0)
        return;
    }
  }
}

class ResponsiveUI extends Thread {
  private static volatile double d = 1;
  public ResponsiveUI() {
    setDaemon(true);
    start();
  }

  public void run() {
    while(true){
      d = d + (Math.PI + Math.E) / d;
    }
  }

  public static double getD() {
    return d;
  }
}