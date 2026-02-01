package org.example.Study.linkedList;

public class BrokenNode {
    public static Ll broken(Ll node){
        Ll slow = node;
        Ll fast = node;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }

        if(fast == null || fast.next == null) return null;

        slow=node;
        while (slow != fast){
            slow=slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
