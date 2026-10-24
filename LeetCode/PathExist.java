package org.example.Study.LeetCode;

import java.util.*;

public class PathExist {
    int distance;
    class Coordinate{
        int x,y;
        Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    class Pair{
        Character name;
        Coordinate coordinate;
    }

    private int distanceBetweenPair(Pair A, Pair B){
        return distance;
    }

    public boolean pathExist(List<Pair> list, Pair source,Pair dest, int range){
        Queue<Pair> q = new LinkedList<>();
        Set<Character> visited = new HashSet<>();

        q.add(source);
        visited.add(source.name);

        while (!q.isEmpty()){
            Pair curr = q.poll();
            if(curr.name == dest.name) return true;
            for(Pair p: list){
                if(!visited.contains(p.name) && distanceBetweenPair(curr,p) <= range){
                    q.add(p);
                    visited.add(p.name);
                }

            }
        }
        return false;
     }


}
