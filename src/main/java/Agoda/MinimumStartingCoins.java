package Agoda;

public class MinimumStartingCoins {

    public static void main(String[] args) {
        //System.out.println(minimumCoins(new int[]{4, -2, -3, 1}));
        System.out.println(minimumCoins(new int[]{-3, 5, -2, 4, -6}));

    }

    public static int minimumCoins(int[] transactions) {
        int prefixSum = 0;
        int minPrefixSum = Integer.MAX_VALUE; // start very high

        for (int transaction : transactions) {
            prefixSum += transaction;
            minPrefixSum = Math.min(minPrefixSum, prefixSum);
        }

        // If minPrefixSum is negative, we need its absolute value
        return minPrefixSum < 0 ? -minPrefixSum : 0;
    }
}
