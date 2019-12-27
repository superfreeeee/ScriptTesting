interface Service{
  void method1();
  void method2();
}

interface ServiceFactory{
  Service getService();
}

class Implementation implements Service{
  private Implementation(){};
  public void method1(){
    System.out.println("Implementationa method1");
  }
  public void method2(){
    System.out.println("Implementationa method2");
  }
  public static ServiceFactory factory = new ServiceFactory(){
    public Service getService(){
      return new Implementation();
    }
  };
}

public class Factories{
  public static void serviceConsumer(ServiceFactory fact){
    Service s = fact.getService();
    s.method1();
    s.method2();
  }
  public static void main(String[] args) {
    serviceConsumer(Implementation.factory);
  }
}