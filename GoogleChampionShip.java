package org.example.Study.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GoogleChampionShip {

    public static int f(int p1, int p2){
        return 1;
    }
    public static int championShip(int N){

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            list.add(i);
        }
        while(list.size()>1){
            List<Integer> next = new ArrayList<>();
            for(int i = 0 ; i < list.size()-1 ; i+=2){
                if((i +1 < list.size() )){
                    int p1 = list.get(i);
                    int p2 = list.get(i+1);

                    if(f(p1,p2) == 0){
                        list.add(p1);
                    } else{
                        list.add(p2);
                    }
                } else{
                    list.add(list.get(i));
                }
            }
            list = next;
        }
        return list.get(0);
    }
}
