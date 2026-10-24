package org.example.Study.LLD.DepAn;

import java.util.*;

public class DependencyAnalyzer {

    private  final Map<Integer,Service> serviceMap;
    private final Map<Integer, List<Service>> dependencyGraph;
    private final Map<Integer,Integer> indegree;

    public DependencyAnalyzer() {
        this.indegree = new HashMap<>();
        this.serviceMap = new HashMap<>();
        this.dependencyGraph = new HashMap<>();
    }



    public void createServiceMap(Integer id, String name){
        Service service = new Service(id, name);
        serviceMap.put(id,service);
        dependencyGraph.put(id,new ArrayList<>());
        indegree.put(id,0);
    }

    public void createDependencyGraph(Service service, Service dependentService){
        dependencyGraph.computeIfAbsent(service.id,s -> new ArrayList<>())
                .add(dependentService);
        indegree.put(dependentService.id,indegree.getOrDefault(dependentService.id,0)+1);

    }

    public List<Service> getDependentService(Service service){
       return dependencyGraph.getOrDefault(service.id,new ArrayList<>());
    }

    public  Set<Integer> getImpactedServiceId(Service service){
        Set<Integer> impactedServiceIdSet = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        dfs(visited, service, impactedServiceIdSet);
        return  impactedServiceIdSet;
    }

    private void dfs(Set<Integer> visited, Service service, Set<Integer> impactedServiceIdSet) {
        if(visited.contains(service.id)) return;
        impactedServiceIdSet.add(service.id);
        visited.add(service.id);
        for(Service neighbors : dependencyGraph.get(service.id)){
            if(!visited.contains(neighbors.id)){
                dfs(visited,neighbors,impactedServiceIdSet);
            }
        }
    }

    private int getImpactDepth(Service service){
        Queue<Integer> q = new LinkedList<>();
        q.add(service.id);
        Set<Integer> visited = new HashSet<>();
        visited.add(service.id);
        int depth = 0;
        while(!q.isEmpty()){
            int size = q.size();
            depth++;
            for(int i = 0; i < size; i++){
                int curr = q.poll();
                for(Service neigh : dependencyGraph.get(curr)){
                    if(!visited.contains(neigh.id)){
                        visited.add(neigh.id);
                        q.add(neigh.id);
                    }
                }
            }
        }
        return  depth-1;
    }

    private List<Integer> getExecutionOrder(
            Map<Integer, List<Service>> dependencyGraph){

        Map<Integer, Integer> indegreeCopy =
                new HashMap<>(indegree);

        Queue<Integer> q = new LinkedList<>();

        for(Integer id : indegreeCopy.keySet()){

            if(indegreeCopy.get(id) == 0){
                q.add(id);
            }
        }

        List<Integer> executionOrder =
                new ArrayList<>();

        while(!q.isEmpty()){

            Integer curr = q.poll();

            executionOrder.add(curr);

            for(Service neigh :
                    dependencyGraph.get(curr)){

                int dependencyCount =
                        indegreeCopy.get(neigh.id);

                dependencyCount--;

                indegreeCopy.put(
                        neigh.id,
                        dependencyCount
                );

                if(dependencyCount == 0){
                    q.offer(neigh.id);
                }
            }
        }

        // Cycle detection
        if(executionOrder.size()
                != serviceMap.size()){

            throw new RuntimeException(
                    "Cycle detected"
            );
        }

        return executionOrder;
    }




}
