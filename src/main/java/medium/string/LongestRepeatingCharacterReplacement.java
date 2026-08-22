package medium.string;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {

        System.out.println(findLongestCharacterReplacement("AABAAB", 2));

    }

    public static int findLongestCharacterReplacement(String s, int k) {

        int[] count = new int[26]; // frequency of each character
        int left = 0, maxCount = 0, result = 0;

        for (int right = 0; right < s.length(); right++) {
            // update frequency of current character
            count[s.charAt(right) - 'A']++;
            // track the highest frequency in the window
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

            // if replacements needed exceed k, shrink window
            while ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // update maximum valid window size
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}

