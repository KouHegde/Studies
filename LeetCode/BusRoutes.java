package org.example.Study.LeetCode;

import java.util.*;

public class BusRoutes {
    class Solution {
        public int numBusesToDestination(int[][] routes, int source, int target) {
            if(source == target) return 0;

            Map<Integer, List<Integer>> map = new HashMap<>();

            for(int bus = 0; bus < routes.length; bus++){
                for(int stop : routes[bus]){
                    map.computeIfAbsent(stop,k -> new ArrayList<>())
                            .add(bus);
                }
            }

            Queue<Integer> q = new LinkedList<>();
            Set<Integer> visitedStops = new HashSet<>();
            q.add(source);
            visitedStops.add(source);
            int busses = 0;
            Set<Integer> visitedBusses = new HashSet<>();

            while(!q.isEmpty()){
                busses++;
                int size = q.size();

                for(int i = 0 ; i < size; i++){
                    int stop = q.poll();

                    List<Integer> bussesToStop = map.getOrDefault(stop,Collections.emptyList());

                    for(int bus : bussesToStop){

                        if(visitedBusses.contains(bus)) continue;

                        visitedBusses.add(bus);

                        for(int nextStop : routes[bus]){
                            if(nextStop == target) return busses;

                            if(!visitedStops.contains(nextStop)){
                                visitedStops.add(nextStop);
                                q.add(nextStop);
                            }
                        }

                    }
                }

            }
            return -1;



        }
    }
}
