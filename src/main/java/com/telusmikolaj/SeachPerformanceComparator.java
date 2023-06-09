package com.telusmikolaj;

import java.util.List;

public class SeachPerformanceComparator {


    private static final int MAX_N = 5;

    private static final int MIN_N = 3;

    private static final int MIN_POWER_RANGE = 4;

    private static final int MAX_POWER_RANGE = 10;
    private static final GraphFactroy graphFactroy = new GraphFactroy();
    private static final Counter counter = new Counter();

    private static final int BFS = 1;

    private static final int DFS = 2;
    public void compareAlgoritms() {

        List<Graph> graphs = graphFactroy.getGraphsList(MAX_N, MIN_N, MIN_POWER_RANGE, MAX_POWER_RANGE);

        performSearch(graphs, "DFS", DFS);
        counter.resetCounter();
        performSearch(graphs, "BFS", BFS);
    }


    private void performSearch(List<Graph> graphs, String title, int algorithm) {
        for (Graph graph : graphs) {
            counter.incrementN(graph.numOfVerticies());
            counter.setCurrentGraphSize(graph.numOfVerticies());
            //graph.printGraph();
            switch (algorithm) {
                case BFS -> new BFS(graph, graph.getStartV(), graph.getSearchedV(), counter);
                case DFS -> new DFS(graph, graph.getStartV(), graph.getSearchedV(), counter);
                default -> System.out.println("Invalid algorithm selected");
            }

        }

        printResult(title);

    }

    private void printResult(String title) {
        counter.printCounterResult(title);
    }


}
