package javaImp;
/**
 * Solution155
 */
public class Solution155 {

  static class MinStack {
    /** initialize your data structure here. */
    public MinStack() {
      stack = new int[size];
      supportStack = new int[supportSize];
    }
    
    public void pushAll(int[] nums) {
      for(int num : nums)
        push(num);
    }

    public void push(int x) {
      ensureCapacity();
      stack[index++] = x;
      if(supportIndex < 1 || x <= supportStack[supportIndex-1]) {
        supportStack[supportIndex++] = x;
      }
    }
    
    public void pop() {
      index--;
      if(supportIndex >0 && stack[index] == supportStack[supportIndex-1])
        supportIndex--;
    }
    
    public int top() {
      return index > 0 ? stack[index-1] : -1;
    }
    
    public int getMin() {
      return supportIndex > 0 ? supportStack[supportIndex-1] : -1;
    }

    public String toString() {
      return "stack:   " + toString(stack, index) 
           + "support: " + toString(supportStack, supportIndex);
    }

    private String toString(int[] stack, int index) {
      StringBuilder string = new StringBuilder();
      string.append("[");
      for(int i=0 ; i<index ; i++) {
        string.append(stack[i]);
        string.append(", ");
      }
      string.replace(string.length()-2, string.length(), "]\n");
      return string.toString();
    }

    private int index = 0;
    
    private int size = 10;

    private int[] stack;

    private int supportIndex = 0;

    private int supportSize = 10;

    private int[] supportStack;

    private static final int extendtion = 10;

    private void ensureCapacity() {
      if(index == size) {
        int loaded = size;
        size += extendtion;
        int[] newStack = new int[size];
        for(int i=0 ; i<loaded ; i++)
          newStack[i] = stack[i];
        stack = newStack;
      }
      if(supportIndex == supportSize) {
        int loaded = supportSize;
        supportSize += extendtion;
        int[] newStack = new int[supportSize];
        for(int i=0 ; i<loaded ; i++)
          newStack[i] = supportStack[i];
        supportStack = newStack;
      }
    }
  }

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    int n;
    minStack.push(-2);
    System.out.println(minStack);

    minStack.push(0);
    System.out.println(minStack);

    minStack.push(-3);
    n = minStack.getMin();
    System.out.println(n);
    System.out.println(minStack);

    minStack.pop();
    System.out.println(minStack);

    n = minStack.top();
    System.out.println(n);
    System.out.println(minStack);

    n = minStack.getMin();
    System.out.println(n);
    System.out.println(minStack);

    int[] nums = new int[]{-3,-3,-3,-3,-3};
    minStack.pushAll(nums);
    System.out.println(minStack);
    minStack.pop();
    minStack.pop();
    minStack.pop();
    minStack.pop();
    System.out.println(minStack);
  }
}
