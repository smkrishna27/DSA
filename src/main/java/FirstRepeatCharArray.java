import java.util.HashMap;
import java.util.Map;

public class FirstRepeatCharArray {

    public static void main() {
        FirstRepeatCharArray firstRepeatCharArray = new FirstRepeatCharArray();
        System.out.println(firstRepeatCharArray.firstRepeatingInteger(new Integer[]{1, 1, 3, 4, 5, 6, 7, 8, 9}));

    }

    int firstRepeatingInteger(Integer arrInt[]){

        Map<Integer, Integer> map = new HashMap<>(arrInt.length);

        for (int i = 0; i < arrInt.length; i++) {
            if (!map.containsKey(arrInt[i])) {
                map.put(arrInt[i], arrInt[i]);
            } else
            return map.get(arrInt[i]);
        }


       /* for(int j=0;j<arrInt.length;j++){
            for(int k=j+1;k<arrInt.length;k++){
                if(arrInt[j]==arrInt[k]){

                    return arrInt[j];
                }
            }
        }*/



        return 0;



    }
}
