package javaImp;
/**
 * Solution13
 */
public class Solution13 {

  public int romanToInt(String s) {
    int[] nums = toIntArray(s);
    int result = 0;
    for(int i=0 ; i<nums.length-1 ; i++) {
      if(nums[i] >= nums[i+1])
        result += nums[i];
      else
        result -= nums[i];
    }
    return result;
  }

  public int[] toIntArray(String s) {
    int[] result = new int[s.length() + 1];
    int i = 0;
    for(char c : s.toCharArray()) {
      switch(c) {
        case 'I': result[i++] = 1; break;
        case 'V': result[i++] = 5; break;
        case 'X': result[i++] = 10; break;
        case 'L': result[i++] = 50; break;
        case 'C': result[i++] = 100; break;
        case 'D': result[i++] = 500; break;
        case 'M': result[i++] = 1000; break;
        default:
          return new int[0];
      }
    }
    result[result.length-1] = 0;
    return result;
  } 

  public static void main(String[] args) {
    Solution13 s13 = new Solution13();
    String s = "LVIII";
    int result = s13.romanToInt(s);
    System.out.println(result);
  }
}