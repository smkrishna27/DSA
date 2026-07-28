package practice1.string;

import java.util.stream.IntStream;

public class StringPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindromeStreams("madam"));
        System.out.println(isPalindromeStreams("ADDA"));

        System.out.println(isPalindrome("madam"));
        System.out.println(isPalindrome("ADEKDA"));

    }

    public static boolean isPalindromeStreams(String str) {

        return IntStream.range(0, str.length() / 2)
                .allMatch(i -> str.charAt(i) == str.charAt(str.length() - 1 - i));


    }

    public static boolean isPalindrome(String str) {

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;

        }

        return true;

    }
}
