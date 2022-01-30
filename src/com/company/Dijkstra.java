package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
    int node;
    int distance;

    public Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    @Override
    public int compareTo(Pair o) {
        return this.distance < o.distance ? -1 : 1;
    }
}

class Dijkstra {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(S, 0));

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        while (!pq.isEmpty()) {
            Pair first = pq.poll();

            for (ArrayList<Integer> nei: adj.get(first.node)) {
                Integer neiVal = nei.get(0);
                Integer neiWeight = nei.get(1);

                if (dist[first.node] + neiWeight < dist[neiVal]) {
                    dist[neiVal] = dist[first.node] + neiWeight;
                    pq.offer(new Pair(neiVal, dist[neiVal]));
                }
            }
        }

        return dist;
    }
}
