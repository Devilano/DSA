package Que3;

import java.util.ArrayList;
import java.util.List;

public class MinProductDifference {
    public static int minProductDifference(int[] arr) {
        int n = arr.length;
        List<List<Integer>> subarrays = generateSubarrays(arr, n / 2);
        int minDiff = Integer.MAX_VALUE;
        // calculate the difference between two subarrays with the minimum product difference
        for (int i = 0; i < subarrays.size(); i++) {
            List<Integer> subarray1 = subarrays.get(i);
            List<Integer> subarray2 = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (!subarray1.contains(arr[j])) {
                    subarray2.add(arr[j]);
                }
            }
            int product1 = calculateProduct(subarray1);
            int product2 = calculateProduct(subarray2);
            int diff = Math.abs(product1 - product2);
            minDiff = Math.min(minDiff, diff);
        }
        return minDiff;
    }

    private static List<List<Integer>> generateSubarrays(int[] arr, int k) {
        List<List<Integer>> subarrays = new ArrayList<>();
        generateSubarraysHelper(arr, k, 0, new ArrayList<Integer>(), subarrays);
        return subarrays;
    }

    private static void generateSubarraysHelper(int[] arr, int k, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            current.add(arr[i]);
            generateSubarraysHelper(arr, k, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    private static int calculateProduct(List<Integer> subarray) {
        int product = 1;
        for (int i = 0; i < subarray.size(); i++) {
            product *= subarray.get(i);
        }
        return product;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 11};
        System.out.println(minProductDifference(arr)); // outputs 2
    }
}
