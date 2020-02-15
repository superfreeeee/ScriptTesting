import java.util.ArrayList;
import java.util.List;

class Solution {
    private static String[] buttoms = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> words = new ArrayList<>();
        for(char c : digits.toCharArray()) {
            words.add(buttoms[c - '0' - 2]);
        }
        List<String> result = new ArrayList<>();
        for(char c : words.get(0).toCharArray()) {
            result.add(String.valueOf(c));
        }
        for(int i=1,endi=words.size() ; i<endi ; i++) {
            String word = words.get(i);
            List<String> next = new ArrayList<>();
            for(char c : word.toCharArray()) {
                for(String cur : result) {
                    next.add(cur + c);
                }
            }
            result = next;
        }
        return result;
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> result = new Solution().letterCombinations(digits);
        System.out.println(result);
    }
}