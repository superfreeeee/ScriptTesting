package javaImp;

/**
 * Solution122
 */
public class Solution122 {

  public int maxProfit(int[] prices) {
    int buy = Integer.MAX_VALUE;
    int rev = Integer.MAX_VALUE;
    int profit = 0;
    for(int price : prices) {
      if(rev > price) {
        profit += rev - buy;
        buy = price;
      }
      rev = price;
    }
    if(rev > buy)
      profit += rev - buy;
    return profit;
  }

  public int maxProfit2(int[] prices) {
    int profit = 0;
    for(int i=1 ; i<prices.length ; i++)
      if(prices[i-1] < prices[i])
        profit += prices[i] - prices[i-1];
    return profit;
  }

  public static void main(String[] args) {
    Solution122 s = new Solution122();
    // int[] prices = new int[]{7,1,5,3,6,4};
    int[] prices = new int[]{1,2,3,4,5};
    int result = s.maxProfit(prices);
    System.out.println(result);
  }
}