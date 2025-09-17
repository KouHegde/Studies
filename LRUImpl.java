package org.example.Study.LRU;

import java.util.HashMap;
import java.util.Map;

public class LRUImpl {
    private final int capacity;
    private final Map<Integer,Node> map;
    int size;
    DoublyLinkedList doublyLinkedList;

    public LRUImpl(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.doublyLinkedList = new DoublyLinkedList();
    }

    public int get(int key){
        Node node = map.get(key);
        if(node==null) return -1;
        doublyLinkedList.moveNodeToFront(node);
        return node.value;
    }

    public void put(int key, int value){
        Node node  = map.get(key);
        if(node != null){
            node.value = value;
            doublyLinkedList.moveNodeToFront(node);
            return;
        }
        if(size == capacity){
            doublyLinkedList.removeNodeFromRear();
            map.remove(doublyLinkedList.getRearKey());
            size--;
        }
        Node newNode = new Node(key,value);
        doublyLinkedList.addNodeInFront(newNode);
        size++;
    }

}
