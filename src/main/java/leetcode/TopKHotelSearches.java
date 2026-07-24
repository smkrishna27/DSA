package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKHotelSearches {

    public static void main(String[] args) {
        String[] searches = {"Hilton","Marriott","Hilton","Hyatt","Marriott","Hilton","Taj"};
        System.out.println(TopKHotelSearches.topKFrequent(searches, 2));

    }

    public static List<String> topKFrequent(String[] searches, int k) {

        HashMap<String, Integer> map = new HashMap<>();
        for (String s : searches) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
       PriorityQueue<Map.Entry<String,Integer>> pq= new PriorityQueue<>((a,b)->a.getValue()-b.getValue());

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            pq.offer(entry);
            if(pq.size()>k) pq.poll();
        }

        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()){
            result.add(pq.poll().getKey());
        }
        return result;


    }
}
