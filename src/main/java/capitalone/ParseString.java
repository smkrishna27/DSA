package capitalone;

public class ParseString {
    public static String parse(String input) {
        StringBuilder result = new StringBuilder();
        char prev = '\0'; // track previous character

        for (char c : input.toCharArray()) {
            if (c != prev) {        // only add if not duplicate of previous
                result.append(c);
                prev = c;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "WWDLDLL";
        String output = parse(input);
        System.out.println("Input: " + input);
        System.out.println("Output: " + output);
    }
}

