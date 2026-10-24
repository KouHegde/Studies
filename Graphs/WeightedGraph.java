package org.example.Study.Graphs;


import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {
    int vertices;
    List<List<GraphEdge>> adjacencyList;

    public WeightedGraph(int vertices){
        this.vertices = vertices;
        adjacencyList = new ArrayList<>();
        for(int i  = 0; i<vertices;i++){
            adjacencyList.add(new ArrayList<>());
        }
    }
    public void addDirectedEdge(int source, int destination, int weight){
        GraphEdge edge = new GraphEdge(source, destination, weight);
        adjacencyList.get(source).add(edge);
    }
    public void addUnDirectedEdge(int source , int destination, int weight){
        GraphEdge edge1 = new GraphEdge(source, destination, weight);
        GraphEdge edge2 = new GraphEdge(destination, source,weight);
        adjacencyList.get(source).add(edge1);
        adjacencyList.get(destination).add(edge2);
    }
    public void removeAnDirectedEdge(int source , int destination){
        List<GraphEdge> neighbours = adjacencyList.get(source);
        neighbours.removeIf(n -> n.getSource() == source && n.getDestination() == destination);
    }

    public List<List<GraphEdge>> getVertices(){
        return adjacencyList;
    }
}
