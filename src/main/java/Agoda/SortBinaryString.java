package Agoda;

public class SortBinaryString {

    public static  String sortBinaryString(String s){
       int countZero=0;
       for(char c:s.toCharArray()){
           if(c=='0'){
               countZero++;
           }
       }
       int countOne=s.length()-countZero;
      return "0".repeat(countZero)+"1".repeat(countOne);

    }

    public static void main(String[] args) {
        System.out.println(sortBinaryString("01010111"));
        System.out.println(sortBinaryStringInPlace("01010111"));
    }

    public static String sortBinaryStringInPlace(String s){
        char[] arr = s.toCharArray();
        int left=0, right=arr.length-1;
        while(left<right){
            if(arr[left]=='1'&& arr[right]=='0'){
                char temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;
            } else if(arr[left]=='0'){
                left++;
            } else if(arr[right]=='1'){
                right--;
            }
        }

        return new String(arr);

    }
}
