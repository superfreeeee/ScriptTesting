package javaImp;

/**
 * Solution8
 */
public class Solution8 {

  public int myAtoi(String str) {
    char[] s = filter(str);
    if(s.length == 0) return 0;
    boolean isPositive = true;
    int p = 0, l = s.length;
    if(s[0] == '+' || s[0] == '-') {
      isPositive = s[0] == '+' ? true : false;
      p++;
    }

    int result = 0;
    while(p < l) {
      int n = s[p++] - '0';
      if(n < 0 || n > 9)
        break;
      if(result > Integer.MAX_VALUE/10 || result == Integer.MAX_VALUE/10 && n > 7)
        return Integer.MAX_VALUE;
      else if(result < Integer.MIN_VALUE/10 || result == Integer.MIN_VALUE/10 && n > 8)
        return Integer.MIN_VALUE;
      if(isPositive)
        result = result * 10 + n;
      else
        result = result * 10 - n;
    }
    return result;
  }

  public char[] filter(String s) {
    int i = 0;
    for(char c : s.toCharArray()) {
      if(c == ' ')
        i++;
      else if(c == '-' || c == '+' || c <= '9' && c >= '0')
        return s.substring(i).toCharArray();
      else
        break;
    }
    return new char[0];
  }

  public static void main(String[] args) {
    Solution8 s8 = new Solution8();
    String s = "  42";
    int result = s8.myAtoi(s);
    System.out.println(result);
  }
}