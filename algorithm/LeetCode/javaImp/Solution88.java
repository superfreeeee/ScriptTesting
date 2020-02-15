package javaImp;

import java.util.Arrays;

/**
 * Solution
 */
public class Solution88 {

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int p1 = 0, p2 = 0;
    while(p2 < n) {
      // System.out.println(m + " " + n);
      // System.out.println(p1 + " " + p2);
      // System.out.println(Arrays.toString(nums1));

      if(p1 < m && nums1[p1] > nums2[p2]) {
        insert(p1, nums2[p2++], nums1);
        m++;
      }
      else if(p1 >= m) {
        while(p2 < n) 
          insert(p1++, nums2[p2++], nums1);
      }
      p1++;
    }
  }

  public void insert(int index, int num, int[] nums) {
    int temp;
    for(int i=index ; i<nums.length ; i++) {
      temp = nums[i];
      nums[i] = num;
      num = temp;
    }
  }

  public static void main(String[] args) {
    Solution88 s88 = new Solution88();
    int[] nums1 = {1, 2, 3,0,0,0};
    int[] nums2 = {1,2,3};
    int m = 3, n = 3;
    s88.merge(nums1, m, nums2, n);
    System.out.println(Arrays.toString(nums1));
  }
}