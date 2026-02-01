package org.example.Study.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class CreateBinaryTreeFromLevelArray {
    public Node buildTreeLO(int[] nums) {
        if (nums.length == 0) return null;

        int idx = 0;
        Node root = new Node(nums[idx++]);

        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty() && idx < nums.length) {

            Node curr = q.poll();


            if (idx < nums.length && nums[idx] != -1) {
                Node leftNode = new Node(nums[idx]);
                curr.leftNode = leftNode;
                q.add(leftNode);
            }
            idx++;


            if (idx < nums.length && nums[idx] != -1) {
                Node rightNode = new Node(nums[idx]);
                curr.rightNode = rightNode;
                q.add(rightNode);
            }
            idx++;
        }

        return root;
    }

    int idx = 0;

    public Node buildTreePreOrder(int[] nums){


        if(idx >= nums.length) return null;

        if(nums[idx] == -1) {
            idx++;
            return null;
        }

        Node root  = new Node(nums[idx++]);
        root.leftNode = buildTreePreOrder(nums);
        root.rightNode = buildTreePreOrder(nums);
        return root;
    }
}
