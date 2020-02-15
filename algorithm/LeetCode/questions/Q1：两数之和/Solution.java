import java.util.Arrays;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0, max = nums.length-1 ; i<max ; i++) {
            for(int j=i+1 ; j<nums.length ; j++) {
                int result = nums[i] + nums[j];
                if(result == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] result = new Solution().twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}