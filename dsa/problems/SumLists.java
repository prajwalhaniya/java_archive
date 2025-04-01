package problems;

import LinkedList.Node;

public class SumLists {

    public static Node addLists(Node l1, Node l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int value = carry;

        if (l1 != null) {
            value += l1.data;
        }

        if (l2 != null) {
            value += l2.data;
        }

        Node result = new Node(value % 10);

        if (l1 != null || l2 != null) {
            Node more = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value >= 10 ? 1: 0);
            result.next = more;
        }

        return result;
    }

    public static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }

        System.out.println();
    }


    public static void main(String[] args) {
        Node l1 = new Node(7);
        l1.next = new Node(1);
        l1.next.next = new Node(6);

        Node l2 = new Node(2);
        l2.next = new Node(1);
        l2.next.next = new Node(9);

        Node res = addLists(l1, l2, 0);

       printList(res);

    }
}
