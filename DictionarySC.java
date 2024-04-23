public class DictionarySC {
    private Node[] dictionary;
    private int n;

    public DictionarySC() {
        dictionary = new Node[7];  // Array that stores the elements in our dictionary
        n = 0;  // Integer to keep track of the length of the dictionary
    }

    public Node lookUp(int k) {
        // Function to lookup a value in the dictionary
        Node temp = dictionary[hash(k)];  // Saving the starting Node in a temp
        while (temp != null) {  // While temp is not null / We're not in the end of the chain
            if (temp.getKey() == k) {  // If we have a match, return the Node
                return temp;
            }
            temp = temp.getNext();  // Shift the Node
        }
        return null;  // Return null, if we can't find it
    }

    public void delete(int key) {
        // Function to delete a Node in the dictionary
        Node target = lookUp(key);
        if (target == null) {  // If the Node is not in the dictionary, return directly. No need to run the rest of the function
        	return;
        }
        
        Node prev = null;  // Node to track the previous Node while we're walking through the dictionary chain
        Node current = dictionary[hash(target.getKey())];  // Current Node that we're checking. We set it to the beginning of the chain

        while (current != null) {  // While we're not in an empty Node
            if (current == target) {  // If we have a match
                if (prev == null) {  // Check if it's the beginning of the chain
                    dictionary[hash(target.getKey())] = current.getNext();  // Set the Node to the next Node
                } else {  // If it's not the beginning of the chain
                    prev.setNext(current.getNext());  // Connect the previous Node with the next one
                }
                current.setNext(null);  // Setting the next pointer of the Node we'd like to remove to null, in order to disconnect it completely
                n--;  // Decrement the length
                return;  // End the function
            }
            // Shift the previous and the current
            prev = current;
            current = current.getNext();
        }
    }


    public void insert(Node x) {
        // Function to insert a Node to the dictionary

        if (lookUp(x.getKey()) != null) {  // Checking if the Node already exists, end the function if it is
            return;
        }

        n++;  // Incrementing the length
        Node temp = dictionary[hash(x.getKey())];  // Taking the first Node in the relevant index that we found with the hash function
        if (temp == null) {  // If the index is empty
            dictionary[hash(x.getKey())] = x;  // Set the index directly to the Node and end the function
            return;
        }
        while (temp.getNext() != null) {  // While we're not in the end of the chain
            temp = temp.getNext();  // Move through the chain
        }
        temp.setNext(x);  // When we're at the end, set next to the Node we'd like to insert
    }

    public boolean isEmpty() {
        // Function returns if the dictionary is empty or not by checking its length
        return n == 0;
    }

    public void printDictionary() {
        // Function to print the dictionary
        for (int i = 0; i < 7; i++) {
            System.out.print("|" + i + "|");
            System.out.print(" - ");
            if (dictionary[i] == null) {
                System.out.print("null");
            } else {
                Node temp = dictionary[i];
                while (temp != null) {
                    System.out.print(temp.getKey());
                    temp = temp.getNext();
                    System.out.print(" --> ");
                    if (temp == null) {
                        System.out.print("null");
                    }
                }
            }
            System.out.println();
        }
    }

    private int hash(int key) {
        // Hash function that finds the hash value of a key
        return key % 7;
    }
}
