package org.example.Study.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;


public class MedianOfStream {

    // Left heap should be a Max Heap (stores smaller half) - FIXED
    static PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());

    // Right heap should be a Min Heap (stores larger half) - FIXED
    static PriorityQueue<Integer> right = new PriorityQueue<>();

    public static void main(String[] args) {

        int[] nums = {5, 10, 2, 7, 1, 8, 9};

        for (int num : nums) {
            add(num);
            System.out.println("Inserted: " + num + ", Median = " + median());
        }

        System.out.println("\nRemoving medians:");

        while (size() > 0) {
            System.out.println("Removed: " + remove());
        }
    }

    public static void add(int n) {

        // First element always goes to left heap
        if (right.size() > 0 && n > right.peek()) {
            right.add(n);
        } else {
            left.add(n);
        }

        // Rebalance if right has two extra elements
        if (right.size() - left.size() == 2) {
            left.add(right.remove());
        }

        // Rebalance if left has two extra elements
        else if (left.size() - right.size() == 2) {
            right.add(left.remove());
        }
    }

    public static int remove() {

        if (size() == 0)
            return -1;

        // Remove from the heap having more elements
        if (left.size() >= right.size()) {
            return left.remove(); // CHANGED: >= instead of >
        } else {
            return right.remove();
        }
    }

    public static double median() {

        if (size() == 0)
            return -1;

        // If even number of elements, average both middle values
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        }

        // Otherwise median is the top of the larger heap
        return left.size() > right.size() ? left.peek() : right.peek();
    }

    public static int peek() {

        if (size() == 0)
            return -1;

        // Returns the lower median when sizes are equal
        if (left.size() >= right.size()) { // CHANGED: >= instead of >
            return left.peek();
        } else {
            return right.peek();
        }
    }

    public static int size() {
        return left.size() + right.size();
    }
}