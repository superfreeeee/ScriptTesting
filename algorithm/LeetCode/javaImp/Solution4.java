package javaImp;

import java.util.Arrays;

/**
 * Solution5
 */
public class Solution4 {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int max = nums1.length + nums2.length;
    int[] nums3 = new int[max];
    for(int i=0 ; i<nums1.length; i++) {
      nums3[i] = nums1[i];
    }
    for(int i=0 ; i<nums2.length; i++) {
      nums3[nums1.length + i] = nums2[i];
    }
    Arrays.sort(nums3);

    System.out.println(Arrays.toString(nums3));

    if(max % 2 == 0) {
      int mid = max / 2;
      return (nums3[mid] + nums3[mid - 1]) / 2.0;
    }else {
      return nums3[max/2];
    }
  }

  public static void main(String[] args) {
    Solution4 s4 = new Solution4();
    int[] nums1 = {1,3,4};
    int[] nums2 = {2};
    double result = s4.findMedianSortedArrays(nums1, nums2);
    System.out.println(result);
  }
}