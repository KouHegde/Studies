package org.example.Study.Graphs;

public class GraphEdge {

    private int source;
    private int destination;
    private int weight;

    public GraphEdge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    public int getSource(){
        return source;
    }

}
