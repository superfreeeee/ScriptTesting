class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length <= 0) {
            return "";
        }
        String pre = findShortest(strs);
        for(int i=0 ; pre.length() > 0 && i<strs.length ; i++) {
            if(!strs[i].startsWith(pre)) {
                pre = pre.substring(0, pre.length()-1);
                i = -1;
            }
        }
        return pre;
    }

    private String findShortest(String[] strs) {
        String shortest = strs[0];
        for(String s : strs) {
            if(s.length() < shortest.length()) {
                shortest = s;
            }
        }
        return shortest;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"babb", "caa"};
        String result = new Solution().longestCommonPrefix(strs);
        System.out.println(result);
    }
}