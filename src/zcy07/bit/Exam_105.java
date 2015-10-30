package zcy07.bit;

public class Exam_105 {
	
	public static int findNum(int[] a){
		if(a==null || a.length<1){
			throw new IllegalArgumentException(" a can't be null or empty ");
		}
		int res = a[0];
		for(int i=1; i< a.length; i++){
			res ^=  a[i];
		}
		return res;
	}

	public static void main(String[] args) {
		int[] a = {13,13,14,18,14,15,15};
        System.out.println(findNum(a));
	}

}
