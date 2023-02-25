package Que5;


import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class BarGraph {

    public int[][] getKeyCoordinates(int[][] height) {
        // Store the start and end points of each rectangle in a TreeMap
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] rect : height) {
            map.put(rect[0], Math.max(map.getOrDefault(rect[0], 0), rect[2]));
            map.put(rect[1], 0);
        }

        // Keep track of the current height while iterating through the map
        int currHeight = 0;
        int[][] res = new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int x = entry.getKey();
            int h = entry.getValue();
            if (h != currHeight) {
                res[i][0] = x;
                res[i][1] = currHeight = h;
                i++;
            }
        }

        // Return the key coordinates
        return Arrays.copyOfRange(res, 0, i);
    }

    public static void main(String[] args) {
        BarGraph obj = new BarGraph() ;
        int[][] height = {{1,4,10},{2,5,15},{5,8,12},{9,11,1},{11,13,15}};
        int[][] res = obj.getKeyCoordinates(height);
        System.out.println(Arrays.deepToString(res));
    }
}


//public class BarGraph {
//    public int[][] getKeyCoordinates(int[][] height) {
//        List<int[]> rectangles = new ArrayList<>();
//
//        // Convert the input array into a list of rectangles
//        for (int[] rect : height) {
//            rectangles.add(new int[]{rect[0], rect[2]});
//            rectangles.add(new int[]{rect[1], 0});
//        }
//
//        // Sort the rectangles by their x-coordinate, breaking ties by their height
//        Collections.sort(rectangles, new Comparator<int[]>() {
//            public int compare(int[] a, int[] b) {
//                if (a[0] != b[0]) {
//                    return Integer.compare(a[0], b[0]);
//                } else {
//                    return Integer.compare(b[1], a[1]);
//                }
//            }
//        });
//
//        // Traverse the sorted list of rectangles, keeping track of the current height
//        int currHeight = 0;
//        List<int[]> keyCoords = new ArrayList<>();
//        for (int[] rect : rectangles) {
//            if (rect[1] > 0 && rect[1] != currHeight) {
//                keyCoords.add(new int[]{rect[0], currHeight});
//                keyCoords.add(new int[]{rect[0], rect[1]});
//                currHeight = rect[1];
//            } else {
//                currHeight = rect[1];
//            }
//        }
//
//        // Convert the list of key coordinates to an array and return it
//        int[][] res = new int[keyCoords.size()][2];
//        for (int i = 0; i < keyCoords.size(); i++) {
//            res[i] = keyCoords.get(i);
//        }
//        return res;
//    }
//
//    public static void main(String[] args) {
//        BarGraph obj = new BarGraph() ;
//        int[][] height = {{1,4,10},{2,5,15},{5,8,12},{9,11,1},{11,13,15}};
//        int[][] res = obj.getKeyCoordinates(height);
//        System.out.println(Arrays.deepToString(res));
//    }
//}



