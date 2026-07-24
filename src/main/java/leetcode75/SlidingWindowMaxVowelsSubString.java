package leetcode75;


public class SlidingWindowMaxVowelsSubString {
    public static void main(String[] args) {

        System.out.println(maxVowels("abciiidef",3));

    }

    public static int maxVowels(String s, int k) {
        int max;
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i)))
                count++;
        }
        max = count;

        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i)))
                count++;
            if (isVowel(s.charAt(i - k)))
                count--;
            max = Math.max(max, count);
        }
        return max;


    }

    public static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        return false;
    }


}
