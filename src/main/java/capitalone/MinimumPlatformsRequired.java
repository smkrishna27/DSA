package capitalone;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumPlatformsRequired {

    public  int minimumPlatforms(int[] arrivals, int[] departures) {
        int n = arrivals.length;
        int result = 1;

        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int cnt = 1;
        int  i=1,j= 0;
       while (i < n && j < n) {
           if (arrivals[i] <= departures[j]) {
               cnt++;
               i++;
           }
           else if (arrivals[i] > departures[j]) {
               cnt--;
               j++;
           }
           result =Math.max(result, cnt);
       }
       return result;
    }


    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
       String s="bed";
       char[] ch= s.toCharArray();
        Arrays.sort(ch);
        String[] st= new String[]{"sts"};
        st = new String[]{"st"};
        System.out.println(st.length);

        System.out.println(new String(ch));
        MinimumPlatformsRequired obj = new MinimumPlatformsRequired();
        int[] arr = {901};
        int[] dep = {1004};
        System.out.println(obj.minimumPlatforms(arr, dep));
    }
}
