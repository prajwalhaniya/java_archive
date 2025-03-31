import java.util.ArrayList;

public class Stack {
    private final ArrayList<Integer> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    public void push(int data) {
        stack.add(data);
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }

        return stack.removeLast();
    }

    public int peek() {
        if (isEmpty()) {
            System.out.print("Stack is empty");
            return -1;
        }

        return stack.getLast();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i) + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.display();

        System.out.println("Popped: " + stack.pop());

        stack.display();
    }
}
