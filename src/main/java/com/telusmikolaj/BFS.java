package com.telusmikolaj;

import java.util.*;

public class BFS {

    private final boolean[] visited;
    private final Queue<Integer> toVisitQueue;
    private int[] prev;

    public BFS(Graph graph, int startV, int endV, Counter counter) {
        visited = new boolean[graph.numOfVerticies()];
        toVisitQueue = new PriorityQueue<>();
        prev = new int[graph.numOfVerticies()];

        System.out.println("start v: " + startV);
        System.out.println("end v: " + endV);

        performBFS(graph, startV, endV, counter);

    }

    public List<Integer> performBFS(Graph graph, int startV, int endV, Counter counter) {
        Arrays.fill(prev, -1);

        visited[startV] = true;
        counter.incrementVisitedCounter(graph.numOfVerticies());

        toVisitQueue.add(startV);
        while (!toVisitQueue.isEmpty()) {
            int currentV = toVisitQueue.poll();
            for (int v : graph.getNeighbors(currentV)) {
                if (!visited[v]) {
                    counter.incrementVisitedCounter(graph.numOfVerticies());
                    visited[v] = true;
                    prev[v] = currentV;
                    toVisitQueue.add(v);
                    if (v == endV) {
                        return constructPath(startV, endV);
                    }
                }
            }
        }
        counter.incrementNotFounded(graph.numOfVerticies());
        System.out.println("No path was found.");
        return new ArrayList<>();
    }

    private List<Integer> constructPath(int startV, int endV) {
        List<Integer> path = new ArrayList<>();
        for (int v = endV; v != -1; v = prev[v]) {
            path.add(v);
        }
        Collections.reverse(path);
        return printShorestPath(startV, endV, path);
    }

    private List<Integer> printShorestPath(int startV, int endV, List<Integer> path) {
//        System.out.println("Shorest path from: " + startV + " to " + endV);
//        path.forEach(v -> {
//            System.out.print("[" + v + "] -> ");
//        });
//        System.out.println("");
//        System.out.println("-------------------");
        return path;
    }
}
