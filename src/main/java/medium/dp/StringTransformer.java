package medium.dp;

public class StringTransformer {
    public static int minMoves(String s, String t) {
        int n = s.length();
        int[] diffs = new int[n];

        // Calculate the required increment for each position (modulo 10)
        for (int i = 0; i < n; i++) {
            int sDigit = s.charAt(i) - '0';
            int tDigit = t.charAt(i) - '0';
            diffs[i] = (tDigit - sDigit + 10) % 10;
        }

        int totalMoves = 0;
        int currentCarry = 0;

        // Greedily process from left to right
        for (int i = 0; i < n; i++) {
            // Apply the carry operation from the previous index
            int needed = (diffs[i] - currentCarry + 10) % 10;
            totalMoves += needed;
            currentCarry = needed;
        }

        return totalMoves;
    }

    public static void main(String[] args) {
        String s = "13471";
        String t = "59604";
        s="115";
        t="116";
        s="557";
        t="463";
        System.out.println("Expected Moves: " + minMoves(s, t)); // Outputs 9
    }
}
