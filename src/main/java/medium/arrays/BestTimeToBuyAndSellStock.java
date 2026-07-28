package medium.arrays;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {

        System.out.println(maxProfit(new int[]{10, 1, 5, 6, 7, 1}));

    }

    public static int maxProfit(int[] prices) {

        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);

            }

        }
        return maxProfit;


    }
}
