package javaImp;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Solution10
 */
public class Solution10 {

  public boolean isMatch(String s, String p) {
    C[] patterns = compile(p);
    char[] string = s.toCharArray();
    System.out.println(Arrays.toString(patterns));

    int pc = 0, ps = 0;
    int lc = patterns.length, ls = string.length;
    while(pc < lc && ps < ls) {
      C pattern = patterns[pc];
      if(pattern.sign == '*') {
        if(pattern.value != '.' && string[ps] != pattern.value) {
          pc++;
          continue;
        }
        else {
          while(pc < lc && ps < ls && (pattern.value == '.' || string[ps] == pattern.value)) {
            ps++;
          };
          pc++;
        }
      }else {
        if(pattern.value == '.' || string[ps] == pattern.value) {
          pc++; ps++;
        }
        else 
          return false;
      }
    }
    if(pc == lc && ps == ls)
      return true;
    else return false;
  }

  public C[] compile(String pattern) {
    char[] c = pattern.toCharArray();
    int p = 0, max = c.length;
    char value, sign;
    ArrayList<C> cs = new ArrayList<>();
    while(p < max) {
      value = c[p++];
      sign = 0;
      if(p < max && c[p] == '*')
        sign = c[p++];
      cs.add(new C(value, sign));
    }
    return cs.toArray(new C[0]);
  }
  
  public static void main(String[] args) {
    Solution10 s10 = new Solution10();
    String s = "aab";
    String p = "c*a*b";
    boolean result = s10.isMatch(s, p);
    System.out.println(result);
  }
}

class C {

  char value;

  char sign;

  public C(char v, char s) {
    // System.out.println("new: " + v + ", " + s);
    this.value = v;
    this.sign = s;
  }

  public String toString() {
      return "[ value: " + this.value + ", sign: " + this.sign + " ]\n";
  }
}