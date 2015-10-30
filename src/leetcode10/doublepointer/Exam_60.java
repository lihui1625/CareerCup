package leetcode10.doublepointer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Exam_60 {

	public static LinkedList<Integer> reomveDuplated(int[] a) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		int p = 0;
		while (p < a.length) {
			int first = a[p];
			while (p < a.length && a[p] == first) {
				p++;
			}
			list.add(first);
		}

		return list;
	}

	public static LinkedList<Integer> reomveMoreTan2(int[] a) {
		LinkedList<Integer> list = new LinkedList<Integer>();

		for (int p1 = 0, p2 = p1; p2 < a.length; p2++) {

			int num = 0;
			while (p2 < a.length && a[p2] == a[p1]) {
				p2++;
				num++;
				if (num < 2) {
					list.add(a[p1]);
				}
			}
			list.add(a[p1]);
			p1 = p2;
		}
		
		int p = 0;
		while (p < a.length) {
			int first = a[p];
			int num = 0;
			while (p < a.length && a[p] == first) { 
				if (num < 2) {
					list.add(first);
				}
				num++;
				p++;
			} 
		}

		return list;
	}

	public static void main(String[] args) {
		Random r = new Random();
		int N = 30;
		int[] im = new int[N];
		for (int i = 0; i < N; i++) {
			im[i] = r.nextInt(10);
		}
		Arrays.sort(im);

		System.out.println(Arrays.toString(im));

		System.out.println("--------------------");

		System.out.println(reomveDuplated(im));
		System.out.println(reomveMoreTan2(im));

	}

}
