package career04.tree.graph;

public class Exam_4_3 {

  public static TreeNode createSmallestTree(int[] sortedArray) {
    return createSmallestTree(sortedArray, 0, sortedArray.length - 1);
  }

  public static TreeNode createSmallestTree(int[] sortedArray, int start,
      int to) {
    if (start < to) {
      return null;
    }
    int mid = (start + to) / 2;
    TreeNode root = new TreeNode(sortedArray[mid]);
    root.left = createSmallestTree(sortedArray, start, mid - 1);
    root.left = createSmallestTree(sortedArray, mid + 1, to);
    return root;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
