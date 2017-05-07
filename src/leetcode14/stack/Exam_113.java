package leetcode14.stack;

import java.util.Stack;

import zcy03.tree.TreeNode;

public class Exam_113 {

  public static void twoNodeSum(TreeNode root, int sum) {

    Stack<TreeNode> leftStack = new Stack<>();
    Stack<TreeNode> rightStack = new Stack<>();

    TreeNode scan = root;
    while (scan != null) {
      leftStack.push(scan);
      scan = scan.left;
    }

    scan = root;
    while (scan != null) {
      rightStack.push(scan);
      scan = scan.right;
    }

    while (!leftStack.isEmpty() && !rightStack.isEmpty()) {
      int tmpSum = leftStack.peek().val + rightStack.peek().val;
      if (tmpSum > sum) {
        TreeNode rightTop = rightStack.pop();
        if (rightTop.left != null) {
          scan = rightTop.left;
          while (scan != null) {
            rightStack.push(scan);
            scan = scan.right;
          }
        }

      } else if (tmpSum < sum) {
        TreeNode leftTop = leftStack.pop();
        if (leftTop.right != null) {
          scan = leftTop.right;
          while (scan != null) {
            rightStack.push(scan);
            scan = scan.left;
          }
        }

      } else {
        System.out.println(
            sum + " Found! " + leftStack.peek() + "," + rightStack.peek());
        return;
      }

    }
    System.out.println(sum + " Found! ");

  }

  public static void main(String[] args) {
    TreeNode t1 = new TreeNode(1);
    TreeNode t2 = new TreeNode(2);
    TreeNode t3 = new TreeNode(3);
    TreeNode t4 = new TreeNode(4);
    TreeNode t5 = new TreeNode(5);
    TreeNode t6 = new TreeNode(6);
    TreeNode t7 = new TreeNode(7);

    t4.setLeft(t2).setRight(t6);
    t2.setLeft(t1).setRight(t3);
    t6.setLeft(t5).setRight(t7);

    for (int i = 0; i < 20; i++) {
      twoNodeSum(t4, i);
    }

  }

}
