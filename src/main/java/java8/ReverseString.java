package java8;


public class ReverseString {

    public static void main(String[] args) {

        String str = "abcdefg";
        int  left = 0;
        int right = str.length() - 1;
        char[] chars = str.toCharArray();
        while(left < right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        System.out.println("before "+str+" reverse "+ String.valueOf(chars));


    }
}
