import java.util.*;

class Sample implements Comparable{
  private static int count = 0;
  private int id;
  public Sample(){
    this.id = count++;
  }
  public Sample(int id){
    this.id = id;
  }
  int getId(){
    return this.id;
  }
  public static Sample[] getArray(int size){
    Sample[] temp = new Sample[size];
    for(int i=0 ; i<size ; i++)
      temp[i] = new Sample();
    return temp;
  }
  public static ArrayList<Sample> getArrayList(int size){
    ArrayList<Sample> temp = new ArrayList<Sample>();
    for(int i=0 ; i<size ; i++)
      temp.add(new Sample());
    return temp;
  }
  public int compareTo(Object s){
    Sample temp = (Sample)s;
    if(temp.id > this.id){
      return -1;
    }else if(temp.id < this.id){
      return 1;
    }else{
      return 0;
    }
  }
  public String toString(){
    return "Sample" + this.id;
  }
}