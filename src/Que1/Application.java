package Que1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Application {

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 6}, {2, 4}, {4, 6}, {4, 5}, {5, 7}};
        int targetDevice = 4;

        List<Integer> impactedDevices = getImpactedDevices(edges, targetDevice);

        System.out.println("Impacted Devices: " + impactedDevices);
    }

    private static List<Integer> getImpactedDevices(int[][] edges, int targetDevice) {
        int n = edges.length;
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            adj[x].add(y);
            adj[y].add(x);
        }

        List<Integer> impactedDevices = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        visited[targetDevice] = true;
        queue.offer(targetDevice);

        while (!queue.isEmpty()) {
            int device = queue.poll();
            for (int neighbor : adj[device]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    impactedDevices.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return impactedDevices;
    }
}
