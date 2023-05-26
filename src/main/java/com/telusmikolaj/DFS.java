package com.telusmikolaj;

public class DFS {

    private final boolean[] visited;

    public DFS(Graph graph, int startV, int endV, Counter counter) {
        visited = new boolean[graph.numOfVerticies()];
        if (!performDFS(graph, startV, endV, counter)) {
            counter.incrementNotFounded(graph.numOfVerticies());
        }

    }

    public boolean performDFS(Graph graph, int startV, int endV, Counter counter) {

        if (startV == endV) return true;


        if (!visited[startV]) counter.incrementVisitedCounter(graph.numOfVerticies());

        visited[startV] = true;


        for (int currentV : graph.getNeighbors(startV)) {
            if (!visited[currentV]) {
                if (performDFS(graph, currentV, endV, counter)) {
                    return true;
                }
            }
        }

        return false;
    }


}
