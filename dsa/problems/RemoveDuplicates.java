package problems;
import LinkedList.Node;
import java.util.HashSet;

public class RemoveDuplicates {

    public RemoveDuplicates() {}

    public Node remove(Node head) {
        if (head == null) {
            return null;
        }

        HashSet<Integer> seen = new HashSet<>();

        Node current = head;
        Node previous = null;

        while (current != null) {
            if (seen.contains(current.data)) {
                previous.next = current.next;
            } else {
                seen.add(current.data);
                previous = current;
            }
            current = current.next;
        }

        return head;
    }

    public Node removeWithoutUsingBuffer(Node head) {
        if (head == null) {
            return null;
        }

        Node current = head;

        while (current != null) {
            Node runner = current;

            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Node list = new Node(1);
        list.next = new Node(2);
        list.next.next = new Node(2);

        RemoveDuplicates duplicateRemover = new RemoveDuplicates();
//        Node temp = duplicateRemover.remove(list);
        Node temp = duplicateRemover.removeWithoutUsingBuffer(list);

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
}
