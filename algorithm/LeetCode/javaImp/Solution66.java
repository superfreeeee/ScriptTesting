package javaImp;

/**
 * Solution66
 */
public class Solution66 {

  public int[] plusOne(int[] digits) {
    int carry = 1;
    for(int i=digits.length-1 ; i>= 0 ; i--) {
      if(digits[i] == 9)
        digits[i] = 0;
      else {
        digits[i] += 1;
        carry = 0;
        break;
      }
    }
    if(carry == 1) {
      int[] result = new int[digits.length + 1];
      result[0] = 1;
      for(int i=1 ; i<result.length ; i++)
        result[i] = digits[i-1];
      return result;
    }
    return digits;
  }
}