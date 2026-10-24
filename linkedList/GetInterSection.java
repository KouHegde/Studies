package org.example.Study.linkedList;

public class GetInterSection {

    public static Ll getInterSection(Ll headA, Ll headB) {
        Ll a = headA;
        Ll b = headB;
        while(a!=b){
            a = (a==null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }
}
