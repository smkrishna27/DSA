package leetcode_75.medium;

public class ReverseWordsInaString {

    //Example 1:
//
//Input: s = "the sky is blue"
//Output: "blue is sky the"
//Example 2:
//
//Input: s = "  hello world  "
//Output: "world hello"
    public static void main(String[] args) {

        //System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("a good   example"));

    }


    public static String reverseWords(String s) {

        String[] words = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].equals(""))
                continue;
            else {
                sb.append(words[i])
                        .append(" ");
            }
        }
        return sb.toString().trim();


    }
}
