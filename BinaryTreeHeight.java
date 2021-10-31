

public class BinaryTreeHeight {
  public static class Node {
    Node left;
    Node right;
    int data;
    
    public Node(int data) {
      this.data = data;
    }
  }
  
  public static int height(Node root) {
    if (root == null || (root.left == null && root.right == null)) {
      return 0;
    }
    
    return 1 + Math.max(height(root.left), height(root.right));
  }

  public static void main(String args[]) {
    Node root = new Node(0);
    Node currNode = root;
    System.out.println(height(root));
    for (int i = 0; i < 10; i++) {
      currNode.right = new Node(i);
      currNode = currNode.right;
      System.out.println(height(root));
    }
  }
}
