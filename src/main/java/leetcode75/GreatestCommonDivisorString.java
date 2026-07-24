package leetcode75;

public class GreatestCommonDivisorString {

    public static void main(String[] args) {

        System.out.println(gcdOfStrings("ABCABC", "ABC"));
        System.out.println(gcdOfStrings("AAAAAB", "AAA"));

    }
    public static String gcdOfStrings(String str1, String str2) {
        if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty()) {
            return "";
        }
        if (str1.equals(str2)) {
            return str1;
        }
        if(!str1.concat(str2).equals(str2.concat(str1))){
            return "";
        }
        int len1 = str1.length();
        int len2 = str2.length();
        return str1.concat(str2).substring(0, gcd(len1, len2));


    }
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
