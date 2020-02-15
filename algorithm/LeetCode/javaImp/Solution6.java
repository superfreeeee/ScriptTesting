package javaImp;

import java.util.Arrays;

/**
 * Solution6
 */
public class Solution6 {

  public String convert(String s, int numRows) {
    if(s == null || s.length() == 0)
      return "";
    int len;
    if(numRows == 1) {
      return s;
    }else {
      len = 1 + (s.length()/(numRows-1));
    }
    char[][] rows = new char[numRows][];
    int[] pointer = new int[numRows];
    for(int i=0 ; i<numRows ; i++) {
      rows[i] = new char[len];
      for(int j=0 ; j<len ; j++)
        rows[i][j] = 0;
      pointer[i] = 0;
    }
    int r = 0;
    boolean goDown = true;
    for(char c : s.toCharArray()) {
      printRows(rows, pointer);
      rows[r][pointer[r]++] = c;
      if(goDown) r++;
      else r--;

      if(r == 0) goDown = true;
      else if(r == numRows-1) goDown = false;
    }
    StringBuilder result = new StringBuilder();
    for(char[] row : rows){
      for(char c : row)
        if(c != 0)
          result.append(c);
    }
    return result.toString();
  }

  void printRows(char[][] rows, int[] pointer) {
    int i=0;
    for(char[] row : rows) {
      
      System.out.println(pointer[i++] + ": " + Arrays.toString(row));
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Solution6 s6 = new Solution6();
    String s = "PAYPALISHIRING";
    int numRows = 3;
    String result = s6.convert(s, numRows);
    System.out.println(result);
  }
}