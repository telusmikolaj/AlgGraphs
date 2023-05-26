package com.telusmikolaj;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GraphFactroy {

    private static final Random random = new Random();

    private Graph graph;


    public Graph generateRandomGraph(int V) {
        graph = new Graph(V);
        int E = random.nextInt(V * (V - 1) / 2) + 1;
        for (int i = 0; i < E; i++) {
            drawRandomEdge(V);
        }
        return graph;
    }


    public void drawRandomEdge(int V) {
        int v;
        int w;

        do {
            v = random.nextInt(V);
            w = random.nextInt(V);
        } while (v == w);

        graph.addEdge(v, w);

    }

    public List<Graph> getGraphsList(int maxN, int minN, int minPowRange, int maxPowRange) {
        List<Graph> graphsList = new ArrayList<>();
        for (int i = minPowRange; i <= maxPowRange; i++) {
            int N = random.nextInt((maxN - minN) + 1) + minN;

            for (int j = 0; j < N; j++) {
                int V = (int) Math.pow(2, i);
                graphsList.add(generateRandomGraph(V));
            }

        }
        return graphsList;
    }
}
