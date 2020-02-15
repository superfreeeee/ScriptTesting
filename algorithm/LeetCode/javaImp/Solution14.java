package javaImp;
/**
 * Solution14
 */
public class Solution14 {

  public String longestCommonPrefix(String[] strs) {
    String shortest = findShortest(strs);
    out:
    while(shortest.length() > 0) {
      for(String s : strs) {
        if(!s.startsWith(shortest)) {
          shortest = shortest.substring(0, shortest.length() - 1);
          continue out;
        }
      }
      break;
    }
    return shortest;
  }

  String findShortest(String[] strs) {
    if(strs == null || strs.length == 0)
      return "";
    String s = strs[0];
    for(int i=1 ; i<strs.length ; i++) 
      if(strs[i].length() < s.length())
        s = strs[i];
    return s;
  }

  public static void main(String[] args) {
    Solution14 s14 = new Solution14();
    String[] strs = new String[]{"aaaaa", "bbc", "aabc", "aaabcd"};
    String result = s14.longestCommonPrefix(strs);

    System.out.println(result);
  }
}