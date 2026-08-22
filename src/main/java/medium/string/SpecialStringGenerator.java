package medium.string;

public class SpecialStringGenerator {

    public static String generate(String input) {
        char[] output = input.toCharArray();
        int n = output.length;
        if (n == 0) return input;

        // Precompute where the trailing run of 'z' characters begins (if any).
        // e.g. "abzz" -> trailingZStart = 2 ; "abzcd" -> trailingZStart = -1 (last char isn't 'z')
        int trailingZStart = -1;
        if (output[n - 1] == 'z') {
            int start = n - 1;
            while (start > 0 && output[start - 1] == 'z') {
                start--;
            }
            trailingZStart = Math.max(start, 1); // index 0 is never triggered/modified
        }

        for (int i = 1; i < n; i++) {
            char cur = input.charAt(i);

            if (i == trailingZStart) {
                // Trailing-z trigger: fill from here to the end with alternating a,b,a,b...
                fillAlternating(output, i, n);
                return new String(output);
            } else if (cur == output[i - 1]) {
                // Repeat trigger: next letter after previous, then alternate after that
                output[i] = increment(output[i - 1]);
                fillAlternating(output, i + 1, n);
                return new String(output);
            } else {
                output[i] = cur; // no trigger yet, keep as-is
            }
        }

        // No trigger found anywhere -> increment the last character
        output[n - 1] = increment(output[n - 1]);
        return new String(output);
    }

    private static void fillAlternating(char[] arr, int start, int end) {
        char fill = 'a';
        for (int j = start; j < end; j++) {
            arr[j] = fill;
            fill = (fill == 'a') ? 'b' : 'a';
        }
    }

    private static char increment(char c) {
        return (c == 'z') ? 'a' : (char) (c + 1);
    }

    public static void main(String[] args) {
        System.out.println(generate("abc"));      // abd
        System.out.println(generate("abz"));      // aba
        System.out.println(generate("abzz"));     // abab
        System.out.println(generate("abbc"));     // abca
        System.out.println(generate("zabczz"));   // zabcab
        System.out.println(generate("abzcd"));    // abzce
        System.out.println(generate("zzz"));      // zab
        System.out.println(generate("aabzz"));    // ababa
    }

}
