package zcy05.string;

public class Exam_080 {

	public static int binarySearch(String[] array, String a) {
		if (array == null || array.length == 0 || a == null || a.length() == 0) {
			return -1;
		}

		return binarySearch(array, a, 0, array.length - 1);
	}

	public static int binarySearch(String[] array, String a, int start, int end) {
		if (start > end) {
			return -1;
		}

		int mid = (start + end) / 2;
		int oldMid = mid;
		while (array[mid] == null && mid > start) {
			mid--;
		}
		if (array[mid] == null || array[mid].compareTo(a) < 0) {
			return binarySearch(array, a, oldMid + 1, end);
		} else if (array[mid].compareTo(a) > 0) {
			return binarySearch(array, a, start, mid - 1);
		} else {
			return mid;
		}
	}

	public static int binarySearch2(String[] array, String a) {
		if (array == null || array.length == 0 || a == null || a.length() == 0) {
			return -1;
		}

		return binarySearch2(array, a, 0, array.length - 1);
	}

	public static int binarySearch2(String[] array, String a, int start, int end) {
		if (start > end) {
			return -1;
		}

		int mid = (start + end) / 2;
		int oldMid = mid;
		while (array[mid] == null && mid < end) {
			mid++;
		}
		if (array[mid] == null || array[mid].compareTo(a) > 0) {
			return binarySearch(array, a, start, oldMid - 1);
		} else if (array[mid].compareTo(a) < 0) {
			return binarySearch(array, a, mid + 1, end);
		} else {
			return mid;
		}
	}

	public static void main(String[] args) {
		String[] a = new String[] { null, "a", null, null, null, "b", null,
				null, "c", null, "d", "e", null, null, null, null, null, null,
				null, null, "f", null, "g", "h", null, null, null, null, null,
				"i", "j", null, null, null, null, null, null, "k", null, null,
				null, null, null, null, null, null };
		System.out.println(binarySearch(a, "a"));
		System.out.println(binarySearch(a, "b"));
		System.out.println(binarySearch(a, "c"));
		System.out.println(binarySearch(a, "d"));
		System.out.println(binarySearch(a, "e"));
		System.out.println(binarySearch(a, "f"));
		System.out.println(binarySearch(a, "g"));
		System.out.println(binarySearch(a, "h"));
		System.out.println(binarySearch(a, "i"));
		System.out.println(binarySearch(a, "j"));
		System.out.println(binarySearch(a, "k"));
		System.out.println(binarySearch(a, "l"));

		System.out.println(binarySearch2(a, "a"));
		System.out.println(binarySearch2(a, "b"));
		System.out.println(binarySearch2(a, "c"));
		System.out.println(binarySearch2(a, "d"));
		System.out.println(binarySearch2(a, "e"));
		System.out.println(binarySearch2(a, "f"));
		System.out.println(binarySearch2(a, "g"));
		System.out.println(binarySearch2(a, "h"));
		System.out.println(binarySearch2(a, "i"));
		System.out.println(binarySearch2(a, "j"));
		System.out.println(binarySearch2(a, "k"));
		System.out.println(binarySearch2(a, "l"));

	}

}
