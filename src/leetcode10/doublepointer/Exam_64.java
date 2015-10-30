package leetcode10.doublepointer;

public class Exam_64 {

	public static boolean jump(int[] array) {
		if (array == null || array.length < 1) {
			return true;
		}
		int currmax = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] == 0 && currmax < i + 1) {
				return false;
			}
			if (array[i] > 0 && currmax < array[i] + i) {
				currmax = array[i] + i;
				if (currmax > array.length - 1) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	public static int minJump(int[] array) {
		if (array == null || array.length < 1) {
			return 1;
		}
		int count = 0;
		int last = 0;
		int curr  = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (i>last) {
				last=curr;
				count++;
			} 
			curr = Math.max(curr, i+array[i]);
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
