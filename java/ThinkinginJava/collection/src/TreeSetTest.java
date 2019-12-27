import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest extends Test{
  String s = "QWERTYUIOASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
  public void go(){
    originTreeSet();
    orderedTreeSet();
  }
  void originTreeSet(){
    Set<String> words = new TreeSet<String>( Arrays.asList(s.split("")) );
    System.out.println(words);
  }
  void orderedTreeSet(){
    Set<String> words = new TreeSet(String.CASE_INSENSITIVE_ORDER);
    words.addAll(Arrays.asList(s.split("")));
    System.out.println(words);
  }
}