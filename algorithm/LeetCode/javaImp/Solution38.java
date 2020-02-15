package javaImp;

import java.util.LinkedList;

/**
 * Solution38
 */
public class Solution38 {

  public String countAndSay(int n) {
    LinkedList<Integer> list = new LinkedList<>();
    list.add(1);
    list.add(0);

    int count, saved, current;
    while(0 < --n) {
      saved = list.pollFirst();
      count = 1;

      int times = list.size();
      while(times-- > 0) {
        current = list.pollFirst();
        if(saved == current) {
          count++;
          if(times == 0) {
            list.add(count);
            list.add(saved);
          }
        }
        else if(count > 0) {
          list.add(count);
          list.add(saved);
          saved = current;
          count = 1;
        }
      }
      list.add(0);        
    }
    list.removeLast();
    StringBuilder result = new StringBuilder();
    for(int i : list)
      result.append(i);
    return result.toString();
  }

  public static void main(String[] args) {
    Solution38 s38 = new Solution38();
    int n = 5;
    String result = s38.countAndSay(n);

    System.out.println(result);
  }
}