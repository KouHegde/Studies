package org.example.Study.linkedList;

public class RemoveHeadFromNth {

    public Ll remove(Ll head, int n){
        Ll fast = head;

        for(int  i = 0 ; i<n ;i++){
            fast = fast.next;
        }

        if(fast == null) return head.next;

        Ll slow = head;

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
