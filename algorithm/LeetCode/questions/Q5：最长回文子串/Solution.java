class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        int len = s.length();
        for(int i=0 ; i<len ; i++) {
            int end = result.length()+i-1;
            for(int j=len-1 ; j>end ; j--) {
                String temp = s.substring(i, j+1);
                if(s.charAt(i) == s.charAt(j) && isPalindrome(temp)) {
                    result = temp;
                    break;
                }
            }
        }
        return result;
    }

    public boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    public static void main(String[] args) {
        String s = "a";
        String result = new Solution().longestPalindrome(s);
        System.out.println(result);
    }
}