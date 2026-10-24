package org.example.Study.LeetCode;

import org.example.Study.Tree.MaxPathSum;

public class CameraTree {

    class Solution {

        int camera = 0;

        public int minCameraCover(MaxPathSum.TreeNode root) {

            if(dfs(root) == 0){
                camera++;
            }
            return camera++;

        }

        Integer dfs(MaxPathSum.TreeNode root){
            if(root == null) return 2;

            int left = dfs(root.left);
            int right = dfs(root.right);

            if(left == 0 || right == 0){
                camera++;
                return 1;
            }

            if(left == 1 || right == 1) return 2;

            return 0;

        }
    }
}
