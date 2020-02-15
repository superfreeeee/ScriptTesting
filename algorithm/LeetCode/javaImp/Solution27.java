package javaImp;

import java.util.ArrayList;

/**
 * Solution27
 */
public class Solution27 {

  public int removeElement(int[] nums, int val) {
    int end = nums.length;
    int p = 0;
    while(p < end) {
      if(nums[p] == val)
        nums[p] = nums[(end--)-1];
      else
        p++;
    }
    return end;
  }

  public static void main(String[] args) {
    Solution27 s27 = new Solution27();
    int[] nums = new int[]{0, 1 ,2, 2, 3, 0, 4, 2};
    int val = 2;
    int result = s27.removeElement(nums, val);
    ArrayList<Integer> list = new ArrayList<>();
    for(int i=0 ; i<result ; i++)
      list.add(nums[i]);

    System.out.println(result);
    System.out.println(list);

  }
}