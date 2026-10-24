package org.example.Study.linkedList.LRU2;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private final int capacity;
    private final Map<Integer,Node> map;
    private final DoublyLinkedList doublyLinkedList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.doublyLinkedList = new DoublyLinkedList();
    }


    public int get(int key){
        Node node = map.get(key);
        if(node == null ) return -1;
        doublyLinkedList.addInFront(node);
        return node.value;
    }


    public void put(int key, int value){
        Node node = map.get(key);
        if(node!=null){
            node.value = value;
            doublyLinkedList.remove(node);
            doublyLinkedList.addInFront(node);

        }else{
            if(map.size()==capacity){
                Node lru = doublyLinkedList.removeLast();
                if(lru!=null) map.remove(lru.key);
            }
            Node newNode = new Node(key,value);
            doublyLinkedList.addInFront(newNode);
            map.put(key,newNode);
        }
    }
}
