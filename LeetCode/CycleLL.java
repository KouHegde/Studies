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

    public static boolean cycleExit(Ll node){
        if(node == null || node.next == null) return false;

        Ll sl = node;
        Ll fast = node.next;

        while (sl != fast){
            if(fast == null && sl == null) return false;

            sl = sl.next;
            fast = fast.next.next;
        }
        return true;
    }
}
