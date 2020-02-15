package javaImp;

import java.util.LinkedList;

/**
 * Solution20
 */
public class Solution20 {

  public boolean isValid(String s) {
    LinkedList<String> stack = new LinkedList<>();
    for(char c : s.toCharArray()) {
      if(c == '(' || c == '{' || c == '[')
        stack.addFirst(c+"");
      else {
        String top = stack.pollFirst();
        if(top == null)
          return false;
        switch(c) {
          case ')':
            if(!top.equals("("))
              return false;
            break;
          case '}':
            if(!top.equals("{"))
              return false;
            break;
          case ']':
            if(!top.equals("["))
              return false;
            break;
          default:
            return false;
        }
      }
    }
    return stack.size() == 0;
  }

  public static void main(String[] args) {
    Solution20 s20 = new Solution20();
    String s = "([)]";
    boolean result = s20.isValid(s);
    System.out.println(result);
  }
}