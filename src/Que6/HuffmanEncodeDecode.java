
//a)	Implement Huffman encoding and decoding.

package Que6;

import java.util.Comparator;
import java.util.PriorityQueue;

// Node class to store data, character and left and right child
class Node {
    int data;
    char c;
    Node left;
    Node right;

    // Constructor for leaf node
    public Node(int data, char c) {
        this.data = data;
        this.c = c;
        this.left = null;
        this.right = null;
    }

    // Constructor for internal node
    public Node(int data, Node left, Node right) {
        this.data = data;
        this.c = '\0';
        this.left = left;
        this.right = right;
    }
}

class HuffmanEncodeDecode {

    // Method to encode the input string
    static void encode(String s, Node root) {
        // StringBuilder to store the encoded string
        StringBuilder sb = new StringBuilder();
        // Loop through each character in the input string
        for (int i = 0; i < s.length(); i++) {
            // Get the encoded code for each character
            sb.append(getCode(s.charAt(i), root, ""));
        }
        // Print the encoded string
        System.out.println("Encoded String: " + sb);
    }

    // Recursive method to get the encoded code for a character
    static String getCode(char c, Node root, String str) {
        // If the node is null, return an empty string
        if (root == null) {
            return "";
        }
        // If the current node is a leaf node with the character we are searching for, return the code
        if (root.c == c) {
            return str;
        }
        // Get the code for the left child by appending 0 to the current code
        String left = getCode(c, root.left, str + "0");
        // Get the code for the right child by appending 1 to the current code
        String right = getCode(c, root.right, str + "1");
        // If the code for the left child is not empty, return that, otherwise return the code for the right child
        return !left.equals("") ? left : right;
    }

    // Method to decode the encoded string
    static void decode(String s, Node root) {
        // StringBuilder to store the decoded string
        StringBuilder sb = new StringBuilder();
        // Node to keep track of the current node while decoding
        Node curr = root;
        // Loop through each character in the encoded string
        for (int i = 0; i < s.length(); i++) {
            // If the current character is 0, move to the left child, otherwise move to the right child
            curr = (s.charAt(i) == '0') ? curr.left : curr.right;
            // If the current node is a leaf node, add the character to the decoded string and start from the root again
            if (curr.left == null && curr.right == null) {
                sb.append(curr.c);
                curr = root;
            }
        }
        // Print the decoded string
        System.out.println("Decoded String: " + sb);
    }
    static Node buildHuffmanTree(int[] charFreq) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                return a.data - b.data;
            }
        });

        for (int i = 0; i < charFreq.length; i++) {
            if (charFreq[i] > 0) {
                pq.add(new Node(charFreq[i], (char) i));
            }
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            int sum = left.data + right.data;
            pq.add(new Node(sum, left, right));
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        String s = "AAABBBCCCCCCCCCCCCC";
        int[] charFreq = new int[256];
        for (int i = 0; i < s.length(); i++) {
            charFreq[s.charAt(i)]++;
        }

        Node root = buildHuffmanTree(charFreq);
        encode(s, root);
        String encodedString = "101010001101000101";
        decode(encodedString, root);
    }

}