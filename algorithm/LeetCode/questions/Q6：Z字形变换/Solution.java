import java.util.ArrayList;

class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1) {
            return s;
        }
        String[] ss = new String[numRows];
        for(int i=0 ; i<numRows ; i++) {
            ss[i] = "";
        }
        boolean goDown = true;
        int i = 0, lastL = ss.length-1;
        System.out.println(lastL);
        for(char c : s.toCharArray()) {
            ss[i] += c;
            i = goDown ? i+1 : i-1;
            if(i == lastL) {
                goDown = false;
            } else if(i == 0) {
                goDown = true;
            }
        }
        StringBuilder result = new StringBuilder();
        for(String temp : ss) {
            result.append(temp);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "A";
        int numRows = 1;
        String result = new Solution().convert(s, numRows);
        System.out.println(result);
    }
}