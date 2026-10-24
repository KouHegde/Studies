package org.example.Study.linkedList;

public class ReverseALinkedList {

    public static Ll reverse(Ll head){
        Ll prev  = null;
        Ll curr = head;

        while(curr!=null){
            Ll next = curr.next;
            curr.next = prev;
            prev = curr;
            curr= next;
        }
        return prev;
    }

}
