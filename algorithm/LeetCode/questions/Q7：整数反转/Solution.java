class Solution {
    public int reverse(int x) {
        boolean isNeg = x < 0;
        if(isNeg) x = -x;
        String s = String.valueOf(x);
        s = new StringBuilder(s).reverse().toString();
        try {
            int result = Integer.parseInt(s);
            return isNeg ? -result : result;
        } catch(Exception e) {
            return 0;
        }
    }
    
    public static void main(String[] args) {
        int x = -123;
        int result = new Solution().reverse(x);
        System.out.println(result);
    }
}