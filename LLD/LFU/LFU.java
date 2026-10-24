package org.example.Study.LLD.LFU;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFU<V> {

    Integer capacity;
    Integer minFrequency;
    Map<Integer,Node<String>> cache = new HashMap<>();
    Map<Integer, LinkedHashSet<Integer>> frequencyMap;

    public  LFU (int capacity){
        this.capacity = capacity;
        this.minFrequency = 0;
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }


    public V get(int key){
         Node node  = cache.get(key);

         if(node == null) return null;

         updateFrequency(node);

         return (V) node.value;

    }

    public void put(Integer key, String value){
        if(capacity == 0 ) return;
        Node node  = cache.get(key);
        if(node != null){
            node.value = value;
            updateFrequency(node);
            return;
        }

        if(cache.size() >= capacity){

            LinkedHashSet<Integer> minFreqSet = frequencyMap.get(minFrequency);

            int evictKey = minFreqSet.iterator().next();

            minFreqSet.remove(evictKey);

            if(minFreqSet.isEmpty()){
                frequencyMap.remove(minFrequency);
            }
            cache.remove(evictKey);
        }

        Node node1 = new Node(key,value);
        frequencyMap.computeIfAbsent(1, v-> new LinkedHashSet<>())
                .add(key);
        cache.put(key,node1);
        minFrequency =1;
    }

    private void updateFrequency(Node node) {
        int old = node.freq;
        LinkedHashSet<Integer> oldSet  = frequencyMap.get(old);

        oldSet.remove(node.key);
        if(oldSet.isEmpty()){
            frequencyMap.remove(old);
            if(minFrequency == old){
                minFrequency++;
            }
        }
        node.freq++;
        frequencyMap.computeIfAbsent(node.freq, v-> new LinkedHashSet<>()).add(node.key);
    }


}
