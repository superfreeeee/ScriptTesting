package javaImp;
/**
 * Solution58
 */
public class Solution58 {

  public int lengthOfLastWord(String s) {
    if(s.length() == 0)
      return 0;
    String[] ss = s.split(" ");
    if(ss.length == 0)
      return 0;
    return ss[ss.length-1].length();
  }

  public static void main(String[] args) {
    Solution58 s58 = new Solution58();
    String s = " ";
    int result = s58.lengthOfLastWord(s);
    System.out.println(result);
  }
}