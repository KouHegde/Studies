package org.example.Study.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LRUImpl{

    int size;
    private final  int capacity;
    private final Map<String, Node> hashMap;
    private final DoublyLinkedList list;


    public LRUImpl(int capacity) {
        this.capacity = capacity;
        this.hashMap = new HashMap<>();
        this.list = new DoublyLinkedList();
    }


    public int get(String key){
        Node node = hashMap.get(key);
        if(node == null){
            return -1;
        }
        list.moveNodeToFront(node);
        return node.value;

    }

    public void put(String key, int value){
        Node node = hashMap.get(key);
        if(node != null){
            list.moveNodeToFront(node);
            node.value = value;
            return;
        }
        if(size == capacity){
            String rearKey = list.getRearKey();
            list.removeNodeFromRear();
            hashMap.remove(rearKey);
            size--;
        }
        Node newNode = new Node(key,value);
        list.addNodeInFront(newNode);
        hashMap.put(key, newNode);
        size++;
    }




    private class Node{
        public String key;
        public int value;
        Node prev;
        Node next;

        public Node(String key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    public class DoublyLinkedList {
        Node front, rear;

        public void moveNodeToFront(Node node) {
            if (front == node) return;

            // detach node
            if (node.prev != null) node.prev.next = node.next;
            if (node.next != null) node.next.prev = node.prev;

            if (node == rear) rear = node.prev;

            // insert at front
            node.prev = null;
            node.next = front;
            if (front != null) front.prev = node;
            front = node;

            if (rear == null) rear = node; // list was empty
        }

        public void removeNodeFromRear() {
            if (rear == null) return;

            if (front == rear) {
                front = rear = null;
                return;
            }

            rear = rear.prev;
            rear.next = null;
        }

        public void addNodeInFront(Node node) {
            if (front == null) {
                front = rear = node;
                return;
            }
            node.next = front;
            front.prev = node;
            front = node;
        }

        public String getRearKey() {
            return rear.key;
        }
    }

}