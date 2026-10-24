package org.example.Study.LLD.LRU;

public class DoublyLinkedList {
    Node tail;
    Node head;

    public DoublyLinkedList(){
        tail = new Node(-1,-1);
        head = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }


    public void addToFront(Node node){
        Node next = head.next;

        node.next = next ;
        next.prev = node;

        node.prev = head;
        head.next = node;
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public Node removeLast(){
        if(tail.prev == head) return null;

        Node lru = tail.prev;
        remove(lru);
        return lru;
    }



}
