package zcy03.tree;

public class Tree {

  public TreeNode root;

  public Tree() {
    this.root = null;
  }

  public Tree(int val) {
    this.root = new TreeNode(val);
  }

  public void insert(int val) {
    if (this.root == null) {
      this.root = new TreeNode(val);
    } else {
      TreeNode node = this.root;
      while (node != null) {
        if (node.val >= val) {
          if (node.left != null) {
            node = node.left;
          } else {
            TreeNode newNode = new TreeNode(val);
            node.left = newNode;
            break;
          }
        } else {
          if (node.right != null) {
            node = node.right;
          } else {
            TreeNode newNode = new TreeNode(val);
            node.right = newNode;
            break;
          }

        }
      }

    }
  }

  public TreeNode findNode(int val) {
    if (this.root == null) {
      return null;
    }
    TreeNode node = this.root;
    while (node != null) {
      if (val == node.val) {
        return node;
      } else if (val > node.val) {
        node = node.left;
      } else {
        node = node.right;
      }
    }

    return null;

  }

  public void preOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    System.out.println(root);
    this.preOrder(root.left);
    this.preOrder(root.right);
  }

  public void midOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    this.midOrder(root.left);
    System.out.println(root);
    this.midOrder(root.right);
  }

  public void postOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    this.postOrder(root.left);
    this.postOrder(root.right);
    System.out.println(root);
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
