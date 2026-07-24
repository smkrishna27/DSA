package practice1;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseString("hello"));

    }

    public static String reverseString(String str) {


        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;

        }
        return String.valueOf(chars);

    }
}
