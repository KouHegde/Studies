package org.example.Study.LeetCode;

public class TowerOfHanoi {
    public static void main(String[] args){
        int n = 3;
        Character t1 = 'A';
        Character t2 = 'B';
        Character t3 = 'C';

        calculate(n,t1,t2,t3);
    }

    private static void calculate(int n, Character t1, Character t2, Character t3) {
        if(n==0) return;

        calculate(n-1,t1,t3,t2);
        System.out.print(t1);
        System.out.println(t2);
        calculate(n-1,t3,t2,t1);
    }
}
