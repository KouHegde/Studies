package org.example.Study.linkedList;

public class AddTwoNumberInLL {
    static class LinkedList{
        LinkedList next;
        int value;

        public LinkedList(LinkedList n, int v){
            this.next = n;
            this.value = v;
        }
    }

    public static LinkedList sum(LinkedList l1,LinkedList l2){
        LinkedList ans = new LinkedList(null,0);
        LinkedList ansPointer = ans;

        int carry = 0;

        while(l1 != null || l2 != null){
            int sum = 0;
            sum += carry;

            if(l1 != null){
                sum+= l1.value;
                l1 = l1.next;
            }
            if(l2 != null){
                sum+= l2.value;
                l2 = l2.next;
            }

            int ansVal = sum%10;
            carry = sum/10;
            ansPointer.next = new LinkedList(null,ansVal);
            ansPointer = ansPointer.next;
        }
        if(carry != 0){
            ansPointer.next = new LinkedList(null,carry);
        }
        return ans.next;
    }

}
