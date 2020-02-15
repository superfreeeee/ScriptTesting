import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    LinkedList<String> result = new LinkedList<>();
    LinkedList<Integer> left = new LinkedList<>();
    LinkedList<Integer> right = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        addLeft("", n, n);
        while(result.size() != 0) {
            int L = left.poll();
            int R = right.poll();
            if(L == 0 && R == 0) {
                break;
            }
            String base = result.poll();
            if(L != 0) {
                addLeft(base, L, R);
            }
            if(R > L) {
                addRight(base, L, R);
            }
        }
        System.out.println(result.size());
        return result;
    }

    private void addLeft(String base, int L, int R) {
        result.add(base + "(");
        left.add(L - 1);
        right.add(R);
    }

    private void addRight(String base, int L, int R) {
        result.add(base + ")");
        left.add(L);
        right.add(R - 1);
    }

    public static void main(String[] args) {
        int n = 4;
        List<String> result = new Solution().generateParenthesis(n);
        System.out.println(result);
    }

}