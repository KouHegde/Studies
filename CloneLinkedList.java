package org.example.Study.LeetCode;

import org.example.Study.linkedList.Node;

public class CloneLinkedList {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.random = head.next; // 1 -> 2
        head.next.random = head; // 2 -> 1
        head.next.next.random = head.next; // 3 -> 2

        Node clonedHead = cloneLinkedList(head);

    }

    public static Node cloneLinkedList(Node head) {
        if (head == null) return null;

        Node curr  = head;

        while(curr != null){
            Node newNode   = new Node(curr.data);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;

            }
            curr = curr.next.next;
        }
        curr = head;
        Node newHead = curr.next;
        Node newCurr = curr.next;

        while(curr != null){
            curr.next = newHead.next;
            curr = curr.next;
            if(newCurr != null){
                newCurr.next = curr.next;
                newCurr = newCurr.next;
            }
        }
        return newHead;
    }









    public static Node cloneL(Node head){
        Node curr  = head;

        while(curr.next != null){
            Node newNode = new Node(curr.data);
            newNode.next = curr.next;
            curr.next = newNode;
            curr= curr.next.next;
        }

        curr  = head;

        while(curr.next != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
        }
        curr = head;
        Node newHead = curr.next;
        Node newCurr = curr.next;

        while(curr.next != null){
            curr.next = newHead.next;
            curr = curr.next;
            while (newCurr.next != null){
                newCurr.next = curr.next;
                newCurr = newCurr.next;
            }
        }

     return  newHead;
    }


    public Node cloneLinked(Node head){
        Node curr = head;



        while(curr.next != null){
            Node newNode= new Node(curr.data);
            curr.next = newNode;
            newNode.next=curr.next;
            curr = curr.next.next;
        }

        while(curr.next !=null){
            if(curr.random != null ){
                curr.next.random = curr.random.next;
            }
        }

        curr = head;
        Node newNode = curr.next;
        Node newCurr = curr.next;

        while(curr.next != null){
            curr.next = newNode.next;
            curr = curr.next;
            while(newCurr.next != null){
                newCurr.next =curr.next;
                newCurr = newCurr.next;
            }
        }
        return newNode;
    }




































}
