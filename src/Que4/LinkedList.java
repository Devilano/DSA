package Que4;

public class LinkedList {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private static int sort(Node node) {
        if (node == null || node.next == null) {
            return 0;
        }

        int steps = 0;
        if (node.val > node.next.val) {
            node.next = node.next.next;
            steps++;
            steps += sort(node);
        } else {
            steps += sort(node.next);
        }
        return steps;
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(1);

        int steps = sort(head);
        System.out.println("Steps required to sort the list: " + steps);
    }
}
