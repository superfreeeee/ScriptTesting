package javaImp;

import java.util.ArrayList;

/**
 * Solution26
 */
public class Solution26 {

  public int removeDuplicates(int[] nums) {
    if(nums == null)
      return 0;
    else if(nums.length <= 1)
      return nums.length;

    int count = 1;
    int point = 1;
    int rev = nums[0];
    while(point < nums.length) {
      // System.out.println(count + " " + point + " " + rev);
      // System.out.println(Arrays.toString(nums));

      if(rev == nums[point])
        point++;
      else 
        rev = nums[count++] = nums[point];
    }
    return count;
  }

  public static void main(String[] args) {
    Solution26 s26 = new Solution26();
    int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    int result = s26.removeDuplicates(nums);
    ArrayList<Integer> print = new ArrayList<>();
    for(int i=0 ; i<result ; i++) {
      print.add(nums[i]);
    }
    System.out.println(print);
  }
}