package org.example.Study.Graphs;

import java.util.*;

public class DijkstraShortestPath {


    public int[] dijkstra(int source,WeightedGraph weightedGraph){
        int[] distance = new int[weightedGraph.getVertices().size()];
        Arrays.fill(distance,Integer.MAX_VALUE);

        PriorityQueue<GraphEdge> queue = new PriorityQueue<>(Comparator.comparingInt(GraphEdge::getWeight));
        distance[source] = 0;
        queue.add(new GraphEdge(source,source,0));

        while(!queue.isEmpty()){
            GraphEdge curr  = queue.poll();
            int destination  = curr.getDestination();

            for (GraphEdge edge : weightedGraph.getVertices().get(destination)){
                int newDistance  =  distance[destination] + edge.getWeight();

                if(newDistance < distance[edge.getDestination()]){
                    distance[edge.getDestination()] = newDistance;
                    queue.add(new GraphEdge(edge.getSource(),edge.getDestination(),newDistance));
                }
            }

        }
    return distance;

    }

}
