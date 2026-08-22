package medium.string;

public class ValidPalindrome {


    public static void main(String[] args) {

        System.out.println(isValidPalinDrome("Was it a car or a cat I saw?"));

        System.out.println(isValidPalinDrome("was it a car or a cat i saw?"));


    }

    public static boolean isValidPalinDrome(String s) {

        int left = 0, right = s.length() - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left))!= Character.toLowerCase(s.charAt(right)))
                return false;

            left++;
            right--;


        }

        return true;


    }
}
