package leetcode75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StringCompression {

    public static void main(String[] args) {

        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
        System.out.println(compress(new char[]{'a'}));
        System.out.println(compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
        System.out.println(compress2(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));

        Test test = new Test(18, 2, 3);
        System.out.println(test.a());


    }

    public static int compress(char[] chars) {

        int write = 0;
        int read = 0;

        while (read < chars.length) {
            char currentChar = chars[read];
            int count = 0;

            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }

            chars[write++] = currentChar;

            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write; // length of compressed array

    }

    public static int compress2(char[] chars) {
        int count=1;
        StringBuilder s= new StringBuilder(String.valueOf(chars[0]));

        for (int i = 1; i < chars.length; i++) {
            char previousChar = chars[i-1];
            char currentChar = chars[i];
            if (previousChar == currentChar) {
                count++;
            } else  {
                if(count>1){
                    s.append(count);
                    count=1;
                }
                s.append(currentChar);
            }


        }
        if(count>1){
            s.append(count);
        }
        for(int j=0;j<s.length();j++){
            chars[j]=s.charAt(j);
        }
        return s.length();


    }
}
