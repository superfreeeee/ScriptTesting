import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] nums = new int[len];
        for(int i=0,j=0,k=0 ; i<len ; i++) {
            if(j == nums1.length) {
                while(k < nums2.length) {
                    nums[i++] = nums2[k++];
                }
            } else if (k == nums2.length) {
                while(j < nums1.length) {
                    nums[i++] = nums1[j++];
                }
            } else {
                if(nums1[j] <= nums2[k]) {
                    nums[i] = nums1[j++];
                } else {
                    nums[i] = nums2[k++];
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        return len % 2 == 0 ? (nums[len/2-1] + nums[len/2])/2.0 : nums[len/2];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        double result = new Solution().findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }
}