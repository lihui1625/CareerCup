package zcy03.tree;

public class Exam_031 {

  public static void preOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    System.out.print(root.val + "\t");
    preOrder(root.left);
    preOrder(root.right);
  }

  public static void midOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    midOrder(root.left);
    System.out.print(root.val + "\t");
    midOrder(root.right);
  }

  public static void postOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    postOrder(root.left);
    postOrder(root.right);
    System.out.print(root.val + "\t");
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    TreeNode node7 = new TreeNode(7);

    root.setLeft(node2).setRight(node3);
    node2.setLeft(node4).setRight(node5);
    node3.setLeft(node6).setRight(node7);
    node4.setLeft(new TreeNode(8)).setRight(new TreeNode(9));
    node5.setLeft(new TreeNode(10)).setRight(new TreeNode(11));
    node6.setLeft(new TreeNode(12)).setRight(new TreeNode(13));
    node7.setLeft(new TreeNode(14)).setRight(new TreeNode(15));

    System.out.println();
    preOrder(root);
    System.out.println();
    midOrder(root);
    System.out.println();
    postOrder(root);
    System.out.println();

  }

}
