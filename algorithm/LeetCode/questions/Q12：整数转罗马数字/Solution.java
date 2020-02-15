import java.util.ArrayList;

class Solution {
    private String[] nums = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private int[] vals = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public String intToRoman(int num) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0 ; i<vals.length ; i++) {
            if(num >= vals[i]) {
                int a = num / vals[i];
                result.add(a);
                result.add(i);
                num -= a * vals[i];
            }
        }
        System.out.println(result);
        int[] ansSeq = new int[result.size()];
        for(int i=0 ; i<ansSeq.length ; i++) {
            ansSeq[i] = result.get(i);
        }
        String ans = "";
        for(int i=1 ; i<ansSeq.length ; i+=2) {
            String single = getSingle(vals[ansSeq[i]]);
            ans += nums[ansSeq[i]];
            if(ansSeq[i-1] > 1) {
                int end = ansSeq[i-1];
                if(nums[ansSeq[i]].equals(single)) {
                    end -= 1;
                }
                for(int j=0 ; j<end ; j++) {
                    ans += single;
                }
            }
        }
        return ans;
    }

    String getSingle(int i) {
        if(i >= 1000) {
            return "M";
        } else if(i >= 100) {
            return "C";
        } else if(i >= 10) {
            return "X";
        } else {
            return "I";
        }
    }

    public static void main(String[] args) {
        int num = 58;
        String result = new Solution().intToRoman(num);
        System.out.println(result);
    }
}