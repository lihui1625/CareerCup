package career04.tree.graph;


public class Exam_4_7 {
	
	public static TreeNode getCommonParant(TreeNode root, TreeNode t1, TreeNode t2){
		if(root==null){
			return null;
		}
		TreeNode node = root;
		while(node!=null){
			if(node.val >= t1.val && node.val >= t2.val){
				node = node.left;
			}
			if(node.val < t1.val && node.val < t2.val){
				node = node.right;
			}
			else{
				return node;
			}			
		} 
		return null;
	}
	
	public static TreeNode getCommonParant2(TreeNode root, TreeNode t1, TreeNode t2){
		if(root==null){
			return null;
		}
		TreeNode node = root;
		while(node!=null){
			if(node.val >= t1.val && node.val >= t2.val){
				node = node.left;
			}
			if(node.val < t1.val && node.val < t2.val){
				node = node.right;
			}
			else{
				return node;
			}			
		} 
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
