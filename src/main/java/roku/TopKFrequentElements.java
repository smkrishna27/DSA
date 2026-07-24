package roku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class TopKFrequentElements {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(1);
        pq.offer(2);
        System.out.println(pq);
        pq.poll();
        System.out.println(pq);
    }
    public static int[] topKFrequent(int[] nums, int k) {
       int[] res = new int[k];
      HashMap<Integer, Integer> map = new HashMap<>();
      for (int num : nums) {
          map.put(num, map.getOrDefault(num, 0) + 1);
      }
      PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>();
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
