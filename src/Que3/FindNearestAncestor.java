package Que3;// A:

//You are given a 2D array containing hierarchical information about certain species,
// with edge[i]=[xi,yi], where node xi is connected to xj.
// You are also provided an array of values associated with each species,
// such that value[i] reflects the ith nodes value. If the greatest common divisor of two
// values is 1, they are "relatively prime."
// Any other node on the shortest path from that node to the absolute parent node is an
// ancestor of certain species i. Return a list of nearest ancestors, where result[i] is the node i's nearest
// ancestor such that values[i] and value[result[i]] are both relative primes otherwise -1.



import java.util.Arrays;

public class FindNearestAncestor {
    public static int[] findNearestAncestors(int[] values, int[][] edges) {
        int n = values.length;
        int[] nearestAncestors = new int[n];
        Arrays.fill(nearestAncestors, -1);
        boolean[] visited = new boolean[n];

        // perform DFS starting at root node (node 0)
        dfs(0, -1, values, edges, nearestAncestors, visited);

        return nearestAncestors;
    }

    private static void dfs(int node, int parent, int[] values, int[][] edges, int[] nearestAncestors, boolean[] visited) {
        visited[node] = true;

        // check if GCD of node and parent's values is 1
        if (parent != -1 && gcd(values[node], values[parent]) == 1) {
            nearestAncestors[node] = parent;
            return;
        }

        // visit all child nodes
        for (int[] edge : edges) {
            if (edge[0] == node) {
                int child = edge[1];
                if (!visited[child]) {
                    dfs(child, node, values, edges, nearestAncestors, visited);
                }
            }
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[] values = {3, 2, 6, 6, 4, 7, 12};
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};
        int[] nearestAncestors = findNearestAncestors(values, edges);
        System.out.println(Arrays.toString(nearestAncestors));
    }
}