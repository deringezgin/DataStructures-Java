public class BST {
    private TreeNode root;

    public BST() {
        root = null;  // Pointer that points to the root of the tree
    }

    public void insert(TreeNode x) {
        // Function that inserts the Node (x) to the BST
        if (root == null) {  // If the root is null, sets the root to the Node (x)
            root = x;
        } else {
            inserter(root, x);  // If root is not null, calls the recursive "inserter" function
        }
    }

    private void inserter(TreeNode r, TreeNode x) {
        // Function that recursively calls itself to move forward in the tree and insert the Node in the first empty spot
        if (x.getKey() < r.getKey()) {  // If the key of the new Node is less than the upper Node, go left
            if (r.getLeft() == null) {  // If left is empty, insert x there
                r.setLeft(x);
            } else {  // If it's not empty, call the function again with the left Node as the upper Node
                inserter(r.getLeft(), x);
            }
        } else {  // Same procedure but with going right
            if (r.getRight() == null) {
                r.setRight(x);
            } else {
                inserter(r.getRight(), x);
            }
        }
    }

    public void delete(TreeNode x) {
        // Function to delete the Node (x) in the BST
        if (root != null) {  // If it's not an empty tree
            if (root == x) {  // If the Node is the root
                root = deleteRoot(root);  // Directly call the deleteRoot function
            } else {
                deleter(root, x);  // If it's not the root, pass to the deleter
            }
        }
    }

    public void deleter(TreeNode parent, TreeNode target) {
        // Recursive delete function to reach the Node we'd like to delete and call the deleteRoot method
        if (parent.getLeft() != null && target.getKey() < parent.getKey()) {  // If left is not empty and target Node is less than the current parent
            if (target.getKey() == parent.getLeft().getKey()) {  // If the left Node is our target
                parent.setLeft(deleteRoot(parent.getLeft()));  // Call the deleteRoot on the left child of the parent and set the new root to the left child of the parent
            } else {
                deleter(parent.getLeft(), target);  // If we don't have a match, proceed further in the BST
            }
        } else if (parent.getRight() != null && target.getKey() > parent.getKey()) {  // If right is not empty and target Node is more than the current parent
            if (target.getKey() == parent.getRight().getKey()) { // Applying the same procedures but for the right side
                parent.setRight(deleteRoot(parent.getRight()));
            } else {
                deleter(parent.getRight(), target);
            }
        }
    }

    private TreeNode deleteRoot(TreeNode x) {
        // Function to delete the Node in a BST that is the root of the tree
        if (x.getLeft() == null) {
            // If the Node we want to delete is a Node with only one right child (This case also catches Nodes with no child)
            TreeNode temp = x;  // Saving the Node in a temp variable
            x = x.getRight();  // Setting it into its right child
            temp.setRight(null);  // Disconnecting the Node we'd like to delete
            return x;
        } else if (x.getRight() == null) {
            // If the Node we want to delete is a Node with only one left child, we apply the same procedure as before but with the left side
            TreeNode temp = x;
            x = x.getLeft();
            temp.setLeft(null);
            return x;
        } else {
            // If the Node we want to delete is a Node with a child on both sides
            TreeNode temp = getSuccessor(x.getRight());  // Finding the successor
            delete(temp);  // Removing the successor from the tree
            temp.setRight(x.getRight());  // Inserting the successor into the place of the Node we'd like to delete
            temp.setLeft(x.getLeft());
            x.setLeft(null);  // Disconnecting the Node we'd like to delete
            x.setRight(null);
            return temp;
        }
    }

    private TreeNode getSuccessor(TreeNode x) {
        // Function to find the successor of a Node
        while (x.getLeft() != null) {  // While the left side is not null
            x = x.getLeft();
        }
        return x;
    }

    public TreeNode search(int key) {
        // Function that returns the Node that has the specific key by calling another recursive search function
        return searcher(root, key);
    }

    private TreeNode searcher(TreeNode x, int key) {
        // Function that recursively calls itself, in order to search for a specific key in the BST
        if (x == null) {  // If root is null, return null
            return null;
        } else if (key == x.getKey()) {  // If there's a match, return the Node
            return x;
        } else if (key < x.getKey()) {  // If key is less than x, call the function again with the Node on the left
            return searcher(x.getLeft(), key);
        } else {  // If key is more than x, call the function again with the Node on the right
            return searcher(x.getRight(), key);
        }
    }

    public void traverse() {
        // Function that calls a recursive traverse function that'll print the values of the tree from smallest to largest
        traverser(root);
        System.out.println();  // Prints blank line at the end for nicer output
    }

    private void traverser(TreeNode x) {
        // Recursive function that traverses the tree and prints the values
        if (x != null) {
            traverser(x.getLeft());
            System.out.print(x.getKey() + " ");
            traverser(x.getRight());
        }
    }

    public boolean isEmptyTree() {
        // Function that returns if a tree is empty or not by checking if the root is null
        return root == null;
    }

    public void printTree() {
        // Function that prints the tree
        printTree2(root);
        System.out.println();
    }

    private void printTree2(TreeNode tree) {
        // Recursive function that prints the tree
        if (tree != null) {
            System.out.print(tree.getKey() + " ");
            if (tree.getLeft() != null) System.out.print("Left: " + tree.getLeft().getKey() + " ");
            else System.out.print("Left: null ");
            if (tree.getRight() != null) System.out.println("Right: " + tree.getRight().getKey() + " ");
            else System.out.println("Right: null ");
            printTree2(tree.getLeft());
            printTree2(tree.getRight());
        }
    }
}

