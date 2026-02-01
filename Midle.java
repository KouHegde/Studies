package org.example.Study.linkedList;

public class Midle {

    public static Ll middle(Ll head){
        Ll slow  = head;
        Ll fast  = head;

        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
