package career04.tree.graph;

public class Exam_4_9 {

	
	public static void printFromRoot(TreeNode root, int val){
		if(root==null){
			return ;
		}
		TreeNode node = root;
			
	}
	
	public static  int  getResult(TreeNode from){
		if(from==null)
			return 0;
		return from.val + getResult(from.left);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
