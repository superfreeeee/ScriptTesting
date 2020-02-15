package javaImp;

/**
 * Solution9
 */
public class Solution9 {

  public boolean isPalindrome(int x) {
    char[] s = String.valueOf(x).toCharArray();
    int i = 0, j = s.length-1;
    while(i < j)
      if(s[i++] != s[j--])
        return false;
    return true;
  }

  public static void main(String[] args) {
    Solution9 s9 = new Solution9();
    int x = 121;
    boolean result = s9.isPalindrome(x);
    System.out.println(result);
  }
}