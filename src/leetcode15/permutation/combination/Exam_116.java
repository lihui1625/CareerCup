package leetcode15.permutation.combination;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Exam_116 {

	public static int[] getNum(String str) {
		if (str == null || str.length() < 2 || str.length() > 10) {
			throw new RuntimeException("error");
		}
		int[] res = new int[str.length() + 1];
        Set<Integer> usedSet = new HashSet<>();
		
        res[0] = 1;
		int mim = res[0];
		usedSet.add(res[0]);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'I') {
				int tmp = res[i] + 1;
				while (usedSet.contains(tmp)) {
					tmp++;
				}
				res[i + 1] = tmp;
				usedSet.add(tmp);
			} else {
				int tmp = res[i] - 1;
				while (usedSet.contains(tmp)) {
					tmp--;
				}
				res[i + 1] = tmp;
				usedSet.add(tmp);
				mim = Math.min(mim, tmp);
			}
		}
		if (mim < 0) {
			for (int i = 0; i < res.length; i++) {
				res[i] = res[i] - mim;
			}

		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(getNum("DDIIDI")));

	}

}
