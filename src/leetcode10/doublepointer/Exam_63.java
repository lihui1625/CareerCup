package leetcode10.doublepointer;

import java.util.Arrays;
import java.util.Random;

public class Exam_63 {

	public static int[] sort3(int[] a) {
		int num0 = 0;
		int num1 = 0;
		int num2 = 0;
		for (int i : a) {
			if (i == 0)
				num0++;
			else if (i == 1)
				num1++;
			else if (i == 2)
				num2++;
		}
		int[] b = new int[a.length];
		for (int i = 0; i < b.length; i++) {
			b[i] = (i < num0) ? 0 : ((i < num1 + num0) ? 1 : 2);
		}
		return b;
	}

	public static void sort3_2(int[] a) {
		int p1 = 0;
		int p2 = a.length;
		for (int i = 0; i < a.length; i++) {
			if (i == p2) {
				break;
			}
			if (a[i] == 0) {				
				swap(a, i, p1);
				p1++;
			} else if (a[i] == 2) {
				p2--;
				swap(a, i, p2);
			    i--;
			}
		}
	}

	private static void swap(int[] a, int i, int j) {
		a[i] = a[i] + a[j];
		a[j] = a[i] - a[j];
		a[i] = a[i] - a[j];
	}

	public static void main(String[] args) {
		Random r = new Random();
		int N = 20;
		int[] im = new int[N];
		for (int i = 0; i < N; i++) {
			im[i] = r.nextInt(3);
		}
		System.out.println(Arrays.toString(im));
		System.out.println(Arrays.toString(sort3(im)));
		sort3_2(im);
		System.out.println(Arrays.toString(im));
	}

}
