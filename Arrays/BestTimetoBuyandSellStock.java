//Problem : Best Time to Buy and Sell  Stock
//Approach : a greedy single-pass solution using a running minimum (prefix minimum) to compute the maximum difference.
//Time complexity : O(n)
//Space complexity : O(1)

public class BestTimetoBuyandSellStock {

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // best buying price so far
            } else {
                int profit = price - minPrice; // sell today
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // Example test case
        int[] prices = {7, 1, 5, 3, 6, 4};

        int result = maxProfit(prices);

        System.out.println("Maximum Profit: " + result);
    }
}

/*
Idea:
  Track minimum price so far
  At each step:
    Profit = current price - minSoFar
    Update max profit
*/