// === CODE FOR THE NON-RECURSIVE BST DELETE FUNCTION === //

/*
public void delete(Node x) {
        // Delete function to delete the Node x. This is the solution without using recursion.

        // First of all, we have to have pointers to the Node we'd like to delete and the parent Node of it
        Node target = root, parent = null;  // Variables to start from the root and keep track of the parent
        while (target != null && x.getKey() != target.getKey()) {  // While we're not in the right Node moving through the tree until a match, or we're not at the end of the BST
            parent = target;
            target = x.getKey() < target.getKey() ? target.getLeft() : target.getRight();
        }

        // "target" is the Node we'd like to delete and "parent" is the parent Node of "target"
        if (target == null) { // If the loop ended because the "target" is null (we reached at the end of the tree), end the function
            return;
        }

        if (parent == null) {  // In case that parent is null --we're trying to delete the root
            Node successor = getSuccessor(target.getRight());  // Find the successor Node
            if (target.getRight() != successor) {  // If the successor is not the Node that's directly right-after the Node we'd like to delete, connect the elements on the right to the scs
                successor.setRight(target.getRight());
            }
            successor.setLeft(target.getLeft());
            root = successor;  // Set root pointer to the successor
            disconnectNode(target);
            return;
        }

        // At this point, we have 3 options: Deleting a leaf (no child), deleting a Node with 1 child and deleting a Node with 2 child
        if (target.getLeft() == null) {  // If the Node we want to delete is a Node with only one right child (This case also catches Nodes with no child)
            connectNodes(parent, target, target.getRight());
            disconnectNode(target);
        } else if (target.getRight() == null) {  // If the Node we want to delete is a Node with only one left child
            connectNodes(parent, target, target.getLeft());
            disconnectNode(target);
        } else {  // If the Node we want to delete is a Node that has both left and right child
            Node successor = getSuccessor(target.getRight());  // Find the successor
            connectNodes(parent, target, successor);
            if (target.getRight() != successor) {  // If the successor is not the Node that's directly right-after the Node we'd like to delete, connect the elements on the right to the scs
                successor.setRight(target.getRight());
            }
            successor.setLeft(target.getLeft());  // Connect the elements of the left-side
            disconnectNode(target);
        }
    }

    private Node getSuccessor(Node node) {
        // Helper function for our delete which finds the successor (left-most Node of the right subtree) for the Node we'd like to delete
        Node parent = null;  // Keeping track of the parent
        while (node.getLeft() != null) {  // While the left side is not empty, update the parent, go left
            parent = node;
            node = node.getLeft();
        }

        if (parent != null) {  // If the parent is not null, left subtree of the parent should be the right subtree of the scs, so that no Nodes get lost in the process
            parent.setLeft(node.getRight());
        }
        return node;  // Returns the successor
    }

    private void connectNodes(Node parentNode, Node removedNode, Node subNode) {
        // Helper function for our delete which checks if the Node we want to delete is the right/left child of its parent and connects accordingly
        if (removedNode.getKey() > parentNode.getKey()) parentNode.setRight(subNode);
        else parentNode.setLeft(subNode);
    }

    private void disconnectNode(Node node) {
        // Helper function to set left/right pointers of a Node to null in order to disconnect it completely from the tree
        node.setLeft(null);
        node.setRight(null);
    }
 */
