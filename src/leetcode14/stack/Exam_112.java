package leetcode14.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import zcy03.tree.TreeNode;

public class Exam_112 {

  public static void main(String[] args) {
    TreeNode t1 = new TreeNode(1);
    TreeNode t2 = new TreeNode(2);
    TreeNode t3 = new TreeNode(3);
    TreeNode t4 = new TreeNode(4);
    TreeNode t5 = new TreeNode(5);
    TreeNode t6 = new TreeNode(6);
    TreeNode t7 = new TreeNode(7);

    t1.setLeft(t2).setRight(t3);
    t2.setLeft(t4).setRight(t5);
    t3.setLeft(t6).setRight(t7);

    printPath(t1);
    System.out.println();
    printPath2(t1);
    System.out.println();

  }

  public static void printPath2(TreeNode t1) {
    // TODO Auto-generated method stub

  }

  public static void printPath(TreeNode t1) {
    if (t1 == null) {
      return;
    }
    Map<TreeNode, TreeNode> lastNodeMap = new HashMap<>();
    List<List<TreeNode>> pathList = new LinkedList<>();
    getpath(t1, lastNodeMap, pathList);
    for (List<TreeNode> left : pathList) {
      System.out.println(left);
    }
  }

  private static void getpath(TreeNode t1, Map<TreeNode, TreeNode> lastNodeMap,
      List<List<TreeNode>> pathList) {
    if (t1 == null) {
      return;
    }
    if (t1.left == null && t1.right == null) {
      LinkedList<TreeNode> path = new LinkedList<>();
      for (TreeNode node = t1; node != null; node = lastNodeMap.get(node)) {
        path.addFirst(node);
      }
      pathList.add(path);
    } else {
      if (t1.left != null) {
        lastNodeMap.put(t1.left, t1);
        getpath(t1.left, lastNodeMap, pathList);
      }
      if (t1.right != null) {
        lastNodeMap.put(t1.right, t1);
        getpath(t1.right, lastNodeMap, pathList);
      }
    }

  }

}
