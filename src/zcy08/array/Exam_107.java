package zcy08.array;

public class Exam_107 {

	public static void printArray(int[][] a){
		if(a==null || a.length==0 || a[0].length==0){
			return;
		}
		int m = a.length;
		int n = a[0].length;
		
		
		for(int i=0;i<(m+1)/2;i++){
			for(int j=i;j<=n-1-i;j++){
			   System.out.print( a[i][j]+ "\t");	
			}
			for(int j=i+1;j<=n-1-i;j++){
				System.out.print( a[j][n-1-i]+ "\t");	
			}
			for(int j=n-1-i-1;j>=i;j--){
				System.out.print( a[n-1-i][j]+ "\t");	
			}
			for(int j=n-1-i-1;j>i;j--){
				System.out.print( a[j][i]+ "\t");	
			}
		}
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		
		for(int i =0 ;i<a.length;i++){
			for(int j =0 ;j<a[0].length;j++){
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
		
		printArray(a);
		
		System.out.println();
		int[][] b  ={{1,2,3,4,21},{5,6,7,8,22},{9,10,11,12,23},{13,14,15,16,24},{25,26,27,28,29}};
		for(int i =0 ;i<b.length;i++){
			for(int j =0 ;j<b[0].length;j++){
				System.out.print(b[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
		
		printArray(b);
		
		 
	}

}
