package org.example.Study.LeetCode;

public class ReOrganiseString {

    public static String reOrg(String s){
        int[] hash = new int[26];

        for(char ch : s.toCharArray()){
            hash[ch - 'a']++;
        }

        int max = 0;
        int letter = 0;

        for(int i = 0 ; i < hash.length; i++){
            if(max < hash[i]){
                max = hash[i];
                letter = i;
            }
        }

        // Important condition
        if(max > (s.length()+1)/2) return "";

        int idx  = 0;
        char[] ans  = new char[s.length()];

        // Fill most frequent char
        while(hash[letter]-- > 0){
            ans[idx] = (char) (letter + 'a');
            idx += 2;
        }

        // Fill remaining chars
        for(int i = 0 ; i < 26; i++){
            while(hash[i] > 0){
                if(idx >= ans.length) idx = 1;

                ans[idx] = (char)(i + 'a');
                idx += 2;
                hash[i]--;
            }
        }

        return String.valueOf(ans);
    }
}
