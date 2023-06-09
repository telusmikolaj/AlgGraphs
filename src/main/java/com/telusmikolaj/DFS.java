package com.telusmikolaj;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DFS {

    private final boolean[] visited;
    private final int[] prev;

    public DFS(Graph graph, int startV, int endV, Counter counter) {
        visited = new boolean[graph.numOfVerticies()];
        prev = new int[graph.numOfVerticies()];
        Arrays.fill(prev, -1);

        if (!performDFS(graph, startV, endV, counter)) {
            counter.incrementNotFounded(graph.numOfVerticies());
        } else {
            List<Integer> path = constructPath(startV, endV);
            // do something with path
        }
    }

    public boolean performDFS(Graph graph, int startV, int endV, Counter counter) {

        if (startV == endV) return true;

        visited[startV] = true;
        counter.incrementVisitedCounter(graph.numOfVerticies());

        for (int currentV : graph.getNeighbors(startV)) {
            if (!visited[currentV]) {
                prev[currentV] = startV;
                if (performDFS(graph, currentV, endV, counter)) {
                    return true;
                }
            }
        }

        return false;
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