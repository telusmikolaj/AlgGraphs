package com.telusmikolaj;

import java.util.Random;
import java.util.stream.IntStream;

public class Graph {

    private final int V;
    private int E;
    private final LinkedList<Integer>[] adj;

    private int startV;

    private int searchedV;
    private static final Random random = new Random();

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = new LinkedList[V];
        IntStream.range(0, V).forEach(v -> adj[v] = new LinkedList<>());
        setRandomVertices(V);
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public int getNumOfEdges() {
        return E;
    }

    public LinkedList<Integer> getNeighbors(int v) {
        return this.adj[v];
    }
    public int numOfVerticies() {
        return V;
    }

    public void printGraph() {
        for (int v = 0; v < V; v++) {
            System.out.print("[" + v + "]" );
            adj[v].forEach(w -> System.out.print(" -> " + w));
            System.out.println("");
        }
    }

    private void setRandomVertices(int V) {
        this.startV = random.nextInt(V);
        int endV;
        do {
            this.searchedV = random.nextInt(V);
        } while (startV == searchedV);
    }

    public int getSearchedV() {
        return this.searchedV;
    }

    public int getStartV() {
        return this.startV;
    }
}
