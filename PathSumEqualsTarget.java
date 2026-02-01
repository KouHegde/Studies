package org.example.Study.Tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumEqualsTarget {

    public static List<List<Integer>> pathSumEqualsTarget(Node root, int targetSum){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        traverse(root,targetSum,temp,result);
        return result;

    }

    private static void traverse(Node root, int targetSum, List<Integer> temp, List<List<Integer>> result) {
        if(root == null) return;

        targetSum -= root.value;  //6
        temp.add(root.value);     //1

        if(targetSum ==0){
            result.add(temp);
        }

        traverse(root.leftNode,targetSum,temp,result);
        traverse(root.rightNode,targetSum,temp,result);

        temp.remove(temp.size()-1);
    }

    /*

           1  target = 9. result. = [1,3,6] [1,4,5]
          /  \
         3     10
       /  \     \
      6    6     5
     */
}
