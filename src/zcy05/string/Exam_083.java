package zcy05.string;

public class Exam_083 {

	public static int minDist(String[] array, String s1, String s2) {
		if (s1 == null || s2 == null) {
			return -1;
		}
		if (s1.equals(s2)) {
			return 0;
		}
		int min = -1;
		int s1Index = -1;
		int s2Index = -1;
		for (int i = 0; i < array.length; i++) {
			if (s1.equals(array[i])) {
				s1Index = i;
			} else if (s2.equals(array[i])) {
				s2Index = i;
			}
			if (s1Index != -1 && s2Index != -1) {
				int dist = Math.abs(s2Index - s1Index);
				if (min == -1 || dist < min) {
					min = dist;
				}
			}
		}
		System.out.println(s1Index + "-->" + s2Index);
		return min;
	}

	public static void main(String[] args) {
		String[] array = { "a", "b", "c", "c", "b", "a", "a", "c" };
		System.out.println(minDist(array, "a", "c"));

	}

}
