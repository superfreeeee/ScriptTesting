class Solution {
    public int romanToInt(String s) {
        int[] nums = stringToNums(s);
        int result = 0;
        for(int i=0 ; i<nums.length ; i++) {
            if(i < nums.length-1 && nums[i] < nums[i+1]) {
                result -= nums[i];
                result += nums[i+1];
                i++;
            } else {
                result += nums[i];
            }
        }
        return result;
    }

    private int[] stringToNums(String s) {
        int[] nums = new int[s.length()];
        for(int i=0 ; i<nums.length ; i++) {
            nums[i] = charToInt(s.charAt(i));
        }
        return nums;
    }

    private int charToInt(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }

    public static void main(String[] args) {
        String s = "LVIII";
        int result = new Solution().romanToInt(s);
        System.out.println(result);
    }
}