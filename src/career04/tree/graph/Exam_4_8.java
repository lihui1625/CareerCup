package career04.tree.graph;

import java.util.LinkedList;
import java.util.List;

public class Exam_4_8 {

	public static boolean isSubTree(TreeNode t1, TreeNode t2) {
		if (t1 == null || t2 == null) {
			return false;
		}
		List<TreeNode> list = getTreeNode(t1, t2.val);
		for(TreeNode tn : list){
			if(isequal(tn, t2)){
				return true;
			};
		}
		return false;

	}

	private static boolean isequal(TreeNode tn, TreeNode t2) {
		if(tn==null && t2==null){
			return true;
		}
		if(tn==null || t2!=null){
			return false;
		}
		if(tn.val != t2.val){
			return false;
		}
		 
		return isequal(tn.left, t2.left) && isequal(tn.right, t2.right);
	}

	private static List<TreeNode> getTreeNode(TreeNode t1, int val) {
		List<TreeNode> list = new LinkedList<>();
		if (t1 == null) {
			return list;
		}

		TreeNode node = t1;
		while (node != null) {
			if (val == node.val) {
				list.add(node);
				TreeNode left = node.left;
				while (left != null) {
					if (val == left.val) {
						list.add(left);
					}
					left = left.left;
				}
				break;
			} else if (val > node.val) {
				node = node.left;
			} else {
				node = node.right;
			}
		}

		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
