package org.example.Study.LLD.LRU;

import java.util.HashMap;
import java.util.Map;

public class LRU {

    public LRU(int capacity) {
        this.capacity = capacity;
        this.doublyLinkedList = new DoublyLinkedList();
        this.cache = new HashMap<>();

    }

    private final int capacity;
    private final DoublyLinkedList doublyLinkedList;
    private final Map<Integer,Node> cache;


    public Integer get(int key){
        if(cache.get(key) == null) return -1;

        Node node = cache.get(key);
        doublyLinkedList.remove(node);
        doublyLinkedList.addToFront(node);
        return node.value;
    }


    public void put(int key, int value){

        if(cache.get(key) != null){
            Node node = cache.get(key);
            node.value = value;
            doublyLinkedList.remove(node);
            doublyLinkedList.addToFront(node);
            return;
        }

        if(cache.size() >= capacity){
            Node lru = doublyLinkedList.removeLast();
            cache.remove(lru.key);
        }

        Node newNode = new Node(key, value);
        doublyLinkedList.addToFront(newNode);
        cache.put(key,newNode);
    }


}
