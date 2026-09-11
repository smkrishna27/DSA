package roku;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 2, 2, 3, 3, 3, 4}, 2)));

    }
    public static int[] topKFrequent(int[] nums, int k) {
       int[] res = new int[k];
      HashMap<Integer, Integer> map = new HashMap<>();
      for (int num : nums) {
          map.put(num, map.getOrDefault(num, 0) + 1);
      }
      PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(((a, b) -> a.getValue() - b.getValue()));
      for (Map.Entry<Integer, Integer> set : map.entrySet()) {
          pq.offer(set);
          if (pq.size() > k) {
              pq.poll();
          }
      }
      for (int i = 0; i < k; i++) {
          res[i] = pq.poll().getKey();
      }


       return res;

    }
}
