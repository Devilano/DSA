package Que2;

import java.util.*;



public class NearestAncestor {

    static int[] nearestAncestor(int[] values, int[][] edges) {
        int n = values.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                stack.push(i);
                while (!stack.empty()) {
                    int node = stack.pop();
                    visited[node] = true;
                    for (int neighbor : graph.get(node)) {
                        if (!visited[neighbor]) {
                            if (gcd(values[node], values[neighbor]) == 1) {
                                result[neighbor] = node;
                                stack.push(neighbor);
                            } else {
                                stack.push(neighbor);
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[] values = {3, 2, 6, 6, 4, 7, 12};
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};

        int[] result = nearestAncestor(values, edges);
        System.out.println(Arrays.toString(result));
    }
}
