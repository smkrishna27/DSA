package leetcode75;

public class ReverseVowels {
    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));

    }
    public static String reverseVowels(String s) {
        if(s==null|| s.isEmpty()){
            return s;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length-1;
        while(left<right){
            if(!isVowel(chars[left])){ left++;
                continue;
            }
            if(!isVowel(chars[right])){ right--;}
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;

        }
        return String.valueOf(chars);

    }
    public static boolean isVowel(char c) {
        if(c=='a' || c =='e' || c=='i' || c=='o'|| c=='u') return true;
        return false;
    }
}
