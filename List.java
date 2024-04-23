public class List {
    private Node head;
    private int n;

    public List() {
        head = null;  // Head pointer that points to the beginning of the linked-list
        n = 0;  // Variable that keeps track of the length of the linked-list
    }

    public int length() {
        // Function that returns the length of the linked-list
        return n;
    }

    public boolean isEmptyList() {
        // Function that returns if the linked-list is empty or not
        return head == null;
    }

    public Node searchReturn(int key) {
        // Function that starts from the head of the linked list and looks for a specific value by iterating through it
        Node temp = head;
        while (temp != null) {
            if (temp.getKey() == key) {
                return temp;  // If it's a match, returns the Node
            }
            temp = temp.getNext();
        }
        return null;  // If couldn't find the Node, returns null
    }

    public void searchRemove(int key) {
        // Function that determines the Node and the prev. Node from that to remove and connects the prev. Node with the next Node
        Node toRemove = head;
        Node prev = null;
        while (toRemove != null) {  // While the Node is not Null
            if (toRemove.getKey() == key) {  // Check for a match with the key
                if (prev == null) {  // If prev. is null, Node we want to remove is head
                    head = toRemove.getNext();
                } else {  // If prev. is not null, connects prev. with the next Node and disconnects the Node to remove from the linked-list
                    prev.setNext(toRemove.getNext());
                    toRemove.setNext(null);
                }
                n -= 1;
                return;
            }
            prev = toRemove;
            toRemove = toRemove.getNext();
        }
    }

    public void insert(Node x) {
        // Function that inserts a Node to the linked-list
        if (head == null) {  // Inserting to the head if it's empty
            head = x;
        } else {  // If it's not empty inserting to the beginning
            x.setNext(head);
            head = x;
        }
        n += 1;
    }

    public void printList() {
        // Function to iterate through the List and print every element.
        Node temp = head;
        System.out.println(n);
        while (temp != null) {
            System.out.println(temp.getKey());
            temp = temp.getNext();
        }
    }
}
