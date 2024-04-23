public class Node {
    private String name;
    private int ssn;
    private Node next;


    public Node(String name, int ssn) {
        this.name = name;
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSSN() {
        return ssn;
    }

    public void setSSN(int ssn) {
        this.ssn = ssn;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getKey() {
        // Method that returns the last 4 digits of the Node (key) using the % operator
        return ssn % 10000;
    }
}
