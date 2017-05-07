package career04.tree.graph;

class MyTreeNode {

  public int val;
  public MyTreeNode left;
  public MyTreeNode right;
  public MyTreeNode parant;

}

public class Exam_4_6 {

  public MyTreeNode getNext(MyTreeNode node) {
    if (node == null) {
      return null;
    }
    if (node.right != null) {
      MyTreeNode toFind = node.right;
      MyTreeNode toFind_left = toFind.left;
      while (toFind_left != null) {
        toFind = toFind_left;
        toFind_left = toFind_left.left;
      }
      return toFind;
    }
    MyTreeNode parant = node.parant;
    if (parant != null) {
      if (parant.left == node) { // 如果是左节点，则父节点就是下一个
        return parant;
      } else { // 如果是右节点，则找到一个父节点且为左节点的
        parant = parant.parant;
        while (parant != null) {
          MyTreeNode grandParanent = parant.parant;
          if (grandParanent == null) {
            return null;
          }
          if (grandParanent.left == parant) {
            return parant;
          }
          parant = parant.parant;
        }
      }
    }
    return null;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
