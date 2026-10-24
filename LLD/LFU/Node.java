package org.example.Study.LLD.LFU;

public class Node<V> {
    int key;
    V value;
    int freq;

    public Node(Integer key, V value){
        this.key = key;
        this.value = value;
        this.freq = 1;
    }

}
