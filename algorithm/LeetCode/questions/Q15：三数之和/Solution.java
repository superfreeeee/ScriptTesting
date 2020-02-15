import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if(len == 0) {
            return result;
        }
        Arrays.sort(nums);
        System.out.println("sort over");
        if(nums[0] <= 0 && nums[len-1] >= 0) {
            for(int i=0,end=len-2 ; i<end ; i++) {
                if(nums[i] > 0) {
                    break;
                }
                if(i > 0 && nums[i] == nums[i-1]) {
                    continue;
                }
                int L = i+1;
                int R = len-1;
                while(L < R) {
                    if(nums[R] < 0) {
                        break;
                    }
                    int temp = nums[L] + nums[R] + nums[i];
                    if(temp == 0) {
                        List<Integer> target = new ArrayList<>(Arrays.asList(nums[L], nums[R], nums[i]));
                        result.add(target);
                        while(L < R && nums[L] == nums[L + 1]) L++;
                        while(L < R && nums[R] == nums[R - 1]) R--;
                        R--;
                        L++;
                    } else if(temp > 0) {
                        R--;
                    } else {
                        L++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // int[] nums = new int[]{-1,0,1,2,-1,-4};
        int[] nums = new int[]{-2,0,0,2,2};
        List<List<Integer>> result = new Solution().threeSum(nums);
        System.out.println(result);
    }
}