package leetcode75;

public class MergeStringAlternately {

    public static void main(String[] args) {

        System.out.println(merge("TEST","BALL"));
        System.out.println(merge("HELLO","BYE"));
        System.out.println(merge("BYE","HELLO"));

    }
    public static String merge(String A, String B) {
        if (A.isEmpty() || B.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int maxLen = Math.max(A.length(), B.length());
        for (int i = 0; i <= maxLen; i++) {
            if (i < A.length()) sb.append(A.charAt(i));
            if (i < B.length()) sb.append(B.charAt(i));
        }
        return sb.toString();
    }
}
