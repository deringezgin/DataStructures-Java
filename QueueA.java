public class QueueA {
    private Node[] queue;
    private int n;
    private int front;

    public QueueA() {
        queue = new Node[100];  // Array that stores the elements in our queue
        n = 0;  // Variable that keeps track of the length of our queue
        front = 0;  // Variable that keeps track of index of the front of our queue
    }

    public Node front() {
        // Function that returns the front of our queue
        return queue[front];
    }

    public Node dequeue() {
        // Function that returns the first Node of the queue
        if (n == 0) {
            return null;  // If the queue is empty (length is 0) returns null
        } else {
            Node temp = queue[front];
            front = (front + 1) % 100;  // Shifting the front and applying % in case of going over borders
            n -= 1;  // Decrementing the length
            return temp;
        }
    }

    public void enqueue(Node x) {
        // Function that adds a Node to the queue and increments the length
        queue[(front + n) % 100] = x;
        n += 1;
    }

    public boolean isEmpty() {
        // Function that checks if the queue is empty by checking length = 0
        return n == 0;
    }

    public void printQueue() {
        // Function that prints the elements in the queue
        int tail = (front + n) % 100;
        System.out.println(front);
        System.out.println(tail);
        if (front <= tail)
            for (int i = front; i < tail; i++)
                System.out.println(queue[i].getKey());
        else {
            for (int i = front; i < 100; i++)
                System.out.println(queue[i].getKey());
            for (int i = 0; i < tail; i++)
                System.out.println(queue[i].getKey());
        }
    }
}
