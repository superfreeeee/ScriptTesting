package javaImp;

/**
 * Solution69
 */
public class Solution69 {

  public int mySqrt(int x) {
    if(x == 0)
      return 0;
    else
      return (int)sqrts(x, x);
  }

  public double sqrts(double x, double s) {
    double res = (x + s / x) / 2;
    if(res == x)
      return res;
    else
      return sqrts(res, s);
  }

  public static void main(String[] args) {
    Solution69 s69 = new Solution69();
    int x = 4;
    int result = s69.mySqrt(x);
    System.out.println(result);
  }
}