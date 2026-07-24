import java.util.ArrayList;
import java.util.List;

public class StringEncodeAndDecode {

    public static void main(String[] args) {

        System.out.println(StringEncodeAndDecode.encode(List.of(new String[]{"Hello/;s", "world"}))) ;
        System.out.println(StringEncodeAndDecode.decode(StringEncodeAndDecode.encode(List.of(new String[]{"Hello/;s", "world"}))));
        System.out.println(StringEncodeAndDecode.decode1(StringEncodeAndDecode.encode1(List.of(new String[]{"", ""}))));

String s;
StringBuilder str = new StringBuilder();
str.append("Hello/;");
str.append("world");
System.out.println(str.toString());

    }
    public static String encode(List<String> stringList) {
        StringBuilder sb = new StringBuilder();
        for (String s : stringList) {
            int i = 0;
            while (i < s.length()) {
                if (s.charAt(i) == ';') {
                    sb.append("/;");
                }
                else if (s.charAt(i) == '/') {
                    sb.append("//");
                }
                else {
                    sb.append(s.charAt(i));
                }
                i++;
            }
            sb.append(";");
        }
        return sb.toString();

    }
    public static List<String> decode(String s) {
        List<String> decodedStrings = new ArrayList<>();

        StringBuilder currentString = new StringBuilder();

        decodedStrings.addAll(List.of(s.split(";")));

        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '/') {
                currentString.append(s.charAt(i + 1));
                i += 2;
            } else if (s.charAt(i) != ';') {
                currentString.append(s.charAt(i));
                i++;
            } else {
                decodedStrings.add(currentString.toString());
                currentString.setLength(0);
                i++;
            }
        }

        return decodedStrings;
    }

    public  static String encode1(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        if(strs ==null|| strs.size() == 0 )
            return null;
        if( strs.size() ==1)
            return strs.get(0);

        for (String s : strs) {

            sb.append(s.length()).append(s).append("#");

        }
        return sb.toString();

    }

    public  static List<String> decode1(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {

            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            j++;
            result.add(str.substring(j, j + length));
            i = j + length;
        }
        return result;

    }
}
