package Que1;

import java.util.*;

public class CheapestRoute {
    static class Edge {
        int source;
        int destination;
        int time;

        Edge(int source, int destination, int time) {
            this.source = source;
            this.destination = destination;
            this.time = time;
        }
    }

    static int findCheapestRoute(List<Edge> edges, int[] charges, int source, int destination, int timeConstraint) {
        // Create a Map to represent the graph
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (Edge edge : edges) {
            graph.putIfAbsent(edge.source, new HashMap<>());
            graph.get(edge.source).put(edge.destination, edge.time);
        }

        // Create a priority queue to store nodes to visit
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        // The array contains= node, current charge, and current distance
        pq.offer(new int[]{source, charges[source], 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], charge = curr[1], dist = curr[2];
            if (node == destination) {
                return dist;
            }

            if (dist >= timeConstraint || charge < 0) {
                continue;
            }

            if (graph.containsKey(node)) {
                for (int next : graph.get(node).keySet()) {
                    int newCharge = charge - graph.get(node).get(next);
                    if (newCharge >= 0) {
                        pq.offer(new int[]{next, newCharge, dist + graph.get(node).get(next)});
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1, 5),
                new Edge(0, 3, 2),
                new Edge(1, 2, 5),
                new Edge(3, 4, 5),
                new Edge(4, 5, 6),
                new Edge(2, 5, 5)
        );
        int[] charges = {10, 2, 3, 25, 25, 4};
        int source = 0;
        int destination = 5;
        int timeConstraint = 14;

        System.out.println(findCheapestRoute(edges, charges, source, destination, timeConstraint));
    }
}
