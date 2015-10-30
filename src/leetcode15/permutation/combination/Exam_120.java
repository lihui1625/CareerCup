package leetcode15.permutation.combination;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Exam_120 {

	public static int nextPermutat(int num) {
		LinkedList<Integer> list = new LinkedList<>();
		while (num > 0) {
			int p = num % 10;
			num = num / 10;
			list.addFirst(p);
		}
		int pivot = -1;
		for (int i = list.size() - 1; i > 0; i--) {
			if (list.get(i) > list.get(i - 1)) {
				pivot = i - 1;
				break;
			}
		}
		if (pivot > 0) {
			int tmp = list.get(list.size() - 1);
			list.set(list.size() - 1, list.get(pivot));
			list.set(pivot, tmp);
			int d = 0;
			int carray = 1;
			for (int i = 0; i < list.size(); i++) {
				int index = list.size() - 1 - i;
				d += list.get(index) * carray;
				carray = carray * 10;
			}
			return d;
		} else {
			int d = 0;
			int carray = 1;
			for (int i = 0; i < list.size(); i++) {
				d += list.get(i) * carray;
				carray = carray * 10;
			}
			return d;
		}

	}

	public static void main(String[] args) {
		System.out.println(nextPermutat(231));
		System.out.println(nextPermutat(123));
		System.out.println(nextPermutat(321));
		System.out.println(nextPermutat(213));
		System.out.println(nextPermutat(312));

	}

}
