package javaImp;

/**
 * Solution121
 */
public class Solution121 {

  public int maxProfit(int[] prices) {
    if(prices == null || prices.length == 0)
      return 0;
    int buy = Integer.MAX_VALUE;
    int profit = 0;
    for(int price : prices) {
      if(price < buy) {
        buy = price;
      }
      else if(profit < (price -= buy)) {
        profit = price;
      }
    }
    return profit;
  }

  public static void main(String[] args) {
    Solution121 s121 = new Solution121();
    int[] prices = new int[]{7,1,5,3,6,4};
    int result = s121.maxProfit(prices);
    System.out.println(result);
  }
}