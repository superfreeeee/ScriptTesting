import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for(int i=0,len=nums.length, end=len-2 ; i<end ; i++) {
            int L = i+1;
            int R = len-1;
            int sum = result;
            System.out.println(i + " " + L + " " + R);
            while(L < R) {
                sum = nums[i] + nums[L] + nums[R];
                if(Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }
                if(sum == target) {
                    return target;
                } else if(sum > target) {
                    R--;
                } else {
                    L++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1};
        int target = 4;
        int result = new Solution().threeSumClosest(nums, target);
        System.out.println(result);
    }
}