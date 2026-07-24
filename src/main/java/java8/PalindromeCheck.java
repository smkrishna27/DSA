package java8;

import java.util.stream.IntStream;

public class PalindromeCheck {
    public static void main(String[] args) {
        String s="madam";
        System.out.println(palindromeCheck(s));
        s="madams";
        System.out.println(palindromeCheck(s));

    }

    static boolean palindromeCheck(String s){
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;right--;
        }
        return true;
    }
}
