package javaImp;

/**
 * Solution7
 */
public class Solution7 {

  public int reverse(int x) {
    int result = 0;
    while(x != 0) {
      int pop = x % 10;
      if(result > Integer.MAX_VALUE/10 || result == Integer.MAX_VALUE && pop > 7)
        return 0;
      if(result < Integer.MIN_VALUE/10 || result == Integer.MAX_VALUE && pop < -8)
        return 0;
      result = result * 10 + pop;
      x /= 10;
    }
    return result;
  }

  public static void main(String[] args) {
    Solution7 s7 = new Solution7();
    int x = Integer.MAX_VALUE;
    int result = s7.reverse(x);
    System.out.println(result);
  }
}