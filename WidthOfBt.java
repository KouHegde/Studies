package org.example.Study.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBt {

    class Pair {
        Node node;
        long index;
        Pair(Node n, long i) {
            node = n;
            index = i;
        }
    }

    public int maxWidth(Node root) {
        if (root == null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int maxWidth = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            long min = q.peek().index;
            long first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                long idx = p.index - min;

                if (i == 0) first = idx;
                if (i == size - 1) last = idx;

                if (p.node.leftNode != null)
                    q.add(new Pair(p.node.leftNode, 2 * idx + 1));
                if (p.node.rightNode != null)
                    q.add(new Pair(p.node.rightNode, 2 * idx + 2));
            }
            maxWidth = Math.max(maxWidth, (int)(last - first + 1));
        }
        return maxWidth;
    }
}
