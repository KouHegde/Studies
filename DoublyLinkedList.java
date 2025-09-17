package org.example.Study.LRU;

public class DoublyLinkedList {
    public Node front;
    public Node rear;

    public void moveNodeToFront(Node node){
        if(node == front) return;

        if(node.prev != null) node.prev.next = node.next;
        if(node.next != null) node.next.prev = node.prev;

        if(node == rear) rear = node.prev;

        node.prev = null;
        node.next = front;
        if(front != null) front.prev = node;
        front = node;

        if(rear == null) rear = node;

    }

    public void removeNodeFromRear(){
        if(rear == null) return;

        if(front == rear){
            front = rear = null;
        }

        rear = rear.prev;
        rear.next = null;

    }

    public void addNodeInFront(Node node){
        node.next= front;
        if (front != null) front.prev = node;
        node.prev = null;

    }

    public int getRearKey(){ return rear.key; }


}
