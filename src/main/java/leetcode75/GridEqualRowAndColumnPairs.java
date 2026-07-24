package leetcode75;

import java.util.HashMap;
import java.util.Map;

public class GridEqualRowAndColumnPairs {
    public static void main(String[] args) {

    }
    public static int equalRowAndColumnPairs(int[][] grid) {

        int res = 0;
        Map<String, Integer> rowsMap = new HashMap<>();
        Map<String, Integer> columnsMap = new HashMap<>();
        for(int[] row: grid){
            StringBuilder rowStr = new StringBuilder();
           for(int i: row){
               rowStr.append(i).append("_");
           }
           rowsMap.put(rowStr.toString(), rowsMap.getOrDefault(rowStr.toString(), 0) + 1);
        }
        for (int i=0;i<grid.length;i++) {
            StringBuilder columnStr = new StringBuilder();
            for (int[] ints : grid) {
                columnStr.append(ints[i]).append("_");
            }
            columnsMap.put(columnStr.toString(), columnsMap.getOrDefault(columnStr.toString(), 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : rowsMap.entrySet()) {
            String key = entry.getKey();
            if(columnsMap.containsKey(key)){
                res+=columnsMap.get(key)*entry.getValue();
            }
        }


        return  res;
    }
}
