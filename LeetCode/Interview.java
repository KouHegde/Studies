package org.example.Study.LeetCode;


/*
You are designing a simplified Infrastructure-as-Code (IaC) deployment engine for a cloud platform.

The engine provisions a set of cloud resources (such as networks, storage, compute, etc.).
Some resources depend on other resources being successfully created before they can be provisioned.

These dependencies form creation constraints: a resource must not be deployed until all of the resources it depends on are already deployed.

You are given:
- A collection of resources to be deployed
- A set of dependency relationships between them

Requirements

- Validate the Deployment
	- Determine whether the dependency configuration is valid.
	- If there is any circular dependency (direct or indirect), the deployment is invalid and cannot be completed.

- Generate a Deployment Plan
	- If the deployment is valid, produce one valid deployment plan — an ordered sequence in which resources can be created while respecting all dependencies.
	- If the deployment is invalid, indicate that no valid plan exists.

	1 -> 2
	2 -> 3
	3 -> 1

	1 -> 2
	2 -> 3
	3 -> 4

	4-> 3-> 2->1
 */

import java.util.*;

public class Interview {


    public static List<Integer> deploymentOrder(int[][] graph, int size) {

        int[] indegree = new int[size];
        List<List<Integer>> adj = getAdj(graph, size, indegree);

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            int currNode = q.poll();
            ans.add(currNode);

            for (int neigh : adj.get(currNode)) {
                indegree[neigh]--;

                if (indegree[neigh] == 0) {
                    q.add(neigh);
                }
            }
        }

        return ans.size() == size ? ans : new ArrayList<>();
    }


    public static List<List<Integer>> getAdj(int[][] graph, int size, int[] indegree) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : graph) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            indegree[v]++;
        }
        return adj;
    }





}
