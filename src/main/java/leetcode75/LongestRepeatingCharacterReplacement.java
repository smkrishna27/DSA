package leetcode75;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {

        System.out.println(characterReplacement("ABCABCBB", 2));

    }

    public static int characterReplacement(String s, int k) {
        if (s == null || s.isEmpty() || k == 0 || k > s.length()) {
            return 0;
        }
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxWindow = 0;
        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
            int windowLength = right - left + 1;

            if (windowLength - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            windowLength = right - left + 1;
            maxWindow = Math.max(maxWindow, windowLength);


        }
        return maxWindow;

    }

}
