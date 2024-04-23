public class QueueLL {
    private Node head;
    private Node tail;

    public QueueLL() {
        head = null;  // Pointer that points the beginning of the queue
        tail = null;  // Pointer that points the end of the queue
    }

    public Node front() {
        // Function that returns the front of the queue
        return head;
    }

    public Node dequeue() {
        // Function that removes and returns the front Node of the queue
        Node temp = head;
        if (temp != null) {  // If the queue is not empty, shift the head in order to still have access to the queue
            head = temp.getNext();
            temp.setNext(null);
        }
        return temp;
    }

    public void enqueue(Node x) {
        // Function that inserts a Node to the queue
        if (head == null) {  // If queue is empty we should init. both head and the tail to the new Node (x)
            head = x;
            tail = x;
        } else {  // If it's not empty, we should connect the new Node to the end
            tail.setNext(x);
            tail = x;
        }
    }

    public boolean isEmpty() {
        // Function that returns if the queue is empty or not
        return head == null;
    }

    public void printQueue() {
        // Function that prints the queue by iterating through every element starting from the head
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getKey());
            temp = temp.getNext();
        }
    }
}
