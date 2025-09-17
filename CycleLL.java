package org.example.Study.LeetCode;

import org.example.Study.linkedList.Ll;
import org.example.Study.linkedList.Node;

public class CycleLL {

    public static boolean isCyclicLL(Ll head){
        if(head == null || head.next  == null) return false;

        Ll slow  = head;
        Ll fast  = head.next;

        while(slow != fast){
            if(fast == null || fast.next == null) return  false;

            slow = slow.next;
            fast= fast.next.next;
        }
        return true;
    }

    public static boolean isCyclicLL(Node head){
        if(head == null || head.next == null) return false;

        Node slow  = head;
        Node fast = head.next;

        while(slow != fast){
            if(fast == null || fast.next == null) return false;
            slow = slow.next;
            fast =fast.next.next;

        }
        return true;

    }
}
