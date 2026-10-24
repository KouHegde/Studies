package org.example.Study.Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindRepeatedDNASequence {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        for(int i=0 ; i <= s.length()-10; i++){
            String sub = s.substring(i,i+10);
            if(!seen.add(sub)){
                repeated.add(sub);
            }else{
                seen.add(sub);
            }
        }
        return new ArrayList<>(repeated);

    }
}
