package medium.string;

public class ValidAnagram {

    public static void main(String[] args) {

        System.out.println(validAnagram("bat","tab"));
        System.out.println(validAnagram("cat","rat"));

    }

    public static boolean validAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;

        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0)
                return false;
        }

        return true;


    }
}
