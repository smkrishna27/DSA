package tesco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class CheapestPriceDijkstra {
    //n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]]
    //src = 0, dst = 2, K = 1
    //Use a min‑heap storing (cost, city, stops).
    //Pop cheapest option; if city == dst → return cost.
    //Push neighbors if stops ≤ K.
    //Time: O(E log V), Space: O(V + E).
    //More efficient for sparse graphs.
    public static void main(String[] args) {

        System.out.println(findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));
        System.out.println(findCheapestPriceB(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));

    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], l -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});//key=from flight, valueslist dest and cost;

        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, src, 0});// cost,city,stops
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0], city = cur[1], stop = cur[2];
            if (city == dst) {
                return cost;
            }
            if (stop > k) continue;
            if (!graph.containsKey(city)) continue;
            for (int[] flight : graph.get(city)) {
                pq.offer(new int[]{cost + flight[1], flight[0], stop + 1});
            }

        }
        return -1;

    }
    //. Bellman‑Ford Variant
    //Relax edges up to K+1 times (since K stops = K+1 edges).
    //
    //Each iteration updates costs using previous iteration’s values (to avoid chaining within same round).
    //
    //Time: O(K × E), Space: O(n).
    //
    //Works well when graph is dense.

    public static int findCheapestPriceB(int n, int[][] flights, int src, int dst, int K) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i <= K; i++) {
            int[] temp = Arrays.copyOf(dist, n);
            for (int[] f : flights) {
                int u = f[0], v = f[1], w = f[2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < temp[v]) {
                    temp[v] = dist[u] + w;
                }
            }
            dist = temp;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
