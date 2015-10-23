package leetcode11.dynamicprogram;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Exam_68 {

	public static List<Integer> longest_Increasing_Subsquence(int[] a) {
		if (a == null || a.length == 0) {
			return Collections.emptyList();
		}

		List<Integer> result = new LinkedList<>();

		Map<Integer, Integer> path = new HashMap<>();

		int[] dp = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			dp[i] = 1;
		}

		int maxCount = 0;
		int endIndex = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[j] <= a[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					if (maxCount < dp[i]) {						
						maxCount = dp[i];
						path.put(i, j);
						endIndex = i;
					}
				}
			}
		}

//		Integer index = endIndex;
//		while (!path.isEmpty()) {
//			if (index != null) {
//				result.add(a[index]);
//			}
//			index = path.remove(index);
//		}
//		Collections.sort(result);
		System.out.println("maxCount:"+maxCount);
		int k = a.length -1;
		while(k>=0){
			while(k>endIndex){
				result.add(a[k]);
				k--;
				
			}
			k--;
			if(path.containsKey(endIndex)){
				endIndex = path.get(endIndex);
			}
			else{
				endIndex = -1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Random r = new Random();
		int N = 20;
		int[] array = new int[N];
		System.out.println();
		for (int i = 0; i < N; i++) {
			array[i] = r.nextInt(20);
			System.out.print(array[i] + ", ");
		}
		System.out.println();
		List<Integer> result = longest_Increasing_Subsquence(array);
		System.out.println(result);

	}

}
