public class StackA {
    private Node[] stack;
    private int n;

    public StackA() {
        stack = new Node[100];  // Initializing an array with 100 Nodes as our stack
        n = 0;  // Variable to track the length of the stack
    }

    public Node top() {
        // Function that returns the top Node in the stack
        if (n == 0) {
            return null;  // If stack is empty, return null
        } else {
            return stack[n - 1];
        }
    }

    public Node pop() {
        // Function that returns the top Node in the stack and removes it
        if (n == 0) {
            return null; // If stack is empty, return null
        } else {
            n -= 1;  // Decrementing the length in order to remove the top Node
            return stack[n];
        }
    }

    public void push(Node x) {
        // Function that inserts a Node to the top of a stack
        stack[n] = x;
        n += 1;
    }

    public boolean isEmpty() {
        // Function that returns if the stack is empty
        return n == 0;
    }

    public void printStack() {
        // Function that prints the stack
        System.out.println(n);
        for (int i = n - 1; i > -1; i--) {
            System.out.println(stack[i].getKey());
        }
    }
}
