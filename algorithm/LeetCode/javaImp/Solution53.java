package javaImp;

/**
 * Solution53
 */
public class Solution53 {

  public int maxSubArray(int[] nums) {
    int ans = nums[0];
    int sum = 0;
    for(int num: nums) {
      if(sum > 0)
        sum += num;
      else
        sum = num;
      ans = sum > ans ? sum : ans;
    }
    return ans;
  }
}