package javaImp;

/**
 * Solution136
 */
public class Solution136 {

  public int singleNumber(int[] nums) {
    int result = 0;
    for(int num : nums)
      result ^= num;
    return result;
  }

  public static void main(String[] args) {
    Solution136 s = new Solution136();
    int[] nums = new int[]{4,1,2,1,2};
    // int[] nums = new int[]{4,1,2,1,2};
    int result = s.singleNumber(nums);
    System.out.println(result);
  }
}