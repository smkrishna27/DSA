package practice1.string;

public class CharacterCountArray {

    public static void main(String[] args) {
        String str = "cabcAA";
        int[] freq = new int[256]; // ASCII size

        for (char c : str.toCharArray()) {
            freq[c]++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                System.out.println((char) i + " -> " + freq[i]);
            }
        }
    }
}
