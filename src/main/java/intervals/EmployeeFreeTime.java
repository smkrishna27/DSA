package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmployeeFreeTime {

    public static void main(String[] args) {
        //schedule = [[[2,4],[7,10]],[[1,5]],[[6,9]]]
        //op [(5,6)]

        int[][][] schedule = {{{2, 4}, {7, 10}}, {{1, 5}, {6, 9}}};

        for (int[] res : employeeFreeTime(schedule)) {
            System.out.println(Arrays.toString(res));
        }

    }

    public static int[][] employeeFreeTime(int[][][] schedule) {

        List<int[]> flattened = new ArrayList<>();
    // flattern arrays
        for (int[][] schedule1 : schedule) {
            flattened.addAll(Arrays.asList(schedule1));
        }
        flattened.sort((a, b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();
        int[] current = flattened.get(0);
        for (int i = 1; i < flattened.size(); i++) {
            if (flattened.get(i)[0] <= current[1]) {
                current[1] = Math.max(current[1], flattened.get(i)[1]);
            } else {
                merged.add(current);
                current = flattened.get(i);
            }
        }
        merged.add(current);
        List<int[]> result = new ArrayList<>();
        for (int i = 1; i < merged.size(); i++) {

            result.add(new int[]{merged.get(i - 1)[1], merged.get(i)[0]});

        }

        return result.toArray(new int[0][]);


    }
}
