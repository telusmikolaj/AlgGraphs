package com.telusmikolaj;

import java.util.PriorityQueue;
import java.util.Queue;

public class BFS {

    private final boolean[] visited;

    private final Queue<Integer> toVisitQueue;

    public BFS(Graph graph, int startV, int endV, Counter counter) {
        visited = new boolean[graph.numOfVerticies()];
        toVisitQueue = new PriorityQueue<>();


        if (!performBFS(graph, startV, endV, counter)) {
            counter.incrementNotFounded(graph.numOfVerticies());
        }
    }

    public boolean performBFS(Graph graph, int startV, int endV, Counter counter) {

        visited[startV] = true;
        counter.incrementVisitedCounter(graph.numOfVerticies());

        toVisitQueue.add(startV);
        while (!toVisitQueue.isEmpty()) {
            int currentV = toVisitQueue.poll();
            for (int v : graph.getNeighbors(currentV)) {
                if (!visited[v]) {
                    counter.incrementVisitedCounter(graph.numOfVerticies());
                    visited[v] = true;
                    toVisitQueue.add(v);
                    if (visited[endV]) {
                        return true;
                    }
                }
            }
        }

        return visited[endV];

    }
}
