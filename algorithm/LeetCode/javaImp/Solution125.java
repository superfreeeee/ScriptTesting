package javaImp;

/**
 * Solution125
 */
public class Solution125 {

  public boolean isPalindrome(String s) {
    s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
    char[] str = s.toCharArray();
    for(int i=0, j=str.length-1 ; i<j ; i++, j--)
      if(str[i] != str[j])
        return false;
    return true;  
  }

  public static void main(String[] args) {
    Solution125 s = new Solution125();
    String str = "A man, a plan, a canal: Panama";
    boolean result = s.isPalindrome(str);
    System.out.println(result);
  }
}