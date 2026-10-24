package org.example.Study.LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public interface FirstUniqueNumber {

    public static int findFirstUniqueNumber(int [] nums){
        Map<Integer,Integer> map = new HashMap<>();
        Queue<Integer> q= new LinkedList<>();
        for(int num : nums){
            add(num,map,q);
        }

        return getFirstUnique(map,q);
    }

    static int getFirstUnique(Map<Integer, Integer> map, Queue<Integer> q) {
        while(!q.isEmpty() && map.get(q.peek()) > 1){
            q.poll();
        }
        return q.isEmpty() ? -1 : q.peek();
    }

    public static void add(int num,Map<Integer,Integer>  map, Queue<Integer> q){
        map.put(num,map.getOrDefault(num, 0 )+1);

        if(map.get(num) == 1){
            q.offer(num);
        }
    }
}
