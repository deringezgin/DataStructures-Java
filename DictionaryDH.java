public class DictionaryDH {
    private Node[] dictionary;
    private int n;

    public DictionaryDH() {
        dictionary = new Node[7];  // Array that stores the elements in our dictionary
        n = 0;  // Integer to keep track of the length of the dictionary
    }

    public Node lookUp(int key) {
        // Function to look-up for a value in our dictionary
        int i = 0;
        int hashVal = hash(key, i);
        while (i < 7) {  // While we haven't iterated the dictionary for once
            if (dictionary[hashVal] != null && dictionary[hashVal].getKey() == key) {  // If the hashVal in the dictionary is not null and we have a match
                return dictionary[hashVal];
            }
            hashVal = hash(key, ++i);  // Take the next hash value
        }
        return null;
    }

    public void insert(Node x) {
        // Function to insert a value in our dictionary
        int key = x.getKey();
        int i = 0;

        if (lookUp(key) != null) {  // Checking if the Node already exists, end the function if it is
            return;
        }

        while (dictionary[hash(key, i)] != null) {  // While we're not in an empty spot in the dictionary
            i++;
            if (i == 7) {  // If we walked through the dictionary for once, return.
                return;
            }
        }
        dictionary[hash(key, i)] = x;  // Init. empty spot to the new Node we'd like to insert
        n += 1;
    }

    public void delete(int key) {
        // Function that deletes a Node from the dictionary
        Node target = lookUp(key);
        if (target == null) {  // If the Node is not in the dictionary, return. No need to run the rest of the function
        	return;
        }
        int i = 0;
        int hashVal = hash(key, i);
    	while (dictionary[hashVal] != target) {  // While we don't have a match
        	hashVal = hash(key, ++i);  // Take the next hash value
        }
        dictionary[hashVal] = null;  // Set our match to null to remove it from the dictionary
        n -= 1;
    }

    public boolean isEmpty() {
        // Function returns if the dictionary is empty or not by checking its length
        return n == 0;
    }

    public void printDictionary() {
        // Function that prints the dictionary by iterating through it
        for (int i = 0; i < 7; i++) {
            Node temp = dictionary[i];
            System.out.print("|");
            if (temp == null) {  // If the current Node is null, print x for it
                System.out.print("x");
            } else {  // If it's not null, print the key
                System.out.print(temp.getKey());
            }
            System.out.print("|");
        }
        System.out.println();
    }

    private int hash(int x, int i) {
        // Main hash function that calls the two helper hash functions
        return (hash1(x) + i * hash2(x)) % 7;
    }

    private int hash1(int num) {
        // Primary hash function that returns the modulo 7 value of the key
        return num % 7;
    }

    private int hash2(int num) {
        // Secondary hash function that returns the sum of the digits of the key
        int sum = 0;
        while (num != 0) {
            sum += num % 10; // Add the last digit to the sum
            num /= 10;  // Remove the last digit
        }
        return sum;
    }
}
