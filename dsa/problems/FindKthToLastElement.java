package problems;

import LinkedList.Node;

public class FindKthToLastElement {
    public static Node findKthToLast(Node head, int k) {
        Node first = head;
        Node second = head;

        for (int i = 0; i < k; i++) {
            if (first == null) {
                return null;
            }

            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        return second;
    }

    public static void printKthToLast(Node head, int k) {
        Node node = findKthToLast(head, k);

        if (node != null) {
            System.out.print(k + "th to last element is " + node.data);
        } else {
            System.out.print("Invalid K (greater than list lenght)");
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        printKthToLast(head, 2);
    }
}
