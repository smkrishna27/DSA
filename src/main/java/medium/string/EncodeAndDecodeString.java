package medium.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeString {


    public static void main(String[] args) {

    }


    public static String encode(List<String> strs) {

        if (strs.size() == 0) {
            return Character.toString((char) 258);
        }
        String separator = Character.toString((char) 257);
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
            sb.append(separator);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();

    }

    public static List<String> decode(String str) {

        if (str.equals(Character.toString((char) 258))) {
            return new ArrayList<>();
        }
        String separator = Character.toString((char) 257);
        return Arrays.asList(str.split(separator, -1));
    }
}
