package javaImp;
/**
 * Solution5
 */
public class Solution5 {

  public String longestPalindrome(String s) {
    if(s == null || s.length() == 0)
      return "";
    int l = s.length();
    String result = s.charAt(0) + "";
    for(int i=0 ; i<l-1 ; i++) {
      int[] sub = guide(s, i);
      if(sub[0] > result.length())
        result = s.substring(sub[1], sub[2]);
    }
    return result;
  }

  int[] guide(String s, int center) {
    int l = s.length();
    int front = center-1, end = center+1;

    int[] pos2 = {1, center, center + 1};

    if(end < l && s.charAt(center) == s.charAt(end))
      pos2 = guide(s, front, end + 1);
    int[] result = guide(s, front, end);
    return pos2[0] > result[0]
      ? pos2
      : result;
  }

  int[] guide(String s, int front, int end) {
    int l = s.length();
    while(front >= 0 && end < l) {
      if(s.charAt(front) == s.charAt(end)) {
        front--;
        end++;
      }else {
        break;
      }
    }

    return new int[]{end-front-1, front+1, end};
  }

  public static void main(String[] args) {
    Solution5 s5 = new Solution5();
    String s = "ccc";
    String result = s5.longestPalindrome(s);
    System.out.println(result);
  }
}