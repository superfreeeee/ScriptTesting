package javaImp;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution119
 */
public class Solution119 {

  public List<Integer> getRow(int rowIndex) {
    List<Integer> list = new ArrayList<>();
    long num;
    for(int i=0, n ; i<=rowIndex ; i++) {
      num = 1;
      n = i<rowIndex/2 ? i : rowIndex - i;
      for(int j=0 ; j<n ; j++)
        num = num * (rowIndex-j) / (j+1);
      list.add((int)num);
    }
    return list;
  }

  public static void main(String[] args) {
    Solution119 s119 = new Solution119();
    int rowIndex = 11;
    List<Integer> result = s119.getRow(rowIndex);
    System.out.println(result);
  }
}