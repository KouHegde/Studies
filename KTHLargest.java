package org.example.Study.LeetCode;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KTHLargest {

    public  int Kth(int[] nums , int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0 ; i<k; i++){
            queue.add(nums[i]);
        }
        for(int i  = 2 ; i < nums.length; i++){
            if(queue.peek() < nums[i]){
                queue.poll();
                queue.add(nums[i]);
            }

        }
        return queue.poll();
    }



    public static int Kthj(int[] nums, int k){
        PriorityQueue<Integer> integers = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ; i< k ; i++){
            integers.add(nums[i]);
        }
        for(int i = k ; i < nums.length; i++){
            if(integers.peek() < nums[i] ){
                integers.poll();
                integers.add(nums[i]);
            }
        }
        return integers.poll();
    }

    public static int kth(int[] ints, int k){
        PriorityQueue<Integer> min= new PriorityQueue<>(Comparator.reverseOrder());
        for(int i  = 0; i<k ;i++){
            min.add(ints[i]);
        }
        for(int i = k; i < ints.length; i++ ){
            if(min.peek()> ints[i]){
                min.poll();
                min.add(ints[i]);
            }
        }
        return min.peek();
    }
}
