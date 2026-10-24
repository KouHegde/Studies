package org.example.Study.Tree;

import java.util.ArrayList;
import java.util.List;

public class Path {

    List<String> pathFinder(Node root){
        List<String> list = new ArrayList<>();
        path(root,list,"");
        return list;
    }

    private void path(Node root, List<String> list, String s) {
        if(root == null) return;

        s = s.isEmpty() ? String.valueOf(root.value) : s + String.valueOf(root.value);

        if(root.rightNode == null && root.leftNode == null){
            list.add(s);
            return;
        }
        path(root.leftNode,list,s);
        path(root.rightNode,list,s);

    }
}
