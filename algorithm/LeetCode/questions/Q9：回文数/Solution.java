class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        int rx = reverse(x);
        return rx == x;
    }

    private int reverse(int x) {
        int rx = 0;
        while(x > 0) {
            rx = rx * 10 + x % 10;
            x /= 10;
        }
        return rx;
    }
    
    public static void main(String[] args) {
        int x = -101;
        boolean result = new Solution().isPalindrome(x);
        System.out.println(result);
    }
}