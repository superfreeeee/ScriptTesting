package javaImp;

/**
 * Solution67
 */
public class Solution67 {

  public String addBinary(String a, String b) {
    StringBuilder result = new StringBuilder();
    char[] s1 = a.toCharArray();
    char[] s2 = b.toCharArray();
    int carry = 0;
    int sum;
    for(int i=s1.length-1, j=s2.length-1; i>=0 || j>=0 ;) {
      int x = i>=0 ? s1[i--]-'0' : 0;
      int y = j>=0 ? s2[j--]-'0' : 0;
      sum = x + y + carry;
      result.append(sum%2);
      carry = sum/2;
    }
    if(carry == 1)
      result.append(1);
    return result.reverse().toString();
  }

  public static void main(String[] args) {
    Solution67 s67 = new Solution67();
    String a = "11";
    String b = "1";
    String result = s67.addBinary(a, b);
    System.out.println(result);
  }
}