import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> result = new ArrayList<>();

        for(int LL=0 ; LL < nums.length-3 ; LL++) {
            for(int RR=nums.length-1 ; RR>=3 ; RR--) {
                if(RR - LL >= 3) {
                    System.out.println("traverse, LL = " + LL + ", RR = " + RR);
                    int L = LL + 1;
                    int R = RR - 1;
                    while(L < R) {
                        int sum = nums[LL] + nums[L] + nums[R] + nums[RR];
                        if(sum > target) {
                            R--;
                        } else if(sum < target) {
                            L++;
                        } else {
                            result.add(Arrays.asList(nums[LL], nums[L], nums[R], nums[RR]));
                            while(L < R && nums[L] == nums[L+1]) L++;
                            while(L < R && nums[R] == nums[R-1]) R--;
                            L++;
                            R--;
                        }
                    }
                }
                while(RR>=3 && nums[RR] == nums[RR-1]) RR--;
            }
            while(LL < nums.length-3 && nums[LL] == nums[LL+1]) LL++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,5,3,5,1,-5,1,-2};
        int target = 4;
        List<List<Integer>> result = new Solution().fourSum(nums, target);
        System.out.println(result);
    }
}