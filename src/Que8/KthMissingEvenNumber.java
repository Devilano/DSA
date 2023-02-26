//Given an array of even numbers sorted in ascending order and an integer k,
//        Find the k^th missing even number from provided array
//        Input a[] ={0, 2, 6, 18, 22} k=6
//        Output: 16 examples:
//        Explanation: Missing even numbers on the list are 4, 8, 10, 12, 14, 16, 20 and so on and kth missing number is on 6th place of the list i.e. 16
//

package Que8;
public class KthMissingEvenNumber {

    public int findKthMissingEvenNumber(int[] arr, int k) {
        int missingCount = 0;
        int nextExpectedNumber = arr[0];
        for (int i = 0; i < arr.length; i++) {
            // Find missing numbers between two consecutive elements
            while (nextExpectedNumber < arr[i]) {
                missingCount++;
                // Return the kth missing number
                if (missingCount == k) {
                    return nextExpectedNumber;
                }
                nextExpectedNumber += 2;
            }
            nextExpectedNumber = arr[i] + 2;
        }

        // If kth missing number is greater than the largest number in the array
        while (missingCount < k) {
            missingCount++;
            nextExpectedNumber += 2;
        }
        return nextExpectedNumber;
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 6, 18, 22};
        int k = 6;
        KthMissingEvenNumber solution = new KthMissingEvenNumber();
        System.out.println("Kth missing even number: " + solution.findKthMissingEvenNumber(arr, k));
    }
}

//public class KthMissingEvenNumber {
//    public int findKthMissingEvenNumber(int[] arr, int k) {
//        int missingCount = 0;
//        int nextExpectedNumber = arr[0];
//        for (int i = 0; i < arr.length; i++) {
//            // Find missing numbers between two consecutive elements
//            while (nextExpectedNumber < arr[i]) {
//                missingCount++;
//                // Return the kth missing number
//                if (missingCount == k) {
//                    return nextExpectedNumber;
//                }
//                nextExpectedNumber += 2;
//            }
//            nextExpectedNumber = arr[i] + 2;
//        }
//
//        // If kth missing number is greater than the largest number in the array
//        while (missingCount < k) {
//            missingCount++;
//            nextExpectedNumber += 2;
//        }
//        return nextExpectedNumber;
//    }
//
//    public static void main(String[] args) {
//        int[] arr = {0, 2, 6, 18, 22};
//        int k = 6;
//        KthMissingEvenNumber solution = new KthMissingEvenNumber();
//        System.out.println("Kth missing even number: " + solution.findKthMissingEvenNumber(arr, k));
//    }
//}
