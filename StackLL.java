public class StackLL {
    private Node top;

    public StackLL() {
        top = null;  // Pointer for the top of our stack
    }

    public Node top() {
        // Function that returns the top Node of the stack
        return top;
    }

    public Node pop() {
        // Function that removes and returns the top Node in a stack
        Node temp = top;
        if (temp != null) {  // If the top Node is not null, we have to shift the top pointer
            top = top.getNext();
            temp.setNext(null);
        }
        return temp;
    }

    public void push(Node x) {
        // Function that inserts a Node to our stack
        x.setNext(top);
        top = x;
    }

    public boolean isEmpty() {
        // Function that checks if our stack is empty
        return top == null;
    }

    public void printStack() {
        // Function that prints the Nodes in the stack
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.getKey());
            temp = temp.getNext();
        }
    }
}
