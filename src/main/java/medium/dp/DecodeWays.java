package medium.dp;

public class DecodeWays {

    public static void main(String[] args) {

        System.out.println(numDecoding("06"));

    }

    public static int numDecoding(String s) {

        int prev1 = s.charAt(0) != '0' ? 1 : 0;;
        int prev2 = 1;

        for (int i = 1; i < s.length(); i++) {
            int current = 0;
            char currentChar = s.charAt(i);
            char previousChar = s.charAt(i - 1);

            if (currentChar != '0') {
                current += prev1;

            }
            int twoDigit = (previousChar - '0') * 10 + (currentChar - '0');
            if (twoDigit >= 10 && twoDigit <= 26) {
                current += prev2;
            }

            prev2 = prev1;
            prev1 = current;

        }

        return prev1;

    }
}
