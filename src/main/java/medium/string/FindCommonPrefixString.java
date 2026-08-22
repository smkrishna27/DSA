package medium.string;

public class FindCommonPrefixString {

    public static void main(String[] args) {

       System.out.println(findCommonPrefixstring(new String[]{"test", "tenth", "tmp"}));
        System.out.println(findCommonPrefixstring(new String[]{"test", "test"}));


    }

    public static String findCommonPrefixstring(String[] strs) {

        if (strs == null || strs.length == 0) return "";

        if (strs.length == 1) return strs[0];

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {

            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            if (prefix.isEmpty()) return "";


        }
        return prefix;

    }
}
