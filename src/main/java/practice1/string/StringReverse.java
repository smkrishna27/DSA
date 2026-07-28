package practice1.string;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringReverse {

    public static void main(String[] args) {

        String s = "Hello";
        System.out.println(reverseString(s));


    }


    public static String reverseString(String s) {

        char[] charArray = new char[s.length()];
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            charArray[left] = s.charAt(right);
            charArray[right] = s.charAt(left);
            left++;
            right--;
        }

        return new String(charArray);


    }
}
