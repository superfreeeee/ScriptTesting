import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int len = 0;
        List<Character> appeared = new LinkedList<>();
        for(char c : s.toCharArray()) {
            int index = appeared.indexOf(c);
            if(index != -1) {
                if(len > result) {
                    result = len;
                }
                len = appeared.size() - index - 1;
                appeared = new LinkedList<>(appeared.subList(index+1, appeared.size()));
            }
            appeared.add(c);
            len++;
        }
        if(len > result) {
            result = len;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "dvdf";
        int result = new Solution().lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}