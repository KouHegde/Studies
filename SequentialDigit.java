package org.example.Study.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigit {

    public static List<Integer> seq(int low, int high){
        List<Integer> ans = new ArrayList<>();
        for(int  i = 1; i<=9; i++){
            rec(low,high,i,0,ans);
        }
        Collections.sort(ans);
        return ans;
    }

    private static void rec(int low, int high, int i, int num, List<Integer> ans) {
        if(num >= low && num <= high)
            ans.add(num);

        if(num > high || i >9)
            return;
        rec(low,high,i+1,num*10+i,ans);
    }
}
