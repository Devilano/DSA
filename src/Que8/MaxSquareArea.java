//Given 2D matrix of 1 and 0s. Using stack, find maximum area of square made by 0s.
//        INPUT: 1 0 1 0 0
//        0 1 1 1 1
//        0 0 0 0 1
//        0 0 0 1 1
//        0 1 0 1 1
//        OUTPUT: 4


package Que8;
import java.util.Arrays;
import java.util.Stack;

public class MaxSquareArea {
    public int findMaxSquare(int[][] matrix) {
        int maxArea = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n];

        for (int i = 0; i < m; i++) {
            // Update height array based on current row
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }
            // Calculate max area for current row
            maxArea = Math.max(maxArea, largestRectangleArea(height));
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        // Append a -1 to the end of the heights array as a sentinel value
        int[] h = Arrays.copyOf(heights, heights.length + 1);
        h[heights.length] = -1;

        for (int i = 0; i < h.length; i++) {
            while (!stack.isEmpty() && h[stack.peek()] >= h[i]) {
                int height = h[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 1},
                {0, 1, 0, 1, 1}};
        MaxSquareArea solution = new MaxSquareArea();
        System.out.println("Max square area: " + solution.findMaxSquare(matrix));
    }
}

