class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0)
            return 0;
        String trimedStr = trim(str);
        char c = trimedStr.charAt(0);
        if(!isSign(c) && !isDigit(c)) {
            return 0;
        }
        boolean isNeg = c == '-';
        if(isSign(c)) {
            trimedStr = trimedStr.substring(1);
        }
        int result = 0, ceil=Integer.MAX_VALUE/10;
        for(char next : trimedStr.toCharArray()) {
            if(!isDigit(next)) {
                break;
            }
            int x = next - '0';
            if(result > ceil)
                return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            if(result == ceil) {
                if(isNeg && x >= 8)
                    return Integer.MIN_VALUE;
                if(!isNeg && x >= 7)
                    return Integer.MAX_VALUE;
            }
            result = result * 10 + x;
        }
        return isNeg ? -result : result;
    }
    
    private String trim(String s) {
        char[] cs = s.toCharArray();
        for(int i=0 ; i<cs.length ; i++) {
            if(cs[i] != ' ')
                return s.substring(i);
        }
        return s;
    }

    private boolean isSign(char c) {
        return c == '+' || c == '-';
    }

    private boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    public static void main(String[] args) {
        String str = "";
        int result = new Solution().myAtoi(str);
        System.out.println(result);
    }
}