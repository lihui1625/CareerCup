package career04.tree.graph;

public class Exam_4_1 {

  public static boolean isbalance(TreeNode root) {
    if (root == null) {
      return true;
    }
    TreeNode left = root.left;
    TreeNode right = root.right;
    if (Math.abs(getHeight(left) - getHeight(right)) > 1) {
      return false;
    } else {
      return isbalance(left) && isbalance(right);
    }

  }

  public static int getHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(getHeight(root.left), getHeight(root.right));
  }

  public static boolean isbalance2(TreeNode root) {
    if (root == null) {
      return true;
    }

    if (chechHeight(root) == -1) {
      return false;
    } else {
      return true;
    }
  }

  public static int chechHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    TreeNode left = root.left;
    TreeNode right = root.right;

    int leftHieight = chechHeight(left);
    if (leftHieight == -1) {
      return -1;
    }
    int rightHieight = chechHeight(right);
    if (rightHieight == -1) {
      return -1;
    }
    if (Math.abs(leftHieight - rightHieight) > 1) {
      return -1;
    } else {
      return Math.max(leftHieight, rightHieight) + 1;
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
