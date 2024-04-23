public class TreeNode {
    private String name;
    private int ssn;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(String name, int ssn) {
        this.name = name;
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setLeft(TreeNode x) {
        left = x;
    }

    public void setRight(TreeNode x) {
        right = x;
    }

    public int getKey() {
        return ssn % 10000;
    }
}
