package leetcode75;

public class ReverseWordsInString {
    public static void main(String[] args) {

       // System.out.println(reverseWords("Let's take LeetCode contest"));
        System.out.println(reverseWords("a good   example"));
    }
    public  static String reverseWords(String s) {
        String [] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i= words.length-1;i>=0;i--){
           if(!words[i].isEmpty()) {
               sb.append(words[i].trim());
               if (i > 0) sb.append(" ");
           }
        }
        return sb.toString().trim();
    }
}
