public class Heap {
    private Node[] heap;
    private int n;

    public Heap() {
        heap = new Node[127];  // Initializing an array of 127 Nodes as our Heap
        n = 0;  // Variable to keep track of the length of the heap
    }

    public Node findMin() {
        // Function that returns the min. valued Node in the heap which is stored in the 0th index
        return heap[0];
    }

    public void deleteMin() {
        // Function to remove the min. value Node from the heap
        if (n == 0) {  // If the heap is empty, return directly and don't do anything else
            return;
        }
        n -= 1;
        swap(0, n);  // Swap the first and the last Node in the heap
        int temp = 0;
        while (temp < n) {  // While temp is in the valid range, move the node in the index 0 to its correct place
            int left = getLeft(temp);
            int right = getRight(temp);
            int smallest = temp;

            // Checking left/right child and update the samllest index if the conditions are met
            if ((left < n) && (heap[left].getKey() < heap[smallest].getKey())) {
                smallest = left;
            }

            if ((right < n) && (heap[right].getKey() < heap[smallest].getKey())) {
                smallest = right;
            }

            // If smallest is not what we already have, swap it
            if (smallest != temp) {
                swap(temp, smallest);
                temp = smallest;
            } else {
                break;  // Heap property is satisfied
            }
        }
    }

    public void insert(Node x) {
        // Function that inserts a Node into the correct space in the Heap
        heap[n] = x;  // Adding the Node to the end of the Heap
        int child = n;
        int parent = getParent(n);
        while ((heap[child].getKey() < heap[parent].getKey())) {  // While the child Node is less than the parent Node and parent is greater than 0
            swap(child, parent);  // Swap child and the parent
            child = parent;
            parent = getParent(parent);
        }
        n += 1;
    }

    public boolean isEmpty() {
        // Function that returns if the heap is empty or not by checking if the length (n) is equal to 0
        return n == 0;
    }

    public void printHeap() {
        // Function to print the heap
        for (int i = 0; i < n; i++) {  // Itterating through the heap and printing the individual keys
            System.out.print("|" + heap[i].getKey() + "|");
        }
        System.out.println();
    }

    private int getParent(int child) {
        // Function that returns the parent Node of a child Node
        return ((child - 1) / 2);
    }

    private int getLeft(int parent) {
        // Function that returns the index of the left child of a parent Node
        return (2 * parent) + 1;
    }

    private int getRight(int parent) {
        // Function that returns the index of the right child of a parent Node
        return (2 * parent) + 2;
    }

    private void swap(int node1, int node2) {
        // Function to swap two Nodes in indexes node1 and node2
        Node temp = heap[node1];
        heap[node1] = heap[node2];
        heap[node2] = temp;
    }
}
