package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> adj, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        for (int i=0; i<V; i++) {
            for (ArrayList<Integer> edge: adj) {
                int u = edge.get(0);
                int v = edge.get(1);
                int w = edge.get(2);

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        return dist;
    }
}
