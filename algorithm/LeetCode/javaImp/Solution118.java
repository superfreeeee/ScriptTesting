package javaImp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * InnerSolution118
 */
public class Solution118 {

  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Integer> list;
    for(int i=0 ; i<numRows ; i++) {
      list = new LinkedList<>();
      for(int j=0 ; j <= i ; j++)
        list.add(C(i,j));
      result.add(list);
    }
    return result;
  }

  public int C(int m, int n) {
    int result= 1;
    if(n > m/2)
      n = m - n;
    for(int i=0 ; i<n ; i++)
      result = result * (m-i) / (i+1);
    return result;
  }

  public static void main(String[] args) {
    Solution118 s118 = new Solution118();
    int numRows = 5;
    List<List<Integer>> result = s118.generate(numRows);
    System.out.println(result);
  }
}