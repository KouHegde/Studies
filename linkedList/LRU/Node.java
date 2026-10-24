package org.example.Study.linkedList.LRU;

public class Node {
    public int key;
    public int value;
    public Node next;
    public Node prev;

    public Node(int key , int value){
        this.key = key;
        this.value = value;
        next = null;
        prev = null;
    }
}
