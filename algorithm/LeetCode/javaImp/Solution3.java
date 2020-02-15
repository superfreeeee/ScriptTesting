package javaImp;

class Solution3 {
  public int lengthOfLongestSubstring(String s) {
    StringBuilder temp = new StringBuilder();
    int front;
    int result = 0;
    for(char c : s.toCharArray()) {
      if((front = temp.indexOf(c+"")) >= 0) {
        if(temp.length() > result) 
          result = temp.length();
        temp = new StringBuilder(temp.substring(front + 1));
      }
      temp.append(c);
      // System.out.println("\""+ temp +"\"");
    }
    return temp.length() > result ? temp.length() : result;
  }

  public static void main(String[] args) {
    Solution3 s3 = new Solution3();
    String s = "abcabcbai";
    int result = s3.lengthOfLongestSubstring(s);

    System.out.println(result);
  }
}