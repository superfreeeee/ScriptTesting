import java.util.LinkedList;

class Solution {
    public boolean isValid(String s) {
        int[] stack = new int[s.length()];
        int top = -1;
        for(char c : s.toCharArray()) {
            switch(c) {
                case '(': stack[++top] = 0; break;
                case '[': stack[++top] = 1; break;
                case '{': stack[++top] = 2; break;
                case ')': 
                    if(top < 0 || stack[top--] != 0)
                        return false;
                    break;
                case ']': 
                    if(top < 0 || stack[top--] != 1)
                        return false;
                    break;
                case '}': 
                    if(top < 0 || stack[top--] != 2)
                        return false;
                    break;
            }
        }
        return top == -1;
    }

    public static void main(String[] args) {
        String s = "{{}}";
        boolean result = new Solution().isValid(s);
        System.out.println(result);
    }
}