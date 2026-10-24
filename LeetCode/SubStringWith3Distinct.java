package org.example.Study.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class SubStringWith3Distinct {
    public static void main(String[] args) {
        String s = "abcabc";
        numberOfSubstrings(s);
    }

    public static int numberOfSubstrings(String s) {
        int[] charPos = new int[] {-1,-1,-1}; // start the position of a b c at -1
        int count  = 0;

        for(int i  = 0; i < s.length(); i++){
            charPos[s.charAt(i) - 'a']  = i; // get the latest char pos

            if(charPos[0] != -1 && charPos[1] != -1 && charPos[2] != -1 ){ // when all 3 elements are there increase the count + add the previous letter of the smallest index in the chars
                count = count + (1 + Math.min(charPos[0], Math.min(charPos[1],charPos[2])));
            }
        }
        return count;
    }
}
