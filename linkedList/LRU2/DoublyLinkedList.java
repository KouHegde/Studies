package org.example.Study.linkedList.LRU2;

public class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList(){
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);

        head.next = tail;
        tail.prev = head;
    }

    public void addInFront(Node node){
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
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
