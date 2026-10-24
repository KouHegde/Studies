package org.example.Study.linkedList;

public class MergeSortedList {
    public static Ll merge(Ll l1, Ll l2){
        if(l1 == null) return  l2;
        if(l2 == null) return l1;

        Ll dummy  = new Ll(0);
        Ll tail = dummy;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                tail.next = l1;
                l1 = l1.next;
            } else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if(l1 != null) tail.next = l2;
        else tail.next = l1;

        return dummy.next;
    }

}

