//You are given an array of binary trees that represent different cities where a certain corporation has its branch office and the organization wishes to provide service by constructing a service center. Building service centers at any node, i.e., a city can give service to its directly connected cities where it can provide service to its parents, itself, and its immediate children. Returns the smallest number of service centers required by the corporation to provide service to all connected cities. Note that: the root node represents the head office and other connected nodes represent the branch office connected to the head office maintaining some kind of hierarchy.
//
//        Input: tree= {0,0, null, 0, null, 0, null, null, 0}
//        Output: 2
//        Explanation: construction of two service centers denoted by black markk will be enough to provide service to all cities.


package Que2;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    // Main function to calculate the minimum number of service centers required
    public int minServiceCenters(TreeNode root) {
        int[] ans = new int[]{0}; // ans[0] stores the result
        int[] unserviced = new int[]{0}; // unserviced[0] stores the number of unserviced cities
        dfs(root, unserviced);
        ans[0] = (int) Math.ceil(unserviced[0] / 2.0); // minimum number of service centers required
        return ans[0];
    }

    // DFS function to calculate the number of unserviced cities
    private void dfs(TreeNode node, int[] unserviced) {
        if (node == null) return; // return if node is null
        unserviced[0]++; // increment unserviced city count by 1
        dfs(node.left, unserviced); // call dfs on left child node
        dfs(node.right, unserviced); // call dfs on right child node
    }
}

public class ServiceCenters {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(0);
        Solution solution = new Solution();
        System.out.println("Minimum number of service centers required: " + solution.minServiceCenters(root));
    }
}
